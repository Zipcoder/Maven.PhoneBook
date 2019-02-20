package com.zipcodewilmington.phonebook;
import java.util.ArrayList;

//the class
public class Person {
    private String name;
    private ArrayList<String> phonenumbers;
    //person constructor
    //for each person you make the number will go into the array list
    public Person(String name, String numbers){
        this.name = name;
        this.phonenumbers = new ArrayList<String>();
        phonenumbers.add(numbers);
    }

    //creating get methods
    public String getName() {
        return name;
    }
    //iterate through the ArrayList and add each one to a string
    public ArrayList<String> getPhoneNumbers() {
        return phonenumbers;
    }

//just add your parameter to the existing ArrayList
    public void setAddAdditionalNumber(String numbers){

    }

    /* public void setUpdateName(String name){

    }

    public void setUpdateNumber(String number){

    }*/

   /* public String getUpdateName(){
        return null;
    }

    public String getUpdateNumber(){
        return null;
    }*/
/*
    public String getAddAdditionalNumber(){
        return null;
    }*/
}
