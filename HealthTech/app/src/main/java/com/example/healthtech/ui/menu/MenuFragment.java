package com.example.healthtech.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.example.healthtech.ui.appointment.BookAppointmentFragment;
import com.example.healthtech.ui.appointment.ManageAppointmentFragment;
import com.example.healthtech.ui.chat.ChatFragment;
import com.example.healthtech.ui.login.LoginFragment;
import com.example.healthtech.ui.profile.ProfileFragment;
import com.example.healthtech.ui.settings.SettingsFragment;
import com.example.healthtech.ui.subscription.SubscriptionFragment;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;
    private Button btnProfile, btnSubscription, btnAppointment, btnChat, btnSettings, btnLogout;

    public static MenuFragment newInstance(){ return new MenuFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                ViewModelProviders.of(this).get(MenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        btnAppointment = (Button) root.findViewById(R.id.btnAppointments);
        btnChat = (Button) root.findViewById(R.id.btnChat);
        btnProfile = (Button) root.findViewById(R.id.btnProfile);
        btnSettings = (Button) root.findViewById(R.id.btnSettings);
        btnSubscription = (Button) root.findViewById(R.id.btnSubscriptions);
        btnLogout = (Button) root.findViewById(R.id.btnLogout);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        btnAppointment.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ManageAppointmentFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnChat.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ChatFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnProfile.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ProfileFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnSettings.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, SettingsFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnSubscription.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, SubscriptionFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnLogout.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, LoginFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        });
    }
}
