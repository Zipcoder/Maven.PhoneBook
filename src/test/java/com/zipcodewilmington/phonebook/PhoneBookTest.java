package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by leon on 1/23/18.
 */


public class PhoneBookTest {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLookup() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("James", "555555555");
        phoneBookTest.add("Charles", "2026783422");

        String actual = phoneBookTest.lookup("Charles");
        Assert.assertEquals("2026783422 ", actual);
    }

    @Test
    public void testListNames() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John", "1234567890");
        phoneBookTest.add("James", "555555555");
        String expected = "James\n" +
                "John\n";
        String actual = phoneBookTest.listNames();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testListNumbersAndNumbers() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John", "1234567890");
        phoneBookTest.add("James", "5555555555");
        phoneBookTest.add("James", "6666666666");
        phoneBookTest.add("Mike", "5678901234");
        String expected = "James==>" + "5555555555,6666666666,\n" +
                "John==>" + "1234567890,\n" +
                "Mike==>" + "5678901234,\n";
        String actual = phoneBookTest.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        PhoneBook phoneBookTest = new PhoneBook();
        boolean expected = true;
        boolean actual = phoneBookTest.add("Peter", "7777777777");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testRemove() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("John", "1234567890");
        phoneBookTest.add("Peter", "7777777777");
        String ListPreRemoving = "John==>1234567890,\n" +
                "Peter==>7777777777,\n";
        phoneBookTest.remove("John");
        String postRemoving = "Peter==>7777777777,\n";
        String expected = postRemoving;
        String actual = phoneBookTest.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverseLookup() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("James", "555555555");

        String actual = phoneBookTest.reverseLookUp("555555555");
        Assert.assertEquals("James", actual);
    }

    @Test
    public void testRemoveIndividualNumbers() {
        PhoneBook phonebookeTest = new PhoneBook();
        phonebookeTest.add("James", "2222222222");
        phonebookeTest.add("James", "3333333333");

        String expected = "James==>3333333333,\n";
        phonebookeTest.removeIndividualNumbers("James", "2222222222");

        String actual = phonebookeTest.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveRecord() {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.add("Efrem", "1234567890");
        phoneBookTest.add("Brhane", "1010101010");

        phoneBookTest.removeRecord();

        String expected = "";
        String actual = phoneBookTest.listNamesAndNumbers();

        Assert.assertEquals(expected, actual);
    }


}
