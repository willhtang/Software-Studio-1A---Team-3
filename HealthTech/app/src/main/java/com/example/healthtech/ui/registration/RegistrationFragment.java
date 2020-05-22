package com.example.healthtech.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.example.healthtech.ui.login.LoginFragment;

public class RegistrationFragment extends Fragment {
    private RegistrationViewModel registrationViewModel;
    private EditText etFName, etLName, etDOB, etEmail, etPhone, etAddress, etUsername, etPassword;
    private RadioGroup rgUserType;
    private RadioButton rbPatient, rbDoctor;
    private Button btnCreate;

    public static RegistrationFragment newInstance(){
        RegistrationFragment fragment = new RegistrationFragment();
        return fragment;
    }

    //OnCreateView Method
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        //Initialise View
        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registration, container, false);

        //Declare Static Elements
        etAddress = (EditText) root.findViewById(R.id.etAddress);
        etDOB = (EditText) root.findViewById(R.id.etDOB);
        etEmail = (EditText) root.findViewById(R.id.etEmail);
        etFName = (EditText) root.findViewById(R.id.etFName);
        etLName = (EditText) root.findViewById(R.id.etLName);
        etPhone = (EditText) root.findViewById(R.id.etPhoneNo);

        etUsername = (EditText) root.findViewById(R.id.etNewUser);
        etPassword = (EditText) root.findViewById(R.id.etNewPass);

        rgUserType = (RadioGroup) root.findViewById(R.id.rgUserType);
        rbDoctor = (RadioButton) root.findViewById(R.id.radioDoctor);
        rbPatient = (RadioButton) root.findViewById(R.id.radioPatient);

        btnCreate = (Button) root.findViewById(R.id.btnCreateAccount);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        //Listeners
        rgUserType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup group, int checkedId) {
              for(int i=0; i < rgUserType.getChildCount(); i++){
                  RadioButton radioChild = (RadioButton) rgUserType.getChildAt(i);
                  if(radioChild.isChecked()){
                      setActive(radioChild);
                  }
                  else{
                      setInactive(radioChild);
                  }
              }
              }
        });


        btnCreate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, LoginFragment.newInstance());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void setActive(RadioButton target){
        target.setBackgroundResource(R.drawable.active_button);
        target.setTextColor(getResources().getColor(R.color.white));
    }
    private void setInactive(RadioButton target){
        target.setBackgroundResource(R.drawable.inactive_button);
        target.setTextColor(getResources().getColor(R.color.colorHealthTech));
    }
}