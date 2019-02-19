package com.zipcodewilmington.phonebook;

public class Person {
    private String name;
    private String number;


    public Person(){
        setName("");
        setNumber("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
