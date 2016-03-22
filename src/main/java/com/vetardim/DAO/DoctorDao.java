package com.vetardim.DAO;

import com.vetardim.model.Doctor;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

/**
 * Created by artsiom on 07.03.2016.
 */

public class DoctorDao {


    public static void addDoctor(Doctor doctor) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateDoctor(Doctor doctor) {
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
        }

        return doctorsList;
    }
}
