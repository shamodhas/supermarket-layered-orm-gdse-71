package lk.ijse.gdse.supermarket.dao.custom.impl;

import lk.ijse.gdse.supermarket.bo.exeception.DuplicateException;
import lk.ijse.gdse.supermarket.bo.exeception.NotFoundException;
import lk.ijse.gdse.supermarket.config.FactoryConfiguration;
import lk.ijse.gdse.supermarket.dao.custom.CustomerDAO;
import lk.ijse.gdse.supermarket.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

public class CustomerDAOImpl implements CustomerDAO {
    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Customer customer) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // C001
            // C001
            Customer existsCustomer = session.get(Customer.class, customer.getId());
            if (existsCustomer != null) {
               throw new DuplicateException("Customer id duplicated");
            }

            session.persist(customer);
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

    @Override
    public boolean update(Customer customer) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(customer);
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

    @Override
    public boolean deleteByPK(String pk) throws Exception{
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Customer customer = session.get(Customer.class, pk);
            if (customer == null) {
                throw new NotFoundException("Customer not found");
            }
            // customer have order
            // In use

            session.remove(customer);
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

    @Override
    public List<Customer> getAll() {
        Session session = factoryConfiguration.getSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        return query.list();
    }

    @Override
    public Optional<Customer> findByPK(String pk) {
        Session session = factoryConfiguration.getSession();
        Customer customer = session.get(Customer.class, pk);
        session.close();
        if (customer == null) {
            return Optional.empty();
        }
        return Optional.of(customer);
    }

    @Override
    public Optional<String> getLastPK() {
        Session session = factoryConfiguration.getSession();

        String lastPk = session
                .createQuery("SELECT c.id FROM Customer c ORDER BY c.id DESC", String.class)
                .setMaxResults(1)
                .uniqueResult();

        return Optional.ofNullable(lastPk);
    }

}
