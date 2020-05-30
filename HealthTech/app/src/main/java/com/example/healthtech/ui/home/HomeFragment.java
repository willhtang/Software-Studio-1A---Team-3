package com.example.healthtech.ui.home;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.R;
import com.example.healthtech.ui.doctor.Doctor1;
import com.example.healthtech.ui.doctor.Doctor2;
import com.example.healthtech.ui.doctor.Doctor3;
import com.example.healthtech.ui.doctor.Doctor4;
import com.example.healthtech.ui.inbox.InboxFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.healthtech.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){ return new HomeFragment(); }
    private Button btnSearch;
    private ImageButton btnInbox;
    private TextView message;
    private LinearLayout doctor1, doctor2, doctor3, doctor4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnSearch = (Button) root.findViewById(R.id.search_button);

        btnInbox = (ImageButton) root.findViewById(R.id.inbox_button);
        message = (TextView) root.findViewById(R.id.welcome_text);

        doctor1 = (LinearLayout) root.findViewById(R.id.doctor_1);
        doctor2 = (LinearLayout) root.findViewById(R.id.doctor_2);
        doctor3 = (LinearLayout) root.findViewById(R.id.doctor_3);
        doctor4 = (LinearLayout) root.findViewById(R.id.doctor_4);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        String mess = "Welcome back, " + Account.active.getName();
        message.setText(mess);
        btnInbox.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, InboxFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        doctor1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, Doctor1.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        doctor2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, Doctor2.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        doctor3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, Doctor3.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        doctor4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, Doctor4.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
