package com.zipcodewilmington.phonebook;

import java.util.*;

public class PhoneBook {

    public TreeMap<String, ArrayList<String>> record;

    public PhoneBook() { //constructor
        this.record = new TreeMap<String, ArrayList<String>>();
    }

    public void add(String name, String... number) {
        ArrayList<String> listNums = new ArrayList<String>();
        for (String numbers : number) {
            listNums.add(numbers);
        }
        record.put(name, listNums);
    }

    public void delete(String name) {
        this.record.remove(name);
    }

    public String retrieveByName(String name) {

        ArrayList<String> bothNums = record.get(name);
        return bothNums.toString();
    }

    public String retrieveByPhoneNumber(String number) {
        Set<String> names = record.keySet();
        for (String name : names){
            ArrayList<String> numbers = record.get(name);
            if(numbers.contains(number)) {
                return name;
            }

        }
        return "";
    }

    public String listAllNames() {
        StringBuilder list = new StringBuilder();
        for (String nameKey : record.keySet()) {
            list.append(nameKey + "\n");
        }
        return list.toString().trim();
    }



    public String listAllNamesAndNumbers() {

        StringBuilder listAll = new StringBuilder();

        for (Map.Entry<String, ArrayList<String>> entry : record.entrySet()) {
            listAll.append(String.format("%s ", entry.getKey()));

            ArrayList<String> phoneNumbers = entry.getValue();
            for (String phoneNumber : phoneNumbers) {
                listAll.append((phoneNumber));
            }
            listAll.append("\n");
        }
        return listAll.toString().trim();

    }
    public String reverseLookup(String number) {
        String name = new String();
        for(Map.Entry<String, ArrayList<String>> entry : this.record.entrySet()) {
            if(entry.getValue().equals(number)){
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
