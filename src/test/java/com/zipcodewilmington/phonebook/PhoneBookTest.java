package com.zipcodewilmington.phonebook;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {
    private static PhoneBook phoneBookTest;

    public void setUp() {
        phoneBookTest = new PhoneBook();
    }

    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Jess", "3333333");
        String expected = phoneBook.lookup("Jess");
        Assert.assertEquals(expected, "3333333");
    }

    @Test
    public void testDelete() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Kat", "2342233");
        Boolean actual = phoneBook.delete("Kat");
        Assert.assertTrue(actual);
    }

    @Test
    public void testLookup() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sean", "556665");
        String actual = phoneBook.lookup("Sean");
        Assert.assertEquals("556665", actual);
    }

    // actual is what method in Phonebook class gives us back
    @Test
    public void testReverseLookup() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sean", "556665");
        String actual = phoneBook.reverseLookup("556665");
        Assert.assertEquals("Sean", actual);
    }

    @Test
    public void testListAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sean", "556665");
        phoneBook.add("Joe", "9766847");
        phoneBook.add("Bree", "993255");
        String expected = "Name Bree\nName Joe\nName Sean\n";
        String actual = phoneBook.listAllNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListAllNamesAndNumbers() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sean", "5566651111");
        phoneBook.add("Joe", "9766847111");
        phoneBook.add("Bree", "9932551111");
        String expected = "Name Bree\n Number: 9932551111\n" +
                          "Name Joe\n Number: 9766847111\n" +
                            "Name Sean\n Number: 5566651111\n";
        String actual = phoneBook.listAllNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }
}








