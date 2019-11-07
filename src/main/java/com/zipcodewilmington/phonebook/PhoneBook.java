package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    Map <String, List<String>> map;
    private static final java.util.logging.Logger logger = Logger.getGlobal();


    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this.map = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        map.put(name, new ArrayList<>());
        map.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, new ArrayList<>());
        map.get(name).addAll(Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

            for (Map.Entry<String, List<String >> entry : map.entrySet()) {
                if (entry.getValue().contains(phoneNumber)){
                    return entry.getKey();
                }
            }
            return null;
    }

    public List<String> getAllContactNames() {
        List<String> result = new ArrayList<>();

        for (String entry : map.keySet()) {
            result.add(entry);
        }
        return result;
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
