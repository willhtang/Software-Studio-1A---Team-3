package com.example.healthtech.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;

public class LoginFragment extends Fragment {
    private LoginViewModel loginViewModel;

    public static LoginFragment newLoginFragment() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    //OnCreateView Method
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        //Initialise View
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.login_home, container, false);
        return root;
    }
}
