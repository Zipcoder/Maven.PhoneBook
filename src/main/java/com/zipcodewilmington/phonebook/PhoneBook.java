package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    protected TreeMap<String, Person> treeMap;
    protected ArrayList<String> entryList;
    protected Set<String> keySet;

    public PhoneBook() {
        this.treeMap = new TreeMap<String, Person>();
        this.entryList = new ArrayList<String>();
        this.keySet = treeMap.keySet();
        //this.hashMap.put("Name_empty", new Person("Name_empty", "Phone_number_empty"));
    }

    //PART I
    public Person lookup(String name) {
        return treeMap.get(name);
    }

    public void addEntry(String name, String... phoneNumbers) {
        treeMap.put(name, new Person(name, phoneNumbers));
    }

    // Changed method name for Part III
    public void removeRecord(String name) {
        treeMap.remove(name);
    }

    public Set<String> getKeySet() { //names and phone numbers
        return treeMap.keySet();
        //return all persons
    }

    public StringBuilder displayAllEntries() { //names and phone numbers
        StringBuilder sb = new StringBuilder();

        for (String key : treeMap.keySet()) {
            Person p = treeMap.get(key);
            sb.append(p.getName() + "\n");
            sb.append(p.getPhoneNumberListString() + "\n");
        }

        return sb;
        //call getentries
    }

    //PART II
    public String reverseLookup(String phoneNumber) { //lookup names from phone numbers
        for (String name : treeMap.keySet()) {
            if (treeMap.get(name).phoneNumberList.contains(phoneNumber) == true) {
                return name;
                //break;
            }
        }
        return "No_name";
    }

}
