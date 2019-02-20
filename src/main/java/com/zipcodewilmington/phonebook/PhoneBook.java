package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    //Field
    //accessor(private) type (Map<String, String>)
    private Map<String, String> entries;

    //Constructor
    public PhoneBook() {
        //intializing the entries
        entries = new TreeMap<String, String>();
    }

    public void add(String name, String number) {
        entries.put(name, number);
    }

    public Integer size() {
        return entries.size();
    }

    public void remove(String name) {
        entries.remove(name);
    }

    public String lookUp(String name) {
        return entries.get(name);
    }

    public String reverseLookUp(String phoneNumber) {
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String display() {
        String result = "";
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            result += entry.getKey() + " " + entry.getValue() + "\n";

        }

//        Set<Map.Entry<String, String>> entriesSet = entries.entrySet();
//
//        for (int i = 0; i < entriesSet.size(); i++) {
//            Map.Entry<String, String> entry = entriesSet.get(i);
//        }
        return result;
    }
}


