package lk.ijse.gdse.supermarket.dao.custom.impl;

import lk.ijse.gdse.supermarket.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.entity.OrderDetails;

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

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean save(OrderDetails orderDetails) {
        return false;
    }

    @Override
    public boolean update(OrderDetails orderDetails) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) {
        return false;
    }

    @Override
    public List<OrderDetails> getAll() {
        return List.of();
    }

    @Override
    public Optional<OrderDetails> findByPK(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
