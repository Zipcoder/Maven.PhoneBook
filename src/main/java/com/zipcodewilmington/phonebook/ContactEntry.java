package com.zipcodewilmington.phonebook;


import java.util.ArrayList;

public class ContactEntry {

    private String name;
    private ArrayList<String> phoneNumbers = new ArrayList<String>();

    public String getName(){

        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addNumber(String phoneNumber){
        addNumberToEntry(phoneNumber);
    }

    public void addNumberToEntry(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }

    public ContactEntry(String name){
        this.name = name;
    }
}
