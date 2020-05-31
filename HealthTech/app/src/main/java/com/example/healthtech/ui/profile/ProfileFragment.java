package com.example.healthtech.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.R;

import java.text.SimpleDateFormat;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public static ProfileFragment newInstance(){ return new ProfileFragment(); }

    TextView tvName, tvMail, tvAddress, tvDOB, tvPhone, tvProfile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        tvAddress = root.findViewById(R.id.textViewAddress);
        tvDOB = root.findViewById(R.id.textViewDOB);
        tvMail = root.findViewById(R.id.textViewEmail);
        tvName = root.findViewById(R.id.textViewName);
        tvPhone = root.findViewById(R.id.textViewPhoneNo);
        tvProfile = root.findViewById(R.id.textView22);
        tvProfile.setText(Account.active.getUserName());
        tvName.setText(Account.active.getFName() + " " + Account.active.getLName());
        tvMail.setText(Account.active.getMail());
        tvAddress.setText(Account.active.getAddress());
        tvPhone.setText(Account.active.getPhoneNum());
        SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
        tvDOB.setText(dobFormat.format(Account.active.getDOB().getTime()));
        return root;
    }
}
