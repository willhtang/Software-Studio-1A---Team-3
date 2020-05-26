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
import com.example.healthtech.ui.login.LoginFragment;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;
    private Button btnProfile, btnSubscription, btnAppointment, btnChat, btnSettings, btnLogout;

    public static MenuFragment newInstance(){ return new MenuFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                ViewModelProviders.of(this).get(MenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        btnLogout = (Button) root.findViewById(R.id.btnLogout);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
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
