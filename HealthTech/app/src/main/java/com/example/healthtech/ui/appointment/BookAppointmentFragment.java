package com.example.healthtech.ui.appointment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.healthtech.R;

public class BookAppointmentFragment extends Fragment {
    public static BookAppointmentFragment newInstance(){ return new BookAppointmentFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_appointment, container, false);

        return root;
    }
}
