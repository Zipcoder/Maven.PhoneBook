package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.TreeMap;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, Contact> phoneBook;


    public PhoneBook() {
        this.phoneBook = new TreeMap<>(String::compareToIgnoreCase);
    }
    public void addNewEntry(String name, String number){
        getPhoneBook().put(name, new Contact(name, number));
    }

    public void removeEntry(String name){
        getPhoneBook().remove(name);
    }
    public void removeNumber(String name, String number){
        getPhoneBook().get(name).getPhoneNumbers().remove(number);
    }

    public ArrayList<String> lookUpContactPhoneNumbers(String name){
        return getPhoneBook().get(name).getPhoneNumbers();
    }

    public void listAllNamesAndNumbers() {
        System.out.println(toString());

    }
    public String reverseLookUp(String number) {
        for (Map.Entry<String, Contact> contactEntry : getPhoneBook().entrySet()) {
            if (contactEntry.getValue().getPhoneNumbers().contains(number)) {
                return contactEntry.getKey();
            }

        }
        return "Contact not found";
    }

    @Override
    public String toString(){
        String toBeReturned = "";
        for(Map.Entry<String, Contact> contactEntry : getPhoneBook().entrySet()){
           toBeReturned += contactEntry.getValue().toString();
           toBeReturned += " ";
        }
        return toBeReturned.trim();
    }
    public TreeMap<String, Contact> getPhoneBook(){
        return phoneBook;
}

        }











