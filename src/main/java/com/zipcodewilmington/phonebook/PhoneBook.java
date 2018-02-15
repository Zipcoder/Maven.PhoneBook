package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, Person> myTree = new TreeMap<String, Person>();

    public PhoneBook() {

    }

    public void add(String name, String number) {
        Person newContact = new Person(name, number);
        myTree.put(name, newContact);
    }


    public void remove(String name) {
        myTree.remove(name);
    }


    public String lookup(String name) {

        return myTree.get(name).getNumbers();
    }


   public String reverseLookup(String number) {

       for (Map.Entry<String, Person> entry : myTree.entrySet()) {
           if (entry.getValue().getNumbers().contains(number)) {
               String keyAtValue = entry.getKey();
               return keyAtValue;
           }
       } return "Number not found";
   }


    public String listNames() {
        String list = "";
        Set<String> keys = myTree.keySet();
        for (String i : keys) {
            list += i + "\n";
        }
        return list;
    }


    public String listNamesAndNumbers() {
        String list = "";
        Set<String> keys = myTree.keySet();
        for (String i : keys) {
            list += i + ": " + myTree.get(i).getNumbers() + "\n";
        }
        return list;
    }


    public static void main(String[] args) {


    }

}
