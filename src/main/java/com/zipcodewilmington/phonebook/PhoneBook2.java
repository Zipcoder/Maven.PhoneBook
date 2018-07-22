/**
 * New and written by Amy as of 7/15/18
 */

package com.zipcodewilmington.phonebook;

import java.util.TreeMap;

public class PhoneBook2 {

    private TreeMap<String, Person2> phoneBook2 = new TreeMap<String, Person2>();

    public PhoneBook2(TreeMap<String, Person2> input){
        this.phoneBook2= input;
    }
}
