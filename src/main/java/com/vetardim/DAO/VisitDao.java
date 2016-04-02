package com.vetardim.DAO;

import com.vetardim.model.Visit;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class VisitDao {

    public static void addOrUpdateVisit(Visit visit) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(visit);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteVisit(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Visit visit = session.get(Visit.class, id);

            if (visit != null) {
                session.delete(visit);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Visit> getVisitsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Visit> visitsList = null;
        try {
            visitsList = (List<Visit>)session.createCriteria(Visit.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return visitsList;
    }
}

