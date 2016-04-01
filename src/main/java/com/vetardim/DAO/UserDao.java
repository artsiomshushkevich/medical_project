package com.vetardim.DAO;

import com.vetardim.model.User;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class UserDao {

    public static void addOrUpdateUser(User user) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteUser(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            User user = session.get(User.class, id);

            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<User> getUsersList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<User> usersList = null;
        try {
            usersList = (List<User>)session.createCriteria(User.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return usersList;
    }
}
