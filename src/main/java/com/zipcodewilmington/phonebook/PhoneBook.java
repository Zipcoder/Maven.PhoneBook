package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(this.map.containsKey(name)){
            this.map.get(name).add(phoneNumber);
        }
        else{
            this.map.put(name, new ArrayList<>());
            this.map.get(name).add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        if(this.map.containsKey(name)) {
            this.map.get(name).addAll(Arrays.asList(phoneNumbers));
        }
        else {
            this.map.put(name, Arrays.asList(phoneNumbers));
        }
    }

    public void remove(String name) {
        this.map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().contains(phoneNumber)) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> allContacts = new ArrayList<>(map.keySet());
        return allContacts;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
