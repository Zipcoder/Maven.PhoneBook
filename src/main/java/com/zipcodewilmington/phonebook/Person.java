package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Person {

    private String name;
    private ArrayList<String> phoneNumbers;

    public Person(String name, String number) {
        this.phoneNumbers = new ArrayList<String>();
        this.name = name;
        phoneNumbers.add(number);
    }

    public String getPhoneNumbers () {

        return phoneNumbers.toString();
    }

    public void addNumbers (String number){

        phoneNumbers.add(number);
    }

    public void removeNumbers (String number){

        phoneNumbers.remove(number);
    }


}
