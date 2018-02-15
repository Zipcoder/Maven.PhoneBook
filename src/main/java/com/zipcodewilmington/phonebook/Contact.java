package com.zipcodewilmington.phonebook;



import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Contact {

    private String name;
    private ArrayList<String> phoneNumbers;


    // Constructor
    Contact(String name) {
        this.name = name;
        phoneNumbers = new ArrayList<String>();
    }

    // Getter
    public String getName() {
        return name;
    }

    // Getter
    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;

    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(String phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }





}




