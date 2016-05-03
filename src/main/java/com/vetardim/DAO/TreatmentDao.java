package com.vetardim.DAO;

import com.vetardim.model.Treatment;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class TreatmentDao {

    public static void addOrUpdateTreatment(Treatment treatment) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(treatment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteTreatment(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Treatment treatment = session.get(Treatment.class, id);

            if (treatment != null) {
                session.delete(treatment);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Treatment> getTreatmentsListByVisitId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Treatment> treatmentsList = null;
        try {
            Criteria criteria = session.createCriteria(Treatment.class);
            criteria.add(Restrictions.eq("visitId", id));
            treatmentsList = (List<Treatment>)criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return treatmentsList;
    }

    public static List<Treatment> getTreatmentsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Treatment> treatmentsList = null;
        try {
            treatmentsList = (List<Treatment>)session.createCriteria(Treatment.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return treatmentsList;
    }

    public static Treatment getTreatmentById(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Treatment treatment = null;
        try {
            Criteria criteria = session.createCriteria(Treatment.class);
            criteria.add(Restrictions.eq("id", id));
            treatment = (Treatment) criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return treatment;
    }
}

