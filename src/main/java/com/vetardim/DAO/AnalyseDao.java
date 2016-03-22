package com.vetardim.DAO;

import com.vetardim.model.Analyse;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class AnalyseDao {

    public static void addAnalyse(Analyse analyse) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(analyse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateAnalyse(Analyse analyse) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(analyse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteAnalyse(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Analyse analyse = session.get(Analyse.class, id);

            if (analyse != null) {
                session.delete(analyse);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Analyse> getAnalysesList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Analyse> analysesList = null;
        try {
            analysesList = (List<Analyse>)session.createCriteria(Analyse.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return analysesList;
    }
}
