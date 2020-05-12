package com.example.healthtech.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;
import com.example.healthtech.ui.login.LoginFragement;

public class RegistrationFragment extends Fragment {
    private RegistrationViewModel registrationViewModel;
    private EditText etFName, etLName, etDOB, etEmail, etPhone, etAddress, etUsername, etPassword;
    private RadioButton rbPatient, rbDoctor;

    //OnCreateView Method
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        //Initialise View
        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        View root = inflater.inflate(R.layout.registration_main, container, false);

        //Declare Static Elements
        etAddress = (EditText) root.findViewById(R.id.etAddress);
        etDOB = (EditText) root.findViewById(R.id.etDOB);
        etEmail = (EditText) root.findViewById(R.id.etEmail);
        etFName = (EditText) root.findViewById(R.id.etFName);
        etLName = (EditText) root.findViewById(R.id.etLName);
        etPhone = (EditText) root.findViewById(R.id.etPhoneNo);

        etUsername = (EditText) root.findViewById(R.id.etNewUser);
        etPassword = (EditText) root.findViewById(R.id.etNewPass);

        final RadioGroup rgUserType = (RadioGroup) root.findViewById(R.id.rgUserType);
        rbDoctor = (RadioButton) rgUserType.findViewById(R.id.radioDoctor);
        rbPatient = (RadioButton) rgUserType.findViewById(R.id.radioPatient);

        final Button btCreate = (Button) root.findViewById(R.id.btnCreateAccount);

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
                  /*RadioButton radioButton = (RadioButton) rgUserType.findViewById(checkedId);
                  setActive(radioButton);
                  switch (checkedId) {
                      case R.id.radioPatient:
                          setInactive(rbDoctor);
                          break;
                      case R.id.radioDoctor:
                          setInactive(rbPatient);
                          break;
                      default:
                          break;
                  }*/
              }
        });

        btCreate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(container.getId(), new LoginFragement());
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        /*
        registrationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                rgUserType.setText(s);
            }
        });*/
        return root;
    }

    private void setActive(RadioButton target){
        target.setBackgroundColor(R.drawable.active_button);
        target.setTextColor(getResources().getColor(R.color.white));
    }
    private void setInactive(RadioButton target){
        target.setBackgroundColor(R.drawable.inactive_button);
        target.setTextColor(getResources().getColor(R.color.colorHealthTech));
    }
}