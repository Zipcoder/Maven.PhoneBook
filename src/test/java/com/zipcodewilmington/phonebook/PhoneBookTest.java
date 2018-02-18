package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Created by leon on 1/23/18.
 */
 public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void addNewEntryTest(){
        String name = "April";
        String number = "6547783321";
        phoneBook.addNewEntry(name, number);
        boolean entryHasBeenCreated = phoneBook.getPhoneBook().containsKey(name);
        assertTrue(entryHasBeenCreated);
    }
    @Test
    public void removeEntryTest(){
        String name = "April";
        String number = "6547783321";
        phoneBook.addNewEntry(name, number);
        phoneBook.removeEntry(name);
        boolean entryHasBeenRemoved = !phoneBook.getPhoneBook().containsKey(name);
        assertTrue(entryHasBeenRemoved);
    }
    @Test
    public void removeNumberTest(){
        String name = "April";
        String number = "6547783321";
        phoneBook.addNewEntry(name, number);
        phoneBook.removeNumber(name, number);
        boolean numberHasBeenRemovedFromContact = !phoneBook.getPhoneBook().get(name).getPhoneNumbers().contains(number);
        assertTrue(numberHasBeenRemovedFromContact);
    }
    @Test
    public void lookUpContactPhoneNumbersTest(){
        String name = "April";
        String number = "6547783321";
        phoneBook.addNewEntry(name, number);
        ArrayList<String> actualPhoneList = phoneBook.lookUpContactPhoneNumbers(name);
        ArrayList<String> expectedPhoneList = new ArrayList<>();
        expectedPhoneList.add(number);
        assertEquals(expectedPhoneList, actualPhoneList);
    }
    @Test
    public void listAllNamesAndNumbersTest(){
        String name = "April";
        String number = "6547783321";
        String secondName = "Genya";
        String secondNumber = "8753349987";
        phoneBook.addNewEntry(name, number);
        phoneBook.addNewEntry(secondName, secondNumber);
        String actual = phoneBook.toString();
        String expected = "April 6547783321 Genya 8753349987";
        assertEquals(expected, actual);
        //Print all the things
        phoneBook.listAllNamesAndNumbers();
    }
    @Test
    public void reverseLookUpTest(){
        String name = "April";
        String number = "6547783321";
        String secondName = "Genya";
        String secondNumber = "8753349987";
        phoneBook.addNewEntry(name, number);
        phoneBook.addNewEntry(secondName, secondNumber);
        String actual = phoneBook.reverseLookUp(number);
        String expected = "April";
        assertEquals(expected, actual);
    }

}
