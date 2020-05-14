package com.example.healthtech.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashViewModel;

    public static DashboardFragment newInstance(){ return new DashboardFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.activity_dash, container, false);
        return root;
    }
}
