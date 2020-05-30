package com.example.healthtech.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.R;
import com.example.healthtech.ui.dashboard.DashboardFragment;
import com.example.healthtech.ui.registration.RegistrationFragment;

public class LoginFragment extends Fragment {

    private LoginViewModel LoginViewModel;
    private ImageButton btnLogin, btnSignUp;
    private EditText nameField;

    public static LoginFragment newInstance(){ return new LoginFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = (ImageButton) root.findViewById(R.id.btnLogin);
        btnSignUp = (ImageButton) root.findViewById(R.id.btnSignUp);
        nameField = root.findViewById(R.id.etName);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        btnLogin.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view){
                Account.login(new Account(nameField.getText().toString()));
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, DashboardFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnSignUp.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, RegistrationFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
