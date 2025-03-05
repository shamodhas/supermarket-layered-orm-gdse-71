package lk.ijse.gdse.supermarket.bo.custom.impl;

import lk.ijse.gdse.supermarket.bo.custom.CustomerBO;
import lk.ijse.gdse.supermarket.bo.exeception.DuplicateException;
import lk.ijse.gdse.supermarket.bo.exeception.NotFoundException;
import lk.ijse.gdse.supermarket.dao.DaoFactory;
import lk.ijse.gdse.supermarket.dao.DaoTypes;
import lk.ijse.gdse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.gdse.supermarket.entity.Customer;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 3/5/2025 11:57 AM
 * Project: Supermarket-layered-71
 * --------------------------------------------
 **/

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER);

    @Override
    public boolean deleteCustomer(String cusId) {
        try {
            customerDAO.save(new Customer());
        }catch (DuplicateException e){
            // customer id duplicate
        }

        try {
            customerDAO.deleteByPK(cusId);
        }catch (NotFoundException e){
            // e.getMessage()
            //
        }catch (Exception e){

        }
        return false;
    }
}
