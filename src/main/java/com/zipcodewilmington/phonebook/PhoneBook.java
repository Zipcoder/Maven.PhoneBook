package com.zipcodewilmington.phonebook;

import java.util.*;

public class PhoneBook {

    // created class variables
    protected TreeMap<String, ArrayList<String>> treeMap;


    // initiate instance variables in constructor
    public PhoneBook() {
        this.treeMap = new TreeMap<>();
    }

    // .getKey =    name
    // .getValue =  arraylist phone #'s
    // .entrySet = efficient way of iterating over map
    // .containsKey = used to return true if map contains

    public void addEntryToPhoneBook(String name, ArrayList<String> phoneNumber) {
        // checking name if it's in map
        if (!treeMap.containsKey(name)) {
            treeMap.put(name, phoneNumber); //not there, add info
        }
    }


    public void removeEntryFromPhoneBook(String name) {
        treeMap.remove(name);
    }

    public ArrayList<String> lookUp(String name) {
        return treeMap.get(name);
    }


    public String entryListAll() {

        StringBuilder fullList = new StringBuilder();

        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
            fullList.append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n"); // appended on new lines for readability
        }
        System.out.println(fullList);
        return fullList.toString();

//        Noting originally had below syntax
//        String fullList = "";
//        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
//            fullList += entry.getKey() + " : " + entry.getValue() + "\n";
//
//        }
//        System.out.println(fullList);
//        return fullList;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // want to look up number and return the persons name
    public String reverseLookup(String numberToLookUp) {

        String name = "";   //empty string

        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) { //Looping entire TreeMap

            for (String numberWeWant : entry.getValue()) { //searching #'s in TreeMap value
                if (numberToLookUp.contains(numberWeWant)) {
                    name = entry.getKey();  // getKey reps names in TreeMap
                }
            }
        }
        System.out.println(name);
        return name;
    }
}
