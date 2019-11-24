package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        phonebook = map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(phoneNumber));
        phonebook.put(name,num);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(phoneNumbers));
        phonebook.put(name,num);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        ArrayList<String> num = new ArrayList<>(Arrays.asList(name));
        return phonebook.containsValue(num) || phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<List<String>> nums = new ArrayList<List<String>>(phonebook.values());
        ArrayList<String> num = new ArrayList<>(Arrays.asList(phoneNumber));
        Integer index = nums.indexOf(num);
        String[] names = phonebook.keySet().toArray(new String[phonebook.size()]);
        return names[index];
    }

    public List<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        for (String name : phonebook.keySet()){ names.add(name); }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
