package lk.ijse.gdse.supermarket;

import org.hibernate.Session;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 3/5/2025 3:03 PM
 * Project: Supermarket-layered-71
 * --------------------------------------------
 **/

public class Query {
    public static void main(String[] args) {
//        Session session = FactoryConfiguration.getInstance().getSession();
//
////        Native SQL
////          Raw SQL queries directly on database tables
////        HQL
////          Object-oriented query language for Hibernate
////        JPQL
////          Object-oriented query language for JPA
//
//        // Native SQL
//        // select * from customer_table
//        // work with table name
//        // select * from customer_table where customer_name='bob'
//        // work with column names
//
//        // HQL - Hibernate Query Language
//        // JPQL - Java Persistence Query Language
//        // HQL, JPQL ( both work as same)
//        // FROM Customer
//        // work with entity class name
//        // FROM Customer WHERE name='bob'
//        // work with properties
//        // base on object-oriented
//
//        // select * from customer_table
////        Query<Customer> query = session.createQuery("SELECT c FROM Customer c", Customer.class);
////        List<Customer> customers = query.list();
//
//        // select * from customer_table where customer_name='bob'
////        Query<Customer> query = session.createQuery("SELECT c FROM Customer c WHERE c.name='bob'", Customer.class);
////        List<Customer> customers = query.list();
//
//        // Parameters
//        // SELECT c FROM Customer c WHERE c.name=?
//        // setObject(1, 'bob')
////        Query<Customer> query = session.createQuery("SELECT c FROM Customer c WHERE c.name= :hello", Customer.class);
////        query.setParameter("hello", "bob");
////        List<Customer> customers = query.list();
//
//        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        // Native SQL Queries (SQL)
//
//        // wrong
//        // createQuery - can't use
////        Query<Customer> query = session.createQuery("select * from customer_table", Customer.class);
//
////        Query<Customer> query = session.createNativeQuery("select * from customer_table", Customer.class);
//
////        Query<Customer> query = session.createNativeQuery("select * from customer_table")
////                .addEntity(Customer.class);
////        List<Customer> customers = query.list();
//
//        org.hibernate.query.Query query = session.createNativeQuery("select * from customer_table");
//        List<Object[]> list = query.list();
//        // object array list
//
//        for (Object[] objects : list) {
//            for (int i = 0; i < objects.length; i++) {
//                System.out.println(i + " : " + objects[i]);
//            }
//
////            Customer customer = new Customer();
//////            customer.setId(Integer.parseInt((String) objects[0]));
////            customer.setName((String) objects[2]);
////            customer.setEmail((String) objects[1]);
////            System.out.println(customer);
//        }
//
//
////            for (Customer customer : customers) {
////                System.out.println(customer);
////            }
//
//        session.close();
    }
}
