package com.zipcodewilmington.phonebook;

public class Person {

    private String name;
    private String number;
    private String number2;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
        this.number2 = number2;
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

