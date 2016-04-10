package com.vetardim.util;

import java.util.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

/**
 * Created by artsiom on 4/10/16.
 */
public class UnixTimeConverter {
    public String convertUnixTimeToTime(long unixTime) {
        Date date = new Date(unixTime*1000L);
        DateFormat formatter = new SimpleDateFormat("hh:mm");
        return  formatter.format(date);
    }

    public long convertTimeToUnixTime (String time) {
        DateFormat formatter = new SimpleDateFormat("hh:mm");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  date.getTime()/1000L;
    }
}
