package com.example.healthtech.ui.home;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.R;
import com.example.healthtech.ui.inbox.InboxFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.healthtech.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){ return new HomeFragment(); }
    private Button btnSearch;
    private ImageButton btnInbox;
    private TextView message;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnSearch = (Button) root.findViewById(R.id.search_button);

        btnInbox = (ImageButton) root.findViewById(R.id.inbox_button);
        message = (TextView) root.findViewById(R.id.welcome_text);

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
    }
}
