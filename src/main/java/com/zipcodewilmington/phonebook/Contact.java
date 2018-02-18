package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Contact {


    private String name;
    private ArrayList<String> phoneNumbers;


    public Contact(){
        this.phoneNumbers = new ArrayList<>();
    }


    public Contact(String name, String phoneNumbers){
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
        addNumber(phoneNumbers);
    }

    public void addNumber(String number) {
        getPhoneNumbers().add(number);
    }

    public void removeNumber(String number) {
        getPhoneNumbers().remove(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    @Override
    public String toString(){
        return getName() + " " + getListOfPhoneNumbers();
    }
    public String getListOfPhoneNumbers(){
        String listOfNumbers = "";
        for(String number : getPhoneNumbers()){
            listOfNumbers += number + " ";
        }
        return listOfNumbers.trim();
    }

}
