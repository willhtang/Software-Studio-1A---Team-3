package com.example.healthtech.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthtech.Account;
import com.example.healthtech.Appointment;
import com.example.healthtech.ChatMessage;
import com.example.healthtech.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ChatMessageAdapter extends BaseAdapter {
    private ArrayList<ChatMessage> chatMessages;
    private Context context;
    private LayoutInflater inflater;

    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> chatMessages){
        this.chatMessages = chatMessages;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return chatMessages.size();
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    @Override
    public Object getItem(int i){
        return chatMessages.get(i);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup){
        View view = convertView;
        if(view == null) {
            view = inflater.inflate(R.layout.message, null);
        }
        TextView userText = view.findViewById(R.id.message_user);
        userText.setText(chatMessages.get(i).getMessageUser());

        TextView messageText = view.findViewById(R.id.message_text);
        messageText.setText(chatMessages.get(i).getMessageText());

        SimpleDateFormat endFormat = new SimpleDateFormat("dd-MM-yyyy (HH:mm:ss)");
        TextView timeText = view.findViewById(R.id.message_time);
        timeText.setText(endFormat.format(chatMessages.get(i).getMessageTime()));
        return view;
    }


}
