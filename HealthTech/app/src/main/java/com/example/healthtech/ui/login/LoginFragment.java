package com.example.healthtech.ui.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
    private EditText nameField, passField;

    public static LoginFragment newInstance(){ return new LoginFragment(); }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel =
                ViewModelProviders.of(this).get(LoginViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = root.findViewById(R.id.btnLogin);
        btnSignUp = root.findViewById(R.id.btnSignUp);
        nameField = root.findViewById(R.id.etName);
        passField = root.findViewById(R.id.etPassword);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        btnLogin.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Account.login(nameField.getText().toString(), passField.getText().toString())) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, DashboardFragment.newInstance());
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Invalid Username or Password");
                    builder.setMessage("The credentials you entered don't match those of any existing account.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
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
