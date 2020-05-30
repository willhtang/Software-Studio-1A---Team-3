package com.example.healthtech.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.ChatMessage;
import com.example.healthtech.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class ChatFragment extends Fragment {
    private Button sendButton;
    private EditText input;
    private FirebaseAnalytics mFirebaseAnalytics;

    public static ChatFragment newInstance(){ return new ChatFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chatroom, container, false);

        sendButton = (Button) root.findViewById(R.id.sendButton);
        input = (EditText) root.findViewById(R.id.input);

        //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        sendButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getDisplayName())
                        );

                // Clear the input
                input.setText("");
            }
        });
    }

    public void displayChatMessages(){

    }
}
