package com.vetardim.DAO;

import com.vetardim.model.Prescription;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;


public class PrescriptionDao {


    public static void addPrescription(Prescription prescription) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(prescription);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updatePrescription(Prescription prescription) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(prescription);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deletePrescription(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Prescription prescription = session.get(Prescription.class, id);

            if (prescription != null) {
                session.delete(prescription);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Prescription> getPrescriptionsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Prescription> prescriptionsList = null;
        try {
            prescriptionsList = (List<Prescription>)session.createCriteria(Prescription.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return prescriptionsList;
    }
}
