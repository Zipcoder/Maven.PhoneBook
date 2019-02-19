package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    //instance vairable
    private Map<String, List<String>> contacts;

    //constructor has to be the same as class w a capital letter
    public PhoneBook() {
        contacts = new TreeMap<String, List<String>>();
    }

    public Boolean add(String name, String number) {
        // contains key is to add a phone number to an already existing person
        if (contacts.containsKey(name)) {
            contacts.get(name).add(number);
            return true;
        }
        List<String> newNum = new ArrayList<String>();
        newNum.add(number);
        contacts.put(name, newNum);
        return true;

    }

    public boolean delete(String name) {
        return contacts.remove(name) != null;
    }

    public String lookup(String name) {
        return join(contacts.get(name));

    }

    public String reverseLookup(String number) {
        for (String nameKey : contacts.keySet()) {
            List<String> numForName = contacts.get(nameKey);
            if (numForName.contains(number)) {
                return nameKey;
            }
        }
        return "";
    }

    public String listAllNames() {
        StringBuilder list = new StringBuilder();
        Formatter formatList = new Formatter(list);
        for (String nameKey : contacts.keySet()) {
            formatList.format("Name %s%n", nameKey);
        }
        return list.toString();
    }

    public String listAllNamesAndNumbers() {
        StringBuilder list = new StringBuilder();
        Formatter formatList = new Formatter(list);
        for (String nameKey : contacts.keySet()) {
            formatList.format("Name %s%n Number: %-10s%n", nameKey, join(contacts.get(nameKey)));
        }
        return list.toString();

    }

    public static String join(List<String> listNum){
        if (listNum.size() == 1){
            return listNum.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listNum.size(); i++){
            sb.append(listNum.get(i));
            if (i< listNum.size()-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}