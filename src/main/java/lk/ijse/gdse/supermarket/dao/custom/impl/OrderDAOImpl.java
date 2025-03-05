package lk.ijse.gdse.supermarket.dao.custom.impl;

import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.custom.OrderDAO;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.entity.Order;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/26/2025 3:21 PM
 * Project: Supermarket-72
 * --------------------------------------------
 **/

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean save(Order order) {
        // new session
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) {
        return false;
    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Optional<Order> findByPK(String pk) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Order order = session.get(Order.class, pk);
        return Optional.ofNullable(order);
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }

    @Override
    public boolean saveOrderWIthOrderDetails(Session session, Order order) {
        try {
            // data if exist update, no data save
            session.merge(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
