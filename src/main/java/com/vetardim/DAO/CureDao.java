package com.vetardim.DAO;

import com.vetardim.model.Cure;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class CureDao {

    public static void addOrUpdateCure(Cure cure) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(cure);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteCure(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Cure cure = session.get(Cure.class, id);

            if (cure != null) {
                session.delete(cure);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Cure> getCuresList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Cure> curesList = null;
        try {
            curesList = (List<Cure>)session.createCriteria(Cure.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return curesList;
    }
}
