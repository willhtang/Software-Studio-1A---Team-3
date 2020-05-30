package com.example.healthtech;

import java.util.ArrayList;
import java.util.Calendar;

public class Account {
    public static Account active;
    public static ArrayList<Account> inactive = new ArrayList<>();

    private ArrayList<Appointment> appointments;
    private String name;
    private boolean isDoctor;

    public Account(String name){
        this.name = name;
        this.isDoctor = name.startsWith("Dr");
        this.appointments = new ArrayList<>();
        this.appointments.add(new Appointment(12, 30, 5, 30, "With Dr Sam Anthony"));
        this.appointments.add(new Appointment(19, 30, 6, 2, "With Dr Andrew Michael"));
        this.appointments.add(new Appointment(21, 0, 6, 3, "With Dr Sam Anthony"));
        this.appointments.add(new Appointment(9, 0, 6, 4, "With Dr Sam Anthony"));
    }

    public static void logout(){
        Account.inactive.add(Account.active);
        Account.active = null;
    }

    public static void login(Account a){
        Account.inactive.remove(a);
        Account.active = a;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public String getName() {
        return name;
    }

    public boolean isDoctor(){
        return isDoctor;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public int getUpcoming(){
        int count = 0;
        for(Appointment appointment:this.appointments){
            if(appointment.getStartTime().after(Calendar.getInstance())){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Account){
            Account a = (Account) o;
            return a.getName().equals(name);
        }
        return false;
    }
}
