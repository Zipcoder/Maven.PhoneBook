package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mitch not Leon 2/14/18
 */


public class PhoneBook {

    private TreeMap<String, ArrayList<String>> phoneBookList = new TreeMap<String, ArrayList<String>>();

    public void addEntryToPhoneBook(String name, String... phonenumbers) {
        ArrayList<String> phonenumberList = new ArrayList<String>();
        for (String number : phonenumbers) {
            phonenumberList.add(number);
        }
        phoneBookList.put(name, phonenumberList);
    }

    public void removeEntryFromPhoneBook(String name) {
        phoneBookList.remove(name);
    }

    public String listAllNames() {
        return phoneBookList.keySet().toString();
    }

    public String listAllEntries() {
        return phoneBookList.entrySet().toString();
    }

    public String lookupPhonenumber(String name) {
        return phoneBookList.get(name).toString();
    }

    public String lookupNameByPhonenumber(String phonenumber) {
        for (Map.Entry<String, ArrayList<String>> entry : phoneBookList.entrySet()) {
            if (entry.getValue().toString().equals(phonenumber)) {
                return entry.getKey();
            }
        }
        return "Number not found";
    }

    public void removeSinglePhonenumber(String name, String numberInQuestion) {
        int count = 0;
        for (String targetPhoneNumber : phoneBookList.get(name)) {
            if (targetPhoneNumber == numberInQuestion) {
                phoneBookList.get(name).remove(count);
            }
            count++;
        }
    }

}