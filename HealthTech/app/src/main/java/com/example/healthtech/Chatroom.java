package com.example.healthtech;

import java.util.ArrayList;
import java.util.Calendar;

public class Chatroom {
    public static Chatroom active;
    public static ArrayList<Chatroom> inactive = new ArrayList<>();

    private ArrayList<ChatMessage> chatMessages;
    private String name;

    public Chatroom(String name){
        this.name = name;
        this.chatMessages = new ArrayList<>();
        Chatroom.inactive.add(this);
    }

    public static void logout(){
        Chatroom.inactive.add(Chatroom.active);
        Chatroom.active = null;
    }

    public static void login(Chatroom a){
        Chatroom.inactive.remove(a);
        Chatroom.active = a;
    }

    public ArrayList<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public String getName() {
        return name;
    }

    public void addMessage(ChatMessage chatMessage){
        this.chatMessages.add(chatMessage);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Chatroom){
            Chatroom a = (Chatroom) o;
            return a.getName().equals(name);
        }
        return false;
    }
}
