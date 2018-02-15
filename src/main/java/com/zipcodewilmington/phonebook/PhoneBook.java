package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */


public class PhoneBook {

    private TreeMap<String, Contact> contactsMap;

    // Constructor
    public PhoneBook() {
        contactsMap = new TreeMap<String, Contact>();
    }


    public void addContact(String name, String phoneNumber) {
        //Create new contact instance, call addPhoneNumber method
        Contact contact = new Contact(name);
        contact.addPhoneNumber(phoneNumber);
        // Call getName method to add key, contact is value
        contactsMap.put(contact.getName(), contact);
    }

    public void addContact(Contact contact) {
        contactsMap.put(contact.getName(), contact);
    }


    public int getNumberOfContacts() {
        return contactsMap.size();
    }


    public void removeContact(String name) {
        contactsMap.remove(name);
    }


    public ArrayList lookupByName(String name) {
        return contactsMap.get(name).getPhoneNumbers();
    }


    public Collection<Contact> listAllContacts() {
        return contactsMap.values();
    }

    public String lookupByNumber(String phoneNumber) {
        // from phone book
        // into contactsMap
        // into Contact object
        // into Contact object's arraylist
        // evaluate values in arraylist

        Collection<Contact> contacts = contactsMap.values();
        for (Contact contact : contacts) {
            ArrayList<String> phoneNumbers = contact.getPhoneNumbers();
            if(phoneNumbers.contains(phoneNumber)) {
                return contact.getName();
            }
        }
        return "";
    }

}
