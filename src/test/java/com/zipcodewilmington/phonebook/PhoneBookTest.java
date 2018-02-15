package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addContactTest() {

        PhoneBook testPhoneBook = new PhoneBook();

        Contact contact1 = new Contact("Jerry");
        contact1.addPhoneNumber("1234");

        // Actual
        testPhoneBook.addContact("Jerry", "43234");

    }

    @Test
    public void getNumberOfContactsTest() {

        PhoneBook testPhoneBook = new PhoneBook();

        testPhoneBook.addContact("Jerry", "78998");
        testPhoneBook.addContact("Newman", "90980");
        testPhoneBook.addContact("Elaine", "432345");

        int actualNumberOfContacts = testPhoneBook.getNumberOfContacts();
        int expectedNumberOfContacts = 3;

        Assert.assertEquals(expectedNumberOfContacts, actualNumberOfContacts);

    }

    @Test
    public void lookupByNameTest() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact("Madeline", "898098");

        // Actual
        ArrayList actualLookupByNameResult = testPhoneBook.lookupByName("Madeline");


        // Expected
        ArrayList<String> expectedLookupByNameResult = new ArrayList<String>();
        expectedLookupByNameResult.add("898098");

        Assert.assertEquals(expectedLookupByNameResult, actualLookupByNameResult);


    }

    @Test
    public void lookupByNumberTest() {

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact("Jerry", "43984029830");

        String actualLookupByNumberResult = testPhoneBook.lookupByNumber("43984029830");
        String expectedLookupByNumberResult = "Jerry";

        Assert.assertEquals(expectedLookupByNumberResult, actualLookupByNumberResult);

    }

    @Test
    public void removeContactTest() {
        // Given
        String personNameToRemove = "Bob";
        int expectedListSize = 0;

        // When
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.addContact(personNameToRemove, "23423");
        testPhoneBook.removeContact(personNameToRemove);

        Assert.assertEquals(expectedListSize, testPhoneBook.getNumberOfContacts());
    }

    @Test
    public void listAllContactsTest() {
        // Given
        PhoneBook testPhoneBook = new PhoneBook();
        Contact testContact = new Contact("Kramer");
        testPhoneBook.addContact(testContact);

        // When
        Collection contacts = testPhoneBook.listAllContacts();
        boolean outcome = contacts.contains(testContact);


        // Then
        Assert.assertTrue(outcome);
    }

}




