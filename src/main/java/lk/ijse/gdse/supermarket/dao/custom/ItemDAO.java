package lk.ijse.gdse.supermarket.dao.custom;

import lk.ijse.gdse.supermarket.dao.CrudDAO;
import lk.ijse.gdse.supermarket.entity.Customer;
import lk.ijse.gdse.supermarket.entity.Item;
import org.hibernate.Session;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/26/2025 3:02 PM
 * Project: Supermarket-72
 * --------------------------------------------
 **/

// Item
public interface ItemDAO extends CrudDAO<Item,String> {
    public boolean updateItemWithOrder(Session session, Item item);
}
