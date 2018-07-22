/**
 * New and written by Amy as of 7/15/18
 */

package com.zipcodewilmington.phonebook;

import java.util.ArrayList;

public class Person2 {

    private String name;
    private ArrayList<String> numbers;

    public Person2(String name, ArrayList numbers){
        this.name = name;
        this.numbers = numbers;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.numbers.add(number);
    }
}
