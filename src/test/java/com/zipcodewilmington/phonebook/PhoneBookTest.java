package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();  // automatically goes in each test
//        phoneBook.addEntryToPhoneBook("Eric", "302-555-1111");
//        phoneBook.addEntryToPhoneBook("Bob", "302-999-9999");
    }


    @Test
    public void testAddPhoneBookEntryToPhoneBook() {

        ArrayList<String> addition = new ArrayList<>(Arrays.asList("302-555-1111", "302-222-2222"));

        phoneBook.addEntryToPhoneBook("Eric", addition);

        ArrayList<String> actual = new ArrayList<String>(phoneBook.lookUp("Eric"));
        Assert.assertEquals(addition, actual);
    }

    @Test
    public void testRemoveEntryFromPhoneBook() {
        ArrayList<String> ericsNumbers = new ArrayList<>(Arrays.asList("302-555-1111", "302-222-2222"));

        phoneBook.addEntryToPhoneBook("Eric", ericsNumbers);

        String expected = "";
        phoneBook.removeEntryFromPhoneBook("Eric");

        String actual = phoneBook.entryListAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lookUpTest() {
        ArrayList<String> addition = new ArrayList<>(Arrays.asList("302-555-1111", "302-222-2222"));

        phoneBook.addEntryToPhoneBook("Eric", addition);

        ArrayList<String> actual = new ArrayList<String>(phoneBook.lookUp("Eric"));
        Assert.assertEquals(addition, actual);
    }


    @Test
    public void testEntryListAll() {

        ArrayList<String> ericsNumbers = new ArrayList<>(Arrays.asList("302-111-1111", "302-222-2222", "302-333-3333"));
        phoneBook.addEntryToPhoneBook("Eric :", ericsNumbers);

        String expected = "Eric : " + ericsNumbers + "\n";

        String actual = phoneBook.entryListAll();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void testReverseLookup() {
        ArrayList<String> ericsNumbers = new ArrayList<>(Arrays.asList("302-555-1111", "302-222-2222"));

        String expected = "Eric";

        phoneBook.addEntryToPhoneBook("Eric", ericsNumbers);

        String actual = phoneBook.reverseLookup("302-555-1111");

        Assert.assertEquals(expected,actual);
    }

}
