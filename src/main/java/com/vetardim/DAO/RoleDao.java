package com.vetardim.DAO;

import com.vetardim.model.Role;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


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

    public static Role getRoleById(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Role role = null;
        try {
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("id", id));
            role = (Role)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return role;
    }

}

