package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Person {

    private String name;
    private ArrayList<String> phoneNumbers;

    public Person (String name, String number) {
        this.name = name;
        this.phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(number);
    }

    public String getNumbers () {
        return phoneNumbers.toString();
    }

    public void addNumbers (String number) {
        phoneNumbers.add(number);
    }

    public void removeNumbers (String number) {
        phoneNumbers.remove(number);
    }


}
