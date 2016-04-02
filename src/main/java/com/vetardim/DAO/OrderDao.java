package com.vetardim.DAO;

import com.vetardim.model.Order;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class OrderDao {

    public static void addOrUpdateOrder(Order order) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteOrder(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Order order = session.get(Order.class, id);

            if (order != null) {
                session.delete(order);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Order> getOrdersList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Order> ordersList = null;
        try {
            ordersList = (List<Order>)session.createCriteria(Order.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return ordersList;
    }
}
