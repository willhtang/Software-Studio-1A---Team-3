package com.example.healthtech;

import java.util.ArrayList;

public class Account {
    public static Account active = new Account();
    public static ArrayList<Account> inactive = new ArrayList<Account>();

    private ArrayList<Appointment> appointments;

    public Account(){
        this.appointments = new ArrayList<Appointment>();
        this.appointments.add(new Appointment(7, 30, 5, 30, ""));
        this.appointments.add(new Appointment(19, 30, 5, 30, ""));
        this.appointments.add(new Appointment(21, 0, 10, 20, "djdjwhdhnwhduhfhehduhgfhnwkidiyfhnenjdkfjhgbwbndjjufytgwgbhnjufyh"));
        this.appointments.add(new Appointment(3, 0, 2, 20, "With Sam anthony"));
    }

    public void logout(){
        Account.inactive.add(Account.active);
        Account.active = null;
    }

    public void login(Account a){
        if(Account.inactive.contains(a)){
            Account.inactive.remove(a);
        }
        Account.active = a;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }
}
