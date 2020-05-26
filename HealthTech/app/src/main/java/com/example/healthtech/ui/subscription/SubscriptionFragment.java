package com.example.healthtech.ui.subscription;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.healthtech.R;

public class SubscriptionFragment extends Fragment {
    public static SubscriptionFragment newInstance(){ return new SubscriptionFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_subscription, container, false);

        return root;
    }
}
