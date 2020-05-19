package com.example.healthtech.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.example.healthtech.ui.chat.ChatFragment;
import com.example.healthtech.ui.home.HomeFragment;
import com.example.healthtech.ui.login.LoginFragment;
import com.example.healthtech.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashViewModel;
    private BottomNavigationView navBar;

    public static DashboardFragment newInstance(){ return new DashboardFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.activity_dash, container, false);

        navBar = (BottomNavigationView) root.findViewById(R.id.bottom_navigation);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        navBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                switch(item.getItemId()){
                    case R.id.nav_home:
                        fragmentTransaction.replace(R.id.fragment_container, HomeFragment.newInstance());
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.nav_profile:
                        fragmentTransaction.replace(R.id.fragment_container, ProfileFragment.newInstance());
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.nav_chat:
                        fragmentTransaction.replace(R.id.fragment_container, ChatFragment.newInstance());
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    default:
                        fragmentTransaction.commit();
                        break;
                }
            }
        });
    }

}
