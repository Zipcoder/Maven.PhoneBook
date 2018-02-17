package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String phoneNumber;


    private TreeMap<String, ArrayList<String>> phoneBookDirectory = new TreeMap<String, ArrayList<String>>();


    public ArrayList<String> lookupNameToGetAccompanyingPhoneNumber(String name) {
       return phoneBookDirectory.get(name);
    }

    public void addEntry(String name, String phoneNumber) {
        if (phoneBookDirectory.containsKey(name)) {
            phoneBookDirectory.get(name).add(String.valueOf(phoneNumber));
        } else {
            ArrayList<String> nameAndPhoneNumber = new ArrayList<String>();
            nameAndPhoneNumber.add(0, (String.valueOf(phoneNumber)));
            phoneBookDirectory.put(name, nameAndPhoneNumber);
        }
    }


    public String removeEntry(String name) {
        phoneBookDirectory.remove(name);
        return null;

    }

    public java.util.Set listNames() {
        return phoneBookDirectory.keySet();
    }


    public java.util.Set listNamesAndNumbers() {
        return phoneBookDirectory.entrySet();
    }


    public String reverseLookup(String phoneNumber) {

       Set<String> keys = phoneBookDirectory.keySet();
       for (String key: keys) {
               if (phoneBookDirectory.get(key).contains(phoneNumber)) {
                   return key;
           }
       } return "no phone number";

        /* for (Map.Entry<String, ArrayList<String>> entry : phoneBookDirectory.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        } return null;
        */
    }
}
