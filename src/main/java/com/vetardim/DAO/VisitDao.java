package com.vetardim.DAO;

import com.vetardim.model.Visit;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


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

    public static List<Visit> getVisitsListByMedicalHistoryId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Visit> visitsList = null;
        try {
            Criteria criteria = session.createCriteria(Visit.class);
            criteria.add(Restrictions.eq("medicalHistoryId", id));
            visitsList = (List<Visit>)criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return visitsList;
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

    public static Visit getVisitByOrderId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Visit visit = null;
        try {
            Criteria criteria = session.createCriteria(Visit.class);
            criteria.add(Restrictions.eq("orderId", id));
            visit = (Visit)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return visit;
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
        } finally {
            session.close();
        }

        return visitsList;
    }
}

