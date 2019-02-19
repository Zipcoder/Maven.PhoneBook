package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, ArrayList<String>>();
    }

    protected boolean add(String name, String phone) {
        if (hasEntry(name)) {
            getArrayListFor(name).add(phone);
            return true;

        } else {
            ArrayList<String> contactNumbers = new ArrayList<String>();
            contactNumbers.add(phone);
            phoneBook.put(name, contactNumbers);
        }

        return true;
    }

    protected void remove(String name) {
         phoneBook.remove(name);
    }

    protected String lookup(String name) {
        String contactInfo = "";
        ArrayList<String>phoneNumberLists = getArrayListFor(name);
        for (String phoneNumbers:phoneNumberLists) {
            contactInfo+=phoneNumbers + " ";
        }
        return contactInfo;
    }

    protected String listNames() {
        String names = "";
        for (String a : phoneBook.keySet()) {
            names += a + "\n";
        }

        return names;
    }

    protected String listNamesAndNumbers() {
        StringBuilder namesAndNumbers = new StringBuilder();
        for (String keys : phoneBook.keySet()) {
            namesAndNumbers.append(keys+"==>");
            ArrayList<String> contact = getArrayListFor(keys);
            for (String num : contact) {
                namesAndNumbers.append(num+",");
            }
            namesAndNumbers.append("\n");
        }
        return namesAndNumbers.toString();
    }

    protected String reverseLookUp(String number) {
        for (String keys : phoneBook.keySet()) {
            for (int i = 0; i < getArrayListFor(keys).size(); i++) {
                if (getArrayListFor(keys).get(i).equals(number))
                    return keys;
            }
        }
        return null;
    }
    protected boolean hasEntry(String name){
        if(phoneBook.containsKey(name)){
            return true;
        }
        return false;
    }
    protected ArrayList<String> getArrayListFor(String name){
        return phoneBook.get(name);
    }
    protected void removeIndividualNumbers(String name,String number){
        getArrayListFor(name).remove(number);
    }

    protected void removeRecord() {

        phoneBook.clear();
    }
}
