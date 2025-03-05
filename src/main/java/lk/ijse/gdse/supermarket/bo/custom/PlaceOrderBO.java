package lk.ijse.gdse.supermarket.bo.custom;

import lk.ijse.gdse.supermarket.bo.SuperBO;
import lk.ijse.gdse.supermarket.dto.OrderDTO;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 3/5/2025 11:56 AM
 * Project: Supermarket-layered-71
 * --------------------------------------------
 **/

public interface PlaceOrderBO extends SuperBO {
    public boolean placeOrder(OrderDTO orderDTO);
}
