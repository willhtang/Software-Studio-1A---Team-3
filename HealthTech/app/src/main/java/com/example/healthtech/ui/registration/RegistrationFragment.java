package com.example.healthtech.ui.registration;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.R;
import com.example.healthtech.ui.login.LoginFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.Inflater;

public class RegistrationFragment extends Fragment {
    private RegistrationViewModel registrationViewModel;
    private TextView textViewDOB;
    private EditText etFName, etLName, etEmail, etPhone, etAddress, etUsername, etPassword;
    private RadioGroup rgUserType;
    private RadioButton rbPatient, rbDoctor;
    private Button btnCreate;
    private Calendar dob;

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
        etAddress = root.findViewById(R.id.etAddress);
        textViewDOB =  root.findViewById(R.id.textViewDOB);
        etEmail = root.findViewById(R.id.etEmail);
        etFName = root.findViewById(R.id.etFName);
        etLName = root.findViewById(R.id.etLName);
        etPhone = root.findViewById(R.id.etPhoneNo);

        etUsername = root.findViewById(R.id.etNewUser);
        etPassword = root.findViewById(R.id.etNewPass);

        rgUserType = root.findViewById(R.id.rgUserType);
        rbDoctor = root.findViewById(R.id.radioDoctor);
        rbPatient = root.findViewById(R.id.radioPatient);

        btnCreate = root.findViewById(R.id.btnCreateAccount);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
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

        textViewDOB.setOnClickListener(new View.OnClickListener() {
            View datePickerView;
            DatePicker picker;
            @Override
            public void onClick(View v) {
                datePickerView = LayoutInflater.from(getActivity()).inflate(R.layout.datepickerdialog, null);
                picker = datePickerView.findViewById(R.id.dateOfBirthPicker);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Date of Birth");
                picker.setMaxDate(Calendar.getInstance().getTimeInMillis());
                builder.setView(datePickerView);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Confirm DOB", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dob = new GregorianCalendar(picker.getYear(), picker.getMonth(), picker.getDayOfMonth());
                        SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
                        textViewDOB.setText(dobFormat.format(dob.getTime()));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnCreate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                AlertDialog dialog;
                Calendar flagDate = Calendar.getInstance();
                flagDate.add(Calendar.YEAR, -18);
                if(TextUtils.isEmpty(etFName.getText()) || TextUtils.isEmpty(etLName.getText()) || TextUtils.isEmpty(etPhone.getText()) || TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etAddress.getText()) || TextUtils.isEmpty(etUsername.getText()) || TextUtils.isEmpty(etPassword.getText()) || dob == null){
                    builder.setTitle("Incomplete Form");
                    builder.setMessage("Please fill in every field");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
                else if(etUsername.getText().toString().contains(" ")){
                    builder.setTitle("Invalid Input");
                    builder.setMessage("A username cannot contain space characters.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
                else if(!Account.checkAvailability(etUsername.getText().toString())){
                    builder.setTitle("Unavailable username");
                    builder.setMessage("Username is already taken. Please select a different username.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
                else if(dob.after(flagDate)){
                    builder.setTitle("Too Young");
                    builder.setMessage("You must be at least 18 years old to use this service;");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog = builder.create();
                    dialog.show();
                }
                else {
                    new Account(etUsername.getText().toString(), rbDoctor.isChecked(), etFName.getText().toString(), etLName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString(), etAddress.getText().toString(), dob, etPassword.getText().toString());
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, LoginFragment.newInstance());
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
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