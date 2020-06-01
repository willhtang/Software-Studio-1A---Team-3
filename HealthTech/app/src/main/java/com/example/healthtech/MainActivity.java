package com.example.healthtech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.healthtech.ui.login.LoginFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    ImageButton lgn_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Account("samanthony", true, "Sam", "Anthony", "samanthony.healthtech@outlook.com", "0423 128 298", "11 Oak Creek, NSW", new GregorianCalendar(1973, 1, 27), "healthtech");
        new Account("henrysmith", true, "Henry", "Smith", "henrysmith.healthtech@outlook.com", "0472 233 674", "22 Elm Road, NSW", new GregorianCalendar(1976, 10, 21), "healthtech");
        new Account("maryelizabeth", true, "Mary", "Elizabeth", "maryelizabeth.healthtech@outlook.com", "0423 123 896", "33 Rowan Crescent, NSW", new GregorianCalendar(1979, 10, 21), "healthtech");
        new Account("andrewmichael", true, "Andrew", "Michael", "andrewmichael.healthtech@outlook.com", "0494 121 115", "44 Birch Way, NSW", new GregorianCalendar(1984, 8, 28), "healthtech");
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.main_container);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, LoginFragment.newInstance());
        fragmentTransaction.commit();
    }

    public void restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
