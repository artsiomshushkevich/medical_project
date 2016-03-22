package com.vetardim.DAO;

import com.vetardim.model.Specialization;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

public class SpecializationDao {


    public static void addSpecialization(Specialization specialization) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(specialization);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateSpecialization(Specialization specialization) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(specialization);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteSpecialization(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Specialization specialization = session.get(Specialization.class, id);

            if (specialization != null) {
                session.delete(specialization);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Specialization> getSpecializationsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Specialization> specializationsList = null;
        try {
            specializationsList = (List<Specialization>)session.createCriteria(Specialization.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return specializationsList;
    }
}
