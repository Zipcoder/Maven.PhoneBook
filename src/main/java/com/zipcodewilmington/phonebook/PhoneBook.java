package com.zipcodewilmington.phonebook;
import java.util.*;

/**
 * Created by Kay.
 */
public class PhoneBook {

    TreeMap<String, List<String>> phMap;

    public PhoneBook() {

        this.phMap = new TreeMap<String, List<String>>();
    }

    public void add(String name, String number) {
        if (lookup(name) == null) {
            List<String> phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(number);
            phMap.put(name, phoneNumbers);
        } else {
            List<String> phoneNumbers = lookup(name);
            phoneNumbers.add(number);
        }
    }

    public void remove(String name) {

        phMap.remove(name);
    }

    public List<String> lookup(String name) {

        return phMap.get(name);

    }

    public Set listNames() {

        return phMap.keySet();
    }

    public Set listRecords() {

        return phMap.entrySet();
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String>> valuePair : phMap.entrySet()) {
            if (valuePair.getValue().contains(phoneNumber)){
                return valuePair.getKey();
            }
        }
        return "Entry not found";
    }
}