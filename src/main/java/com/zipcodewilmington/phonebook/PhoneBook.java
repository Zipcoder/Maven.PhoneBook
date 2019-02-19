package com.zipcodewilmington.phonebook;

import java.util.TreeMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    String name;
    String phonenum;
    //TreeMap<String, String> contacts = new TreeMap<String, String>();
    //   TreeMap<String, ArrayList> contacts = new TreeMap<String, ArrayList<String>>();
    TreeMap<String, PhoneNumberStorage> contacts = new TreeMap<String, PhoneNumberStorage>();


    public PhoneBook() {
    }

    public void addName(String name, String phonenum) {
        contacts.put(name, new PhoneNumberStorage(name, phonenum));
    }

    public void addName(String name, PhoneNumberStorage phoneNumberStorage) {
        contacts.put(name, phoneNumberStorage);
    }

    public void deleter(String name) {
        contacts.remove(name);
    }

    public PhoneNumberStorage lookup(String name) {
        return contacts.get(name);
    }

    public String listNames() {
        StringBuilder namesnumbers = new StringBuilder();
        Set<String> keys = contacts.keySet();
        for (String key : keys)

        {

            namesnumbers.append(key + "\n");
        }
        return namesnumbers.toString();
    }

    public String listNamesAndNumbers() {
        StringBuilder namesnumbers = new StringBuilder();
        Set<String> keys = contacts.keySet();
        for (String key : keys) {
            namesnumbers.append(key + " " + contacts.get(key) + "\n");
        }
        return namesnumbers.toString();
    }

    public String reverselookup(String number) {
        //Set<String> names = contacts.keySet();
        for (PhoneNumberStorage nums : contacts.values()) {
            for (String phoneNumbers : nums.getPhoneNumbers())

                if (number.equals(phoneNumbers)) {
                    return nums.lookup();
                }
        }
        return null;
    }

    public void addmultiple(String name, String... numbers){
        this.name = name;
        for (int i = 0; i < numbers.length; i++){
            contacts.get(name).add(numbers[i]);
        }
    }


}
