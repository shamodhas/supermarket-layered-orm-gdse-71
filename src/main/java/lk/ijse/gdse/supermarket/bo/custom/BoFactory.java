package lk.ijse.gdse.supermarket.bo.custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.bo.custom.impl.CustomerBOImpl;
import lk.ijse.gdse.supermarket.bo.custom.impl.ItemBOImpl;
import lk.ijse.gdse.supermarket.bo.custom.impl.PlaceOrderBOImpl;

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

public class BoFactory {
    public static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    @SuppressWarnings("unchecked")
    public <T extends SuperBO>T getBO(BoTypes boTypes){
        return  switch (boTypes){
            case CUSTOMER -> (T) new CustomerBOImpl();
            case ITEM -> (T) new ItemBOImpl();
            case PLACE_ORDER -> (T) new PlaceOrderBOImpl();
        };
    }
}
