package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneBookTest {

    private static PhoneBook phoneBookTest;

    @Before
    public void createPhoneBook() {
        this.phoneBookTest = new PhoneBook();
    }

    @Test
    public void testAddEntry() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String expected = "[1234567]";
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAddEntry2() {
        String name = "Person 2";
        String number = "87654321";
        phoneBookTest.addEntry(name, number);
        String expected = "[87654321]";
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void removeEntryTest() {
        String name = "Person 1";
        String number = "8942418";
        phoneBookTest.addEntry(name, number);
        phoneBookTest.removeEntry(name);
        phoneBookTest.lookUp(name);

    }

    @Test(expected = NullPointerException.class)
    public void removeEntryTest2() {
        String name = "Person 2";
        String number = "12387874";
        phoneBookTest.addEntry(name, number);
        phoneBookTest.removeEntry(name);
        phoneBookTest.lookUp(name);
    }

    @Test
    public void listNamesTest() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String name2 = "Person 2";
        String number2 = "2345678";
        phoneBookTest.addEntry(name2, number2);
        String name3 = "Person 3";
        String number3 = "34567898";
        phoneBookTest.addEntry(name3, number3);
        String expected = "[Person 1, Person 2, Person 3]";
        String actual = phoneBookTest.listNames();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void listAllTest() {
        String name = "Person 1";
        String number = "1234567";
        String name2 = "Person 2";
        String number2 = "2345678";
        String name3 = "Person 3";
        String number3 = "34567898";
        String number4 = "5343677";
        phoneBookTest.addEntry(name, number);
        phoneBookTest.addEntry(name2, number2);
        phoneBookTest.addEntry(name3, number3, number4);
        String expected = "Person 1[1234567]\nPerson 2[2345678]\nPerson 3[34567898, 5343677]\n";
        System.out.println(expected);
        String actual = phoneBookTest.listAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest() {
        String name = "Person 1";
        String number = "1234567";
        phoneBookTest.addEntry(name, number);
        String expected = "Person 1";
        String actual = phoneBookTest.reverseLookUp(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookUpTest2() {
        String name = null;
        String number = null;
        String expected = "That number is not in the phone book";
        String actual = phoneBookTest.reverseLookUp(number);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeOneNumberTest() {
        String name = "Brian";
        String number = "1234567";
        String number2 = "2345678";
        String number3 = "3456789";
        phoneBookTest.addEntry(name, number, number2, number3);
        phoneBookTest.removeOneNumber(name, number2);
        String expected = "[1234567, 3456789]";
        String actual = phoneBookTest.lookUp(name);
        Assert.assertEquals(expected, actual);


    }

}
