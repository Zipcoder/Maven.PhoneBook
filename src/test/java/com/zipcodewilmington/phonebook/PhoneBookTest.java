package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {



    @Test
    public void addTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Joe", "1234567", "2345678");
        String testNumber = testBook.lookupNumber("Joe");
        Assert.assertTrue(testNumber.equals("1234567, 2345678,"));

    }

//    @Test
//    public void addTest1() {
//        PhoneBook testBook = new PhoneBook();
//        Person expected = new Person("name", "arraylist of phone numbers");
//        testBook.addEntry("Kate", expected);
////        Person actual = testBook.lookupNumber("Kate");
////        Assert.assertTrue(expected.equals(actual));
//
//    }
//
    @Test
    public void removeTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.addEntry("Vince", "3333333333");
        testBook.removeEntry("Kate");
        String testNumber = testBook.listNames();
        Assert.assertEquals(testNumber, "Vince");


    }

    @Test
    public void stringLookupTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090", "9899890099");
        String testNumber = testBook.lookupNumber("Kate");
        Assert.assertTrue(testNumber.equals("4846569090, 9899890099,"));

    }

    @Test
    public void listNamesTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.addEntry("Adam", "4864569090");
        testBook.addEntry("Zeke", "4787869090");
        String actual = testBook.listNames();
        String expected = "Adam\nKate\nZeke";
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void listPhonebookTest1() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        testBook.addEntry("Adam", "4864569090", "7879891212");
        testBook.addEntry("Zeke", "4787869090");
        String actual = testBook.listPhoneBook();
        String expected = "Adam: 4864569090, 7879891212, Kate: 4846569090, Zeke: 4787869090,";
        Assert.assertEquals(expected, actual);


    }
    @Test
    public void ReverseLookupTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "4846569090");
        String testNumber = testBook.reverseLookup("4846569090");
        Assert.assertTrue(testNumber.equals("Kate"));

    }

    @Test
    public void RemoveNumberFromNameTest(){
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Adam", "4864569090", "7879891212");
        testBook.removeNumberFromName("Adam", "4864569090");
        String expected = "7879891212,";
        String actual = testBook.lookupNumber("Adam");
        System.out.println(actual);
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void additionalPhoneNumberToKeyTest() {
        PhoneBook testBook = new PhoneBook();
        testBook.addEntry("Kate", "5659871212");
        testBook.additionalPhoneNumberToKey("Kate", "4999999999");
        String testNumber = testBook.lookupNumber("Kate");
        Assert.assertTrue(testNumber.equals("5659871212, 4999999999,"));

    }
}
