package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;
import java.util.Map;

public class MyOrdersController extends ActionSupport {

    private Client client;
    private int id;

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    private List<Order> ordersList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
            client = ClientDao.getClientByUserId(id);
            ordersList = OrderDao.getOrdersListByClientId(client.getId());
            for (Order order: ordersList) {
                order.setDateInString(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy-MM-dd"));
                order.setBeginTimeInString(UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(),"hh:mm"));

                Doctor doctor = DoctorDao.getDoctorById(order.getDoctorId());
                order.setDoctorFullname(doctor.getFullname());
                order.setDoctorSpeciality(doctor.getSpeciality());

                Department department = DepartmentDao.getDepartmentById(doctor.getDepartmentId());
                order.setDepartmentAddress(department.getAddress());
            }

        }
        return Action.SUCCESS;
    }

}
