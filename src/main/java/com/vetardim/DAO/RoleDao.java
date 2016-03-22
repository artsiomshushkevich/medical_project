package com.vetardim.DAO;

import com.vetardim.model.Role;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;


public class RoleDao {


    public static void addRole(Role role) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateRole(Role role) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteRole(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Role role = session.get(Role.class, id);

            if (role != null) {
                session.delete(role);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Role> getRolesList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Role> rolesList = null;
        try {
            rolesList = (List<Role>)session.createCriteria(Role.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return rolesList;
    }
}

