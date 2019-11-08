package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> map;
ArrayList<String> list=new ArrayList<>();
    public PhoneBook() {
        this.map = new LinkedHashMap<>();
    }

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public void add(String name, String phoneNumber) {
        map.put(name, Arrays.asList(phoneNumber));
        list.add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name,Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        if(( map.containsKey(name)||list.contains(name))){
            return true;
        }
       return false;
    }



    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        String key="";
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                key = entry.getKey();
        }
        return key;
    }

    public List<String> getAllContactNames() {


        ArrayList<String> keyList = new ArrayList<String>();
        for (Map.Entry<String, List<String>> pair : map.entrySet()) {
            keyList.add(pair.getKey());


        }

System.out.println(keyList);
        return keyList;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
