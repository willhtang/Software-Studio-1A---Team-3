package com.example.healthtech.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.healthtech.R;

public class ManageAppointmentFragment extends Fragment {
    public static ManageAppointmentFragment newInstance(){ return new ManageAppointmentFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_manage_appointments, container, false);

        return root;
    }
}
