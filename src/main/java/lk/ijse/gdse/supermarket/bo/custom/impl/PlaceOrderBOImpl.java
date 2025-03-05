package lk.ijse.gdse.supermarket.bo.custom.impl;

import lk.ijse.gdse.supermarket.bo.custom.PlaceOrderBO;
import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.DaoFactory;
import lk.ijse.gdse.supermarket.dao.DaoTypes;
import lk.ijse.gdse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.gdse.supermarket.dao.custom.ItemDAO;
import lk.ijse.gdse.supermarket.dao.custom.OrderDAO;
import lk.ijse.gdse.supermarket.dto.OrderDTO;
import lk.ijse.gdse.supermarket.dto.OrderDetailsDTO;
import lk.ijse.gdse.supermarket.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 3/5/2025 11:58 AM
 * Project: Supermarket-layered-71
 * --------------------------------------------
 **/

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO = DaoFactory.getInstance().getDAO(DaoTypes.ORDERS);
    CustomerDAO customerDAO = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER);
    ItemDAO itemDAO = DaoFactory.getInstance().getDAO(DaoTypes.ITEM);

    @Override
    public boolean placeOrder(OrderDTO orderDTO) {
        // transaction
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // save order,orderdetails, update item
            String orderId = orderDTO.getOrderId();

            // check order id exist
            Optional<Order> optionalOrder = orderDAO.findByPK(orderId);
            if (optionalOrder.isPresent()) {
                transaction.rollback();
                return false;
            }

            String customerId = orderDTO.getCustomerId();
            Optional<Customer> optionalCustomer = customerDAO.findByPK(customerId);
            if (optionalCustomer.isEmpty()) {
                transaction.rollback();
                return false;
            }

            Customer customer = optionalCustomer.get();

            // need validate date

            Order order = new Order();
            order.setId(orderId);
            order.setDate(orderDTO.getOrderDate());
            order.setCustomer(customer);

            List<OrderDetails> orderDetailsList = new ArrayList<>();

            ArrayList<OrderDetailsDTO> orderDetailsDTOS = orderDTO.getOrderDetailsDTOS();
            for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
                String itemId = orderDetailsDTO.getItemId();

                Optional<Item> optionalItem = itemDAO.findByPK(itemId);

                if (optionalItem.isEmpty()) {
                    // item not found
                    transaction.rollback();
                    return false;
                }

                Item item = optionalItem.get();

                OrderDetailsId orderDetailsId = new OrderDetailsId(orderId, itemId);

                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setId(orderDetailsId);
                orderDetails.setOrder(order);
                orderDetails.setItem(item);
                orderDetails.setQty(orderDetailsDTO.getQuantity());
                orderDetails.setUnitPrice(BigDecimal.valueOf(orderDetailsDTO.getPrice()));

                orderDetailsList.add(orderDetails);
            }

            order.setOrderDetails(orderDetailsList);

            // save order -> orderdetails
            // order, session
            boolean isOrderSaved = orderDAO.saveOrderWIthOrderDetails(session, order);
            if (!isOrderSaved) {
                transaction.rollback();
                return false;
            }

            for (OrderDetails orderDetails : orderDetailsList) {
                String itemId = orderDetails.getItem().getId();
                Optional<Item> optionalItem = itemDAO.findByPK(itemId);

                if (optionalItem.isEmpty()) {
                    transaction.rollback();
                    return false;
                }

                Item item = optionalItem.get();

                // item qty > order details qty
                if (item.getQuantity() < orderDetails.getQty()) {
                    // 5 < 10
                    transaction.rollback();
                    return false;
                }

                item.setQuantity(item.getQuantity() - orderDetails.getQty());

                // item, session
                boolean isItemUpdated = itemDAO.updateItemWithOrder(session, item);
                if (!isItemUpdated) {
                    transaction.rollback();
                    return false;
                }
            }

            transaction.commit();
            return true;

        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
