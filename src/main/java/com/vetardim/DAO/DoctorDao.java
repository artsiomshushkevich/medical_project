package com.vetardim.DAO;

import com.vetardim.model.Doctor;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class DoctorDao {

    public static void addOrUpdateDoctor(Doctor doctor) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(doctor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteDoctor(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);

            if (doctor != null) {
                session.delete(doctor);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static Doctor getDoctorByUserId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Doctor doctor = null;
        try {
            Criteria criteria = session.createCriteria(Doctor.class);
            criteria.add(Restrictions.eq("userId", id));
            doctor = (Doctor)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return doctor;
    }

    public static Doctor getDoctorById(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Doctor doctor = null;
        try {
            Criteria criteria = session.createCriteria(Doctor.class);
            criteria.add(Restrictions.eq("id", id));
            doctor = (Doctor)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return doctor;
    }

    public static List<Doctor> getDoctorsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Doctor> doctorsList = null;
        try {
            doctorsList = (List<Doctor>)session.createCriteria(Doctor.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return doctorsList;
    }
}
