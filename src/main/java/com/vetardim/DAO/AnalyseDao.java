package com.vetardim.DAO;

import com.vetardim.model.Analyse;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class AnalyseDao {

    public static void addOrUpdateAnalyse(Analyse analyse) {
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

    public static List<Analyse> getAnalysesListByClientId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Analyse> analysesList = null;
        try {
            Criteria criteria = session.createCriteria(Analyse.class);
            criteria.add(Restrictions.eq("clientId", id));
            analysesList = (List<Analyse>)criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return analysesList;
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
        } finally {
            session.close();
        }

        return analysesList;
    }


    public static Analyse getAnalyseById(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Analyse analyse = null;
        try {
            Criteria criteria = session.createCriteria(Analyse.class);
            criteria.add(Restrictions.eq("id", id));
            analyse = (Analyse)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return analyse;
    }
}
