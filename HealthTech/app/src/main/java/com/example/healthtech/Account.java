package com.example.healthtech;

import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class Account {
    public static Account active;
    public static ArrayList<Account> inactive = new ArrayList<>();

    private ArrayList<Appointment> appointments;
    private String userName;
    private boolean isDoctor;
    private String fName;
    private String lName;
    private String mail;
    private String phoneNum;
    private Calendar DOB;
    private String address;
    private String pass;

    public Account(String userName, boolean isDoctor, String fName, String lName, String mail, String phoneNum, String address, Calendar DOB, String pass){
        this.userName = userName;
        this.isDoctor = isDoctor;
        this.fName = fName;
        this.lName = lName;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.address = address;
        this.DOB = DOB;
        this.pass = pass;
        this.appointments = new ArrayList<>();
        Account.inactive.add(this);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public String getUserName() {
        return userName;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Calendar getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public static void logout(){
        if(Account.active !=null) {
            Account.inactive.add(Account.active);
        }
        Account.active = null;
    }

    public static boolean login(String userName, String pass){
        for (int i = 0; i<inactive.size(); i++){
            if(userName.equals(inactive.get(i).userName) && pass.equals(inactive.get(i).pass)){
                Account.logout();
                active = inactive.get(i);
                inactive.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean checkAvailability(String userName){
        for (Account account:inactive){
            if(account.userName.equals(userName)){
                return false;
            }
        }
        return true;
    }

    public boolean isDoctor(){
        return isDoctor;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public void cancelAppointment(int i){
        this.appointments.remove(i);
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
            return a.getUserName().equals(userName);
        }
        return false;
    }
}
