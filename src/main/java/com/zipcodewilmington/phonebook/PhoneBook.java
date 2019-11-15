package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> theMap;

    public PhoneBook(Map<String, List<String>> map) {
        this.theMap = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumsList = theMap.get(name);
        if(phoneNumsList != null) {
            phoneNumsList.add(phoneNumber);
        }
        else {
            theMap.put(name, Collections.singletonList(phoneNumber));
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        theMap.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        if (hasEntry(name)) {
            theMap.remove(name);
        }
    }

    public Boolean hasEntry(String name) {
        if(theMap.containsKey(name)){
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return theMap.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry: theMap.entrySet()){
            for(String phoneNum: entry.getValue()){
                if(phoneNum.equals(phoneNumber)){
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> allConNames = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: theMap.entrySet()){
                    allConNames.add(entry.getKey());
            }
        return allConNames;
    }

    public Map<String, List<String>> getMap() {
        return theMap;
    }
}
