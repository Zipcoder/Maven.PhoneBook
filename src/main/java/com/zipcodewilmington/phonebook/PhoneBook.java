package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    TreeMap<String, List<String>> phoneBookList = new TreeMap<String, List<String>>();

    public void addEntry(String name, String ...phoneNumber) {
        List<String> numberList = new ArrayList<String>();
        for(String number : phoneNumber) {
            numberList.add(number);
        }
        phoneBookList.put(name, numberList);
    }

    public void removeEntry(String name) {
        phoneBookList.remove(name);
    }

    public String lookUp(String name) {
        return phoneBookList.get(name).toString();
    }

    public String listNames() {
        return phoneBookList.keySet().toString();
    }

    public String listAll() {

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, List<String>> entry : phoneBookList.entrySet()) {
            sb.append(entry.getKey() + entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String reverseLookUp(String number) {
        for(Map.Entry<String, List<String>> entry : phoneBookList.entrySet()) {
            if(entry.getValue().contains(number)) {
                return entry.getKey();
            }
        }
        return "That number is not in the phone book";
    }

    public void removeOneNumber(String name, String number) {
        int i = 0;
        for (String phoneNumber : phoneBookList.get(name)) {
            if(phoneNumber == number) {
                phoneBookList.get(name).remove(i);
            }
            i++;
        }
    }
}
