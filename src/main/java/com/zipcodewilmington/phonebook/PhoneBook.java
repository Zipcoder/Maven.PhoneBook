package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, String> myTree = new TreeMap<String, String>();

    public PhoneBook() {

    }

    public void add(String name, String number) {
        myTree.put(name, number);
    }


    public void remove(String name) {
        myTree.remove(name);
    }


    public String lookup(String name) {

        return myTree.get(name);
    }

    public String reverseLookup(String number) {

        for (Map.Entry<String, String> entry : myTree.entrySet()) {
            if (entry.getValue() == number) {
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
            list += i + ": " + myTree.get(i) + "\n";
        }
        return list;
    }


    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Marky", "555.123.4321");
        myPhoneBook.add("Ricky", "555.432.9785");
        myPhoneBook.add("Danny", "555.999.8865");
        myPhoneBook.add("Terri", "555.123.9886");

        //System.out.println(myPhoneBook.listNamesAndNumbers());
        //System.out.println(myPhoneBook.listNames());
        System.out.println(myPhoneBook.reverseLookup("555.999.8865"));



    }


}
