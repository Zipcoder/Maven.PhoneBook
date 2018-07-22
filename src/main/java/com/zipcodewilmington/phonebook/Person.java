package com.zipcodewilmington.phonebook;


import java.util.ArrayList;

public class Person {

    //variables

    /**
     * we made these private bc we don't want the user to be able to change the data. Another reason we want to do this
     * is that you want to "hide" how you store the information from the users.
     */


    private String name;
    private ArrayList<String> phoneNumber;

    public Person (String entryName, String entryNumber) {
        this.name = entryName;
        this.phoneNumber = new ArrayList<String>();
        this.phoneNumber.add(entryNumber);

    }

    public String getNumbers(){

        return phoneNumber.toString();
    }

    public void removeSingleNumber (String number){

        phoneNumber.remove(number);
    }

    public void addAdditionalNumber(String number){

        phoneNumber.add(number);
    }
}



