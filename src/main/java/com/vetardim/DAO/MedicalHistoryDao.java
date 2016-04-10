package com.vetardim.DAO;

import com.vetardim.model.MedicalHistory;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class MedicalHistoryDao {

    public static void addOrUpdateMedicalHistory(MedicalHistory medicalHistory) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(medicalHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteMedicalHistory(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            MedicalHistory medicalHistory = session.get(MedicalHistory.class, id);

            if (medicalHistory != null) {
                session.delete(medicalHistory);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<MedicalHistory> getMedicalHistoriesList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<MedicalHistory> medicalHistoriesList = null;
        try {
            medicalHistoriesList = (List<MedicalHistory>)session.createCriteria(MedicalHistory.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return medicalHistoriesList;
    }
}
