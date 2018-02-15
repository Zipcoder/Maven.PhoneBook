package com.zipcodewilmington.phonebook;
import java.util.LinkedList;


public class Listing {
    private String name;
    private LinkedList<String> numbersList;

    public Listing(String name, String number){
        this.name = name;
        this.numbersList = new LinkedList();
        numbersList.add(number);
    }

    public void addNumber (String newNumber){
        numbersList.add(newNumber);
    }

    public void removeNumber(String numberToRemove){
            numbersList.remove(numberToRemove);
    }

    public String printName(){
        return name;
    }

    public String printNumbers(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<numbersList.size(); i++){
            if(i == numbersList.size()-1){
                builder.append(numbersList.get(i));
            }
            else {
                builder.append(numbersList.get(i) + " | ");
            }
        }
        return builder.toString();
    }

}
