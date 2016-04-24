package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Department;
import com.vetardim.DAO.DepartmentDao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentController extends ActionSupport {

    private Department department;
    private List<Department> departmentsList;
    private int id;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Department> departmentList) {
        this.departmentsList = departmentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        this.departmentsList =  DepartmentDao.getDepartmentsList();
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getDepartment())) return Action.ERROR;
        DepartmentDao.addOrUpdateDepartment(getDepartment());
        return Action.SUCCESS;
    }

    public String delete() {
        DepartmentDao.deleteDepartment(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getDepartment())) return Action.ERROR;
        DepartmentDao.addOrUpdateDepartment(getDepartment());
        return Action.SUCCESS;
    }

    private String errorString;

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    private boolean validate(Department department)
    {
        Pattern namePattern = Pattern.compile("^[A-Za-z\\s]{1,45}$");
        Matcher m = namePattern.matcher(department.getName());
        if (!m.matches())
        {
            errorString = "The name is invalid";
            return false;
        }
        m = namePattern.matcher(department.getAddress());
        if (!m.matches())
        {
            errorString = "The address is invalid";
            return false;
        }
        return true;
    }

}
