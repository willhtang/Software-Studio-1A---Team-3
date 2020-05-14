package com.example.healthtech.ui.login;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.example.healthtech.ui.registration.RegistrationFragment;

public class LoginFragment extends Fragment {

    private LoginViewModel LoginViewModel;
    private ImageButton btnSignUp;

    public static LoginFragment newInstance(){ return new LoginFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        btnSignUp = (ImageButton) root.findViewById(R.id.sigup_button);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
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
