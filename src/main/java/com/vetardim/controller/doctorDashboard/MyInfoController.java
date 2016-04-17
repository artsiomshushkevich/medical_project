package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DepartmentDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.model.Department;
import com.vetardim.model.Doctor;
import com.vetardim.model.User;

import java.util.Map;

public class MyInfoController extends ActionSupport {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    private Doctor doctor;
    private int id;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            doctor = DoctorDao.getDoctorByUserId(id);
            user = UserDao.getUserById(id);
            doctor.setLogin(user.getNickname());
            Department department = DepartmentDao.getDepartmentById(doctor.getDepartmentId());
            doctor.setDepartment(department.getName());
        }
        return Action.SUCCESS;
    }

}
