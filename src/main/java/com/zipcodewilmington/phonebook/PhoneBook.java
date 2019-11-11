package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, List<String>> phoneBook;
    List<String> phoneNumbers;

//--------  constructors ------------
    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = new LinkedHashMap<>();
        this.phoneBook = map;
        this.phoneNumbers = new ArrayList<>();
    }

    public PhoneBook() {
        this.phoneBook = new LinkedHashMap<>();
        this.phoneNumbers = new ArrayList<>();
    }
//------------------------------------


    public void add(String name, String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        this.phoneBook.put(name,this.phoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (int i = 0; i < phoneNumbers.length; i++){
            this.phoneNumbers.add(phoneNumbers[i]);
        }
        this.phoneBook.put(name,this.phoneNumbers);
    }

    public void remove(String name) {
        this.phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {

        return this.phoneNumbers.contains(name);
    }

    public List<String> lookup(String name) {
        List<String> result = new ArrayList<>();
        result = this.phoneBook.get(name);
        return result;
    }

    public String reverseLookup(String phoneNumber)  {
        String nameForPhone = "";
        for (Map.Entry<String,List<String>> value : this.phoneBook.entrySet()){
            nameForPhone = value.getKey();
        }
        return nameForPhone;
    }

    public List<String> getAllContactNames() {
        List<String> allNames = new ArrayList<>();
        for (Map.Entry<String,List<String>> value : this.phoneBook.entrySet()){
            allNames.add(value.getKey());
        }
        return allNames;
    }

    public Map<String, List<String>> getMap() {

        return this.phoneBook;
    }
}
