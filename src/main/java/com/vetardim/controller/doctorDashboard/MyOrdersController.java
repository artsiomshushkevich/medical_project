package com.vetardim.controller.doctorDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DepartmentDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.OrderDao;
import com.vetardim.model.Client;
import com.vetardim.model.Department;
import com.vetardim.model.Doctor;
import com.vetardim.model.Order;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MyOrdersController extends ActionSupport {

    private Doctor doctor;
    private int id;

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    private List<Order> ordersList;

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
            ordersList = OrderDao.getOrdersListByDoctorId(doctor.getId());
            for (Order order: ordersList) {
                order.setDateInString(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy:MM:dd"));
                order.setBeginTimeInString(UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(),"hh:mm"));

                Client client = ClientDao.getClientById(order.getClientId());
                order.setClientFullname(client.getFullname());

                Department department = DepartmentDao.getDepartmentById(doctor.getDepartmentId());
                order.setDepartmentAddress(department.getAddress());
            }

        }
        return Action.SUCCESS;
    }

}
