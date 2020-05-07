package com.example.healthtech.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.R;

public class RegistrationFragment extends Fragment {
   /* private RegistrationViewModel registrationViewModel;

    //OnCreateView Method
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Initialise View
        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        View root = inflater.inflate(R.layout.registration_main, container, false);

        //Declare Static Elements
        final RadioGroup rgUserType = root.findViewById(R.id.rgUserType);

        //Listeners
        rgUserType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup group, int checkedId) {
                  View radioButton = rgUserType.findViewById(checkedId);
                  setActive(radioButton);
                  switch (checkedId) {
                      case R.id.radioPatient:
                          setInactive(rgUserType.findViewById(R.id.radioDoctor));
                          break;
                      case R.id.radioDoctor:
                          setInactive(rgUserType.findViewById(R.id.radioPatient));
                          break;
                      default:
                          break;
                  }
              }
          });

        /*
        registrationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                rgUserType.setText(s);
            }
        });
        return root;
    }

    private void setActive(View target){
        target.setBackgroundColor(R.drawable.active_button);
        target.setTextColor(R.color.white);
    }
    private void setInActive(View target){
        target.setBackgroundColor(R.drawable.inactive_button);
        target.setTextColor(R.color.colorHealthTech);
    }*/
}