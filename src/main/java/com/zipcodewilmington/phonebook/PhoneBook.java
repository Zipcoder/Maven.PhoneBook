package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private final Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {

        this.map = new TreeMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumberList = new ArrayList<>();
        if(hasEntry(name)) {
            phoneNumberList = map.get(name);
        }
        phoneNumberList.add(phoneNumber);
        map.put(name, phoneNumberList);
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String phoneNumber : phoneNumbers){
            add(name, phoneNumber);
        }
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        Set<String> contactNames = map.keySet();
        return contactNames.contains(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> contactNames = map.keySet();
        for (String contactName : contactNames) {
            List<String> phoneNumbers =map.get(contactName);
            if(phoneNumbers.contains(phoneNumber)){
                return contactName;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        Set<String> contactSet = map.keySet();
        List<String> result = new ArrayList<>();
        contactSet.forEach(currentElement -> result.add(currentElement));
        //or contactSet.forEach(result::add) <- more professional and clean
        return result;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
