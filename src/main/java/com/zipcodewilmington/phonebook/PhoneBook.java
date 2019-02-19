package com.zipcodewilmington.phonebook;
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */

//Class Declaration
public class PhoneBook {
    //method 1
    private static final String NON_EXISTANT_MESSAGE = "This does not exist.";

    private TreeMap<String, ArrayList<String>> contacts;

    public PhoneBook() {
        contacts = new TreeMap<>();
    }


    public void add (String name, String phoneNumber) {
        if (contacts.containsKey(name)){
            contacts.get(name).add(phoneNumber);
        }
        else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name , phoneNumbers);
        }
    }

    public void remove(String phoneNumber) {
        for(Map.Entry<String, ArrayList<String>> entry : contacts.entrySet()) {
            ArrayList<String> phoneNumArrList = entry.getValue();
            for (int i = 0; i < phoneNumArrList.size(); i++) {
                if(phoneNumber.equals(phoneNumArrList.get(i))) {
                    phoneNumArrList.remove(i);
                }
            }
        }
    }

    public ArrayList<String> lookup(String name) {
        return contacts.get(name);

    }

    public void removeRecord (String name) {
        contacts.remove(name);
    }

//    public String display() {
//        StringBuilder sb = new StringBuilder();
//        for(Map.Entry<String, String> entry : contacts.entrySet()) {
//            String name = entry.getKey();
//            String phoneNumber = entry.getValue();
//            sb.append(name + " " + phoneNumber + "\n");
//        }
//        return sb.toString();
//    }
    //
//    public String reverseLookUp (String phoneNumber){
//        for(Map.Entry<String, String> entry : contacts.entrySet()){
//            if (entry.getValue().equals(phoneNumber)) {
//                return entry.getKey();
//            }
//        }
//        return null;
//    }
}
