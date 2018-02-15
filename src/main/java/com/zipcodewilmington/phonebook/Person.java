package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Person {

    private String name;
    public ArrayList<String> phoneNumberList;

    public Person(String name, String... phoneNumbers) {
        this.name = name;
        this.phoneNumberList = new ArrayList<String>();
        for (String phoneNumber : phoneNumbers) {
            this.phoneNumberList.add(phoneNumber);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPhoneNumbers(String... phoneNumbersToAdd) {
        for (String phoneNumber : phoneNumbersToAdd) {
            this.phoneNumberList.add(phoneNumber);
        }

    }

    public void removePhoneNumbers(String... phoneNumbersToRemove) {
        for (String phoneNumber : phoneNumbersToRemove) {
            this.phoneNumberList.remove(phoneNumber);
        }

    }

    // method to return phone number list?


}
