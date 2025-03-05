package lk.ijse.gdse.supermarket.dao.custom.impl;

import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.custom.ItemDAO;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.entity.Item;
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

public class ItemDAOImpl implements ItemDAO {


    @Override
    public boolean save(Item item) {
        return false;
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean deleteByPK(String pk) {
        return false;
    }

    @Override
    public List<Item> getAll() {
        return List.of();
    }

    @Override
    public Optional<Item> findByPK(String pk) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Item item = session.get(Item.class, pk);
        session.close();
        if (item == null) {
            return Optional.empty();
        }
        return Optional.of(item);
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }

    @Override
    public boolean updateItemWithOrder(Session session, Item item) {
        try {
            session.merge(item);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
