package com.vetardim.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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
        this.ordersList =  OrderDao.getOrdersList();
        for (Order order: ordersList) {
            order.setDateInString(UnixTimeConverter.convertUnixTimeToTime(order.getDate(),"yyyy:MM:dd"));
            order.setBeginTimeInString(UnixTimeConverter.convertUnixTimeToTime(order.getBeginTime(),"hh:mm"));
        }
        return Action.SUCCESS;
    }

    public String update() {
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
        order.setBeginTime(UnixTimeConverter.convertTimeToUnixTime(time, "hh:mm"));
        order.setDate(UnixTimeConverter.convertTimeToUnixTime(date, "yyyy-MM-dd"));
        OrderDao.addOrUpdateOrder(getOrder());
        return Action.SUCCESS;
    }


}
