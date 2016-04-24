package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.DepartmentDao;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Department;
import com.vetardim.model.Doctor;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.model.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoctorController extends ActionSupport {

    private Doctor doctor;
    private List<Doctor> doctorsList;
    private int id;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.usersList = UserDao.getUsersList();
        this.doctorsList =  DoctorDao.getDoctorsList();
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getDoctor())) return Action.ERROR;
        DoctorDao.addOrUpdateDoctor(getDoctor());
        return Action.SUCCESS;
    }

    public String delete() {
        DoctorDao.deleteDoctor(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getDoctor())) return Action.ERROR;
        DoctorDao.addOrUpdateDoctor(getDoctor());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<User> usersList;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    private boolean validate(Doctor doctor)
    {
        Pattern idPattern = Pattern.compile("^[0-9]{1,11}$");
        Matcher m = idPattern.matcher(Integer.toString(doctor.getUserId()));
        if (!m.matches() || UserDao.getUserById(doctor.getUserId()) == null) {
            errorString = "User id is invalid";
            return false;
        }
        User user = UserDao.getUserById(doctor.getUserId());
        if (!RoleDao.getRoleById(user.getRoleId()).getName().equals("Doctor") ) {
            errorString = "User has not role Doctor";
            return false;
        }
        Pattern namePattern = Pattern.compile("^[A-Za-z\\s]{1,60}$");
        m = namePattern.matcher(doctor.getFirstname());
        if (!m.matches())
        {
            errorString = "The firstname is invalid";
            return false;
        }
        m = namePattern.matcher(doctor.getSecondname());
        if (!m.matches())
        {
            errorString = "The secondname is invalid";
            return false;
        }
        m = namePattern.matcher(doctor.getLastname());
        if (!m.matches())
        {
            errorString = "The lastname is invalid";
            return false;
        }
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        m = emailPattern.matcher(doctor.getEmail());
        if (!m.matches())
        {
            errorString = "The email is invalid";
            return false;
        }
        Pattern phonePattern = Pattern.compile("^[0-9+-]{6,14}$");
        m = phonePattern.matcher(doctor.getPhoneNumber());
        if (!m.matches())
        {
            errorString = "The phone number is invalid";
            return false;
        }
        m = idPattern.matcher(Integer.toString(doctor.getDepartmentId()));
        if (!m.matches() || DepartmentDao.getDepartmentById(doctor.getDepartmentId()) == null) {
            errorString = "Department id is invalid";
            return false;
        }
        m = namePattern.matcher(doctor.getQualification());
        if (!m.matches())
        {
            errorString = "The qualification is invalid";
            return false;
        }
        m = namePattern.matcher(doctor.getSpeciality());
        if (!m.matches())
        {
            errorString = "The speciality is invalid";
            return false;
        }

        return true;
    }


}

