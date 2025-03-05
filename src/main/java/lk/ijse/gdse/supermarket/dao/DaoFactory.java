package lk.ijse.gdse.supermarket.dao;

import lk.ijse.gdse.supermarket.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.gdse.supermarket.dao.custom.impl.ItemDAOImpl;
import lk.ijse.gdse.supermarket.dao.custom.impl.OrderDAOImpl;
import lk.ijse.gdse.supermarket.dao.custom.impl.OrderDetailsDAOImpl;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/26/2025 3:00 PM
 * Project: Supermarket-72
 * --------------------------------------------
 **/

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory == null ? (daoFactory = new DaoFactory()) : daoFactory;
    }

    //    SuperDAO
    @SuppressWarnings("unchecked")
    // prevent compiler warning about unchecked type casting
    public <T extends SuperDAO> T getDAO(DaoTypes daoTypes) {
        return switch (daoTypes) {
            case CUSTOMER -> (T) new CustomerDAOImpl();
            case ITEM -> (T) new ItemDAOImpl();
            case ORDERS -> (T) new OrderDAOImpl();
            case ORDER_DETAILS -> (T) new OrderDetailsDAOImpl();
            default -> null;
        };
    }
}
