package com.example.healthtech.ui.appointment;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.healthtech.Account;
import com.example.healthtech.Appointment;
import com.example.healthtech.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentAdapter extends BaseAdapter {
    ArrayList<Appointment> appointments;
    Context context;
    LayoutInflater inflater;

    public AppointmentAdapter(Context context, ArrayList<Appointment> appointments){
        this.appointments = appointments;
        this.context  =context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return appointments.size();
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public Object getItem(int i){
        return appointments.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        view = inflater.inflate(R.layout.appointment_listview_item, null);
        TextView statusText = view.findViewById(R.id.appointmentStatusTextView);
        statusText.setText(Calendar.getInstance().getTime().after(appointments.get(i).getEndTime().getTime()) ? "Complete": "Upcoming");
        TextView descText = view.findViewById(R.id.appointmentDescriptionTextView);
        descText.setText(appointments.get(i).getDescription());
        SimpleDateFormat startFormat = new SimpleDateFormat("dd/MM/yy     HH:mm");
        SimpleDateFormat endFormat = new SimpleDateFormat("-HH:mm");
        TextView dateText = view.findViewById(R.id.appointmentDateTextView);
        dateText.setText("Timing: " + startFormat.format(appointments.get(i).getStartTime().getTime()) + endFormat.format(appointments.get(i).getEndTime().getTime()));
        return view;
    }
}
