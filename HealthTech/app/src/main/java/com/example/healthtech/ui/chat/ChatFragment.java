package com.example.healthtech.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthtech.Account;
import com.example.healthtech.ChatMessage;
import com.example.healthtech.Chatroom;
import com.example.healthtech.R;
import com.example.healthtech.ui.appointment.AppointmentAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Inflater;


public class ChatFragment extends ListFragment {
    private Button sendButton;
    private EditText input;
    private ListView messages;
    private ChatMessageAdapter adapter;
    private FirebaseAnalytics mFirebaseAnalytics;

    public static ChatFragment newInstance(){ return new ChatFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chatroom, container, false);

        sendButton = (Button) root.findViewById(R.id.sendButton);
        input = (EditText) root.findViewById(R.id.input);
        messages = (ListView) root.findViewById(R.id.lv_chat);

        //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ChatMessageAdapter(getActivity(), Chatroom.active.getChatMessages());
        this.setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        sendButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                /*FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getDisplayName())
                        );*/
                ChatMessage chatMessage = new ChatMessage(input.getText().toString(), Account.active.getUserName());
                Chatroom.active.addMessage(chatMessage);
                adapter.notifyDataSetChanged();
                /*LayoutInflater inflater = LayoutInflater.from(getActivity());
                View newView = inflater.inflate(R.layout.message, null);
                TextView userText = newView.findViewById(R.id.message_user);
                userText.setText(Account.active.getName());
                TextView messageText = newView.findViewById(R.id.message_text);
                messageText.setText(input.getText().toString());
                SimpleDateFormat endFormat = new SimpleDateFormat("HH:mm");
                TextView timeText = newView.findViewById(R.id.message_time);
                timeText.setText(endFormat.format(new Date().getTime()));
                messages.addView(newView);*/
                // Clear the input
                input.setText("");
            }
        });
    }

    public void displayChatMessages(){

    }
}
