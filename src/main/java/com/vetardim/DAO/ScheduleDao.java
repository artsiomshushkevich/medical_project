package com.vetardim.DAO;

import com.vetardim.model.Schedule;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class ScheduleDao {

    public static void addOrUpdateSchedule(Schedule schedule) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(schedule);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteSchedule(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Schedule schedule = session.get(Schedule.class, id);

            if (schedule != null) {
                session.delete(schedule);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Schedule> getSchedulesListByDoctorId(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Schedule> schedulesList = null;
        try {
            Criteria criteria = session.createCriteria(Schedule.class);
            criteria.add(Restrictions.eq("doctorId", id));
            schedulesList = (List<Schedule>)criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return schedulesList;
    }

    public static List<Schedule> getSchedulesList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Schedule> schedulesList = null;
        try {
            schedulesList = (List<Schedule>)session.createCriteria(Schedule.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return schedulesList;
    }
}
