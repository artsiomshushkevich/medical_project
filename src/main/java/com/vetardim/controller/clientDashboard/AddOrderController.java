package com.vetardim.controller.clientDashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import com.vetardim.util.UnixTimeConverter;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AddOrderController extends ActionSupport {

    private Client client;
    private int id;
    private List<Doctor> doctorsList;

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

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session.containsKey("id")) {
            id = Integer.parseInt(session.get("id").toString());
            client = ClientDao.getClientByUserId(id);
            Order order = new Order();
            order.setBeginTime(UnixTimeConverter.convertTimeToUnixTime(getTime(), "hh:mm"));
            order.setDate(UnixTimeConverter.convertTimeToUnixTime(getDate(), "yyyy-MM-dd"));
            order.setClientId(client.getId());
            order.setDoctorId(getDoctorId());
            OrderDao.addOrUpdateOrder(order);
            answer = "The operation completed successfully.";
        }
        return Action.SUCCESS;
    }

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private int doctorId;
    private String date;
    private String time;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

