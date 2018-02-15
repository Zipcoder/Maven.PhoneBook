package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ContactTests {

    @Test
    public void getNameTest() {

        Contact contact1 = new Contact("Bob");

        String actualName = contact1.getName();
        Assert.assertEquals("Bob", actualName);
    }

    @Test
    public void getPhoneNumbersTest() {

        Contact contact1 = new Contact("Madeline");
        Assert.assertTrue(contact1.getPhoneNumbers().isEmpty());
    }

    @Test
    public void addPhoneNumbersTest() {

    // Actual:
    // Create new contact instance
        Contact contact1 = new Contact("Madeline");

    // Call addPhoneNumber method to add phone numbers to instance
        contact1.addPhoneNumber("234234");
        contact1.addPhoneNumber("767884");

    // Call getMethod to see if numbers were actually added
        ArrayList<String> actualPhoneNumbers = contact1.getPhoneNumbers();

    // Expected:
    // Create new ArrayList to test
        ArrayList expectedPhoneNumbers = new ArrayList<String>();

    // Add phone numbers to new ArrayList
        expectedPhoneNumbers.add("234234");
        expectedPhoneNumbers.add("767884");

        Assert.assertEquals( expectedPhoneNumbers, actualPhoneNumbers);

    }

    @Test
    public void removePhoneNumberTest() {
    // Actual:
    // Create new contact instance
        Contact contact1 = new Contact("Jerry");

    // Add phone number to contact
    // Remove number
        contact1.addPhoneNumber("89089");
        contact1.removePhoneNumber("89089");

    // Call getPhoneNumber method to check against
        ArrayList actualRemovePhoneNumberTest = contact1.getPhoneNumbers();

    // Expected:
    // Create ArrayList to test/return empty ArrayList
        ArrayList<String> expectedRemovePhoneNumberTest = new ArrayList<String>();


        Assert.assertEquals(expectedRemovePhoneNumberTest, actualRemovePhoneNumberTest );


    }

}
