package com.example.healthtech;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Appointment {
    private Calendar startTime;
    private Calendar endTime;
    private String description;

    public  Appointment(int startHour, int startMinute, int month, int day, String description){
        this.description = description;
        this.startTime = new GregorianCalendar(2020, month-1, day, startHour, startMinute, 0);
        this.endTime = new GregorianCalendar(2020, month-1, day, startHour, startMinute+30, 0);
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }
}
