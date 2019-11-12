package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        if (this.map.containsKey(name)) {
            this.map.get(name).add(phoneNumber);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(phoneNumber);
            this.map.put(name, list);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String phoneNumber: phoneNumbers) {
            this.add(name, phoneNumber);
        }
    }

    public void remove(String name) {
        if (this.hasEntry(name)) this.map.remove(name);
    }

    public Boolean hasEntry(String phoneNumber) {
        Boolean exists = false;
        for (List<String> numbers: this.map.values()) {
            if (numbers.contains(phoneNumber)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public List<String> lookup(String name) {
        return this.map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String output = "";
        for (String name: this.map.keySet()) {
            for (String num: this.map.get(name)) {
                if (num.equals(phoneNumber)) {
                    output = name;
                    break;
                }
            }
            if (output.length() > 0) break;
        }
        return output;
    }


    public List<String> getAllContactNames() {
        ArrayList<String> contacts = new ArrayList<>();
        for (String name: this.map.keySet()) {
            contacts.add(name);
        }
        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
