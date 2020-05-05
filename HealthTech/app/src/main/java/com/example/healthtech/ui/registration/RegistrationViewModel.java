package com.example.healthtech.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrationViewModel extends ViewModel {
    public RegistrationViewModel(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(res.layout.registration_main);
        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
    }


}