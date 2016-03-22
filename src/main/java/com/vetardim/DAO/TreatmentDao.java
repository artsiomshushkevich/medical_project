package com.vetardim.DAO;

import com.vetardim.model.Treatment;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

/**
 * Created by artsiom on 07.03.2016.
 */

public class TreatmentDao {


    public static void addTreatment(Treatment treatment) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(treatment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateTreatment(Treatment treatment) {
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
        }

        return treatmentsList;
    }
}

