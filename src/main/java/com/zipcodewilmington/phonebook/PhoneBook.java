package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//Declare Treemap name
public class PhoneBook {
    //Declare Treemap name
    //method 1
    private TreeMap<String, ArrayList<String>> contacts;
    private static final String add = "No such entry";
    public String name;
    public String phoneNumber;

    public PhoneBook() {
        contacts = new TreeMap<>();
    }

    //Instantiate new array list and add the number
    public void add(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phoneNumber);
        }

        else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public void remove(String phoneNumber) {
        for (Map.Entry<String, ArrayList<String>> entry : contacts.entrySet()) {
            ArrayList<String> phoneNumArrList = entry.getValue();
            for (int i = 0; i < phoneNumArrList.size(); i++) {
                if (phoneNumber.equals(phoneNumArrList.get(i))) {
                    phoneNumArrList.remove(i);
                }
            }
        }
    }

    public ArrayList<String> lookup(String name) {
        //not sure of this yet
        return contacts.get(name);
    }

    public void removeRecord(String name) {
        contacts.remove(name);
    }
}