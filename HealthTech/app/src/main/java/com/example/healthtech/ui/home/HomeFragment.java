package com.example.healthtech.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.healthtech.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){ return new HomeFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }
}
