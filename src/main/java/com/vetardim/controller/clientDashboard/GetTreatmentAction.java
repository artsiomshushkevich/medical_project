package com.vetardim.controller.clientDashboard;

import java.util.LinkedHashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class GetTreatmentAction implements Action{

    private Map<String, String> stateMap = new LinkedHashMap<String, String>();

    //Parameter from Jquery
    private int visitId;

    public String execute() {

        stateMap.put("1", "Kerala");

        return SUCCESS;
    }

    public Map<String, String> getStateMap() {
        return stateMap;
    }

    public void setStateMap(Map<String, String> stateMap) {
        this.stateMap = stateMap;
    }
}
