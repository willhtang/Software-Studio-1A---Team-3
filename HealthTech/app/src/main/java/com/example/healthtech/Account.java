package com.example.healthtech;

import java.util.ArrayList;

public class Account {
    public static Account active;
    public static ArrayList<Account> inactive = new ArrayList<Account>();

    private ArrayList<Appointment> appointments;
    private String name;

    public Account(String name){
        this.name = name;
        this.appointments = new ArrayList<Appointment>();
        this.appointments.add(new Appointment(12, 30, 5, 30, "With Sam Anthony"));
        this.appointments.add(new Appointment(19, 30, 6, 02, "With Andrew Michael"));
        this.appointments.add(new Appointment(21, 0, 6, 03, "With Sam Anthony"));
        this.appointments.add(new Appointment(9, 0, 6, 04, "With Sam Anthony"));
    }

    public static void logout(){
        Account.inactive.add(Account.active);
        Account.active = null;
    }

    public static void login(Account a){
        if(Account.inactive.contains(a)){
            Account.inactive.remove(a);
        }
        Account.active = a;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public String getName() {
        return name;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Account){
            Account a = (Account) o;
            if(a.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
