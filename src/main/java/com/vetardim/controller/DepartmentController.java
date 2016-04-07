package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.model.Department;
import com.vetardim.DAO.DepartmentDao;

import java.util.List;

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
        DepartmentDao.addOrUpdateDepartment(getDepartment());
        return Action.SUCCESS;
    }

    public String delete() {
        DepartmentDao.deleteDepartment(getId());
        return Action.SUCCESS;
    }

    public String add() {
        DepartmentDao.addOrUpdateDepartment(getDepartment());
        return Action.SUCCESS;
    }


}
