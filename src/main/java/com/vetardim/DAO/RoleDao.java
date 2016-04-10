package com.vetardim.DAO;

import com.vetardim.model.Role;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class RoleDao {

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
        } finally {
            session.close();
        }

        return rolesList;
    }

}

