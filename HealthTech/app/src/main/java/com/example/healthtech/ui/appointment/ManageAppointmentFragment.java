package com.example.healthtech.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.healthtech.Account;
import com.example.healthtech.Appointment;
import com.example.healthtech.R;

import java.util.ArrayList;

public class ManageAppointmentFragment extends ListFragment {
    public static ManageAppointmentFragment newInstance(){ return new ManageAppointmentFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_manage_appointments, container, false);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppointmentAdapter adapter = new AppointmentAdapter(getActivity(), Account.active.getAppointments());
        this.setListAdapter(adapter);
    }
}
