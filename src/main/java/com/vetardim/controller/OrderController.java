package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.model.Client;
import com.vetardim.model.Doctor;
import com.vetardim.model.Order;
import com.vetardim.DAO.OrderDao;
import com.vetardim.util.UnixTimeConverter;

import java.util.List;

public class OrderController extends ActionSupport {

    private Order order;
    private List<Order> ordersList;
    private int id;
    private String date;
    private String time;


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String execute() throws Exception {
        this.clientsList = ClientDao.getClientsList();
        this.doctorsList = DoctorDao.getDoctorsList();
        this.ordersList =  OrderDao.getOrdersList();
        for (Order order: ordersList) {
            order.setDateInString(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy:MM:dd"));
            order.setBeginTimeInString(UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(),"hh:mm"));
            order.setDoctorFullname(DoctorDao.getDoctorById(order.getDoctorId()).getFullname());
            order.setClientFullname(ClientDao.getClientById(order.getClientId()).getFullname());
        }
        return Action.SUCCESS;
    }

    public String update() {
        if (!validate(getOrder())) return Action.ERROR;
        order.setBeginTime(UnixTimeConverter.convertTimeToUnixTime(time, "hh:mm"));
        order.setDate(UnixTimeConverter.convertTimeToUnixTime(date, "yyyy-MM-dd"));
        OrderDao.addOrUpdateOrder(getOrder());
        return Action.SUCCESS;
    }

    public String delete() {
        OrderDao.deleteOrder(getId());
        return Action.SUCCESS;
    }

    public String add() {
        if (!validate(getOrder())) return Action.ERROR;
        order.setBeginTime(UnixTimeConverter.convertTimeToUnixTime(time, "hh:mm"));
        order.setDate(UnixTimeConverter.convertTimeToUnixTime(date, "yyyy-MM-dd"));
        OrderDao.addOrUpdateOrder(getOrder());
        return Action.SUCCESS;
    }

    private String errorString;
    private List<Doctor> doctorsList;
    private List<Client> clientsList;

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    private boolean validate(Order order)
    {
        if (DoctorDao.getDoctorById(order.getDoctorId()) == null) {
            errorString = "Doctor id is invalid";
            return false;
        }
        if (ClientDao.getClientById(order.getClientId()) == null) {
            errorString = "Client id is invalid";
            return false;
        }
        return true;
    }

}
