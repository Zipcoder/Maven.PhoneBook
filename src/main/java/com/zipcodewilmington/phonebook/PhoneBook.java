package com.zipcodewilmington.phonebook;

/**
 * Created by leon on 1/23/18 updated by Joshua Wurdemann 2/12/2018.
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * Phone Book
 * add
 * remove
 * lookup
 * listNames
 * ListAll
 * ReverseLookup
 */
public class PhoneBook {
    //    private ArrayList<String> listOfPhoneNumbers;
    private TreeMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new TreeMap<>();
//        listOfPhoneNumbers = new ArrayList<>();
    }

    /**
     * @param name
     * @param phoneNumber
     * @return
     */
    public boolean add(String name, String phoneNumber) {
        boolean phoneNumberAddedAdded = false;
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<String>());
        }
        phoneNumberAddedAdded = addNumberToList(name, phoneNumber);

        return phoneNumberAddedAdded;
    }

    /**
     * @param name
     * @param phoneNumber
     * @return
     */
    public boolean addNumberToList(String name, String phoneNumber) {
        boolean addedNumber = false;

        ArrayList<String> listOfPhoneNumbers = lookUpPhoneNumber(name);
        if (!listOfPhoneNumbers.contains(phoneNumber)) {
            addedNumber = listOfPhoneNumbers.add(phoneNumber);
        }

        return addedNumber;
    }


    /**
     * @param name
     * @return
     */
    public boolean removeListing(String name) {
        boolean removedName = false;
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            removedName = true;
        }
        return removedName;
    }

    /**
     * @param name
     * @param phoneNumber
     * @return
     */
    public boolean removeAPhoneNumber(String name, String phoneNumber) {
        boolean removedANumber = false;
        try {
            if (phoneBook.containsKey(name)) {
                removedANumber = lookUpPhoneNumber(name).remove(phoneNumber);
            }
        } catch (NullPointerException e) {
            System.out.println("No phoneNumber exsists");
        }
        return removedANumber;
    }

    /**
     * @param phoneNumber
     * @return
     */
    public String lookUpName(String phoneNumber) {
        boolean isPhoneNumber = false;
        /**reverse lookup need to look value "phoneNumber"*/
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {

            isPhoneNumber = entry.getValue().contains(phoneNumber);

            if (isPhoneNumber == true) {
                return entry.getKey();
            }
        }
        return null; // change this
    }

    /**
     * @param name
     * @return
     */
    public ArrayList<String> lookUpPhoneNumber(String name) {
        return phoneBook.get(name);
    }


    /**
     * @return
     */
    public String getlistAllNames() {
        StringBuilder listOfNames = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()) {
              listOfNames.append(entry.getKey() + " ");
            for (String phoneNumber : entry.getValue()){
                listOfNames.append("   " + phoneNumber +"\n");

            }
        }
        return listOfNames.toString();
    }

}
