package com.vetardim.DAO;

import com.vetardim.model.Department;
import com.vetardim.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.List;

/**
 * Created by artsiom on 07.03.2016.
 */

public class DepartmentDao {


    public static void addDepartment(Department department) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    public static void updateDepartment(Department department) {
        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void deleteDepartment(int id) {

        Session session = HibernateUtil.makeSession();
        try {
            session.beginTransaction();
            Department department = session.get(Department.class, id);

            if (department != null) {
                session.delete(department);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    public static List<Department> getDepartmentsList() {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        List<Department> departmentsList = null;
        try {
            departmentsList = (List<Department>)session.createCriteria(Department.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return departmentsList;
    }
}
