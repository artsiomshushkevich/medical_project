package com.vetardim.DAO;

import com.vetardim.model.Department;
import com.vetardim.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class DepartmentDao {

    public static void addOrUpdateDepartment(Department department) {
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

    public static Department getDepartmentById(int id) {
        Session session = HibernateUtil.makeSession();
        session.beginTransaction();
        Department department = null;
        try {
            Criteria criteria = session.createCriteria(Department.class);
            criteria.add(Restrictions.eq("id", id));
            department = (Department)criteria.uniqueResult();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return department;
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
        } finally {
            session.close();
        }

        return departmentsList;
    }
}
