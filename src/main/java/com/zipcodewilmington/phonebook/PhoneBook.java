package com.zipcodewilmington.phonebook;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList<String>> treeMap;

    public PhoneBook() {
        this.treeMap= new TreeMap<String, ArrayList<String>>();
    }

    public PhoneBook(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

    public void addEntry(String name, ArrayList<String> number) {
        if (!treeMap.containsKey(name)) {
            treeMap.put(name, number);
        }
    }


    public void addNumberToEntry(String name, String number) {
        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                ArrayList<String> value = entry.getValue();
                value.add(number);
            }
        }
    }


    public void removeNumberFromEntry(String name, String number) {
        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
            if (entry.getKey().equals(name)) {
                if (entry.getValue().contains(number)) {
                    entry.getValue().remove(number);
                }
            }
        }
    }


    public void removeEntry(String name) {
            treeMap.remove(name);
    }


    public ArrayList<String> lookup(String name) {
        return treeMap.get(name);
    }


    public String reverseLookup (String number) {
        String name = "";
        for(Map.Entry<String, ArrayList<String>> entry: treeMap.entrySet()) {
            ArrayList<String> value = entry.getValue();
            for(String revnumber: value) {
                if(number.contains(revnumber)) name = entry.getKey();
            }
        }
        return name;
    }


    public String display(){
        StringBuilder printOut = new StringBuilder();
        for(Map.Entry<String, ArrayList<String>> entry: treeMap.entrySet()) {
            printOut.append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue().toString())
                    .append("\n");
        }
        return printOut.toString();
    }

}
