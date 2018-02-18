package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ContactTest {

    Contact contact;

    @Before
    public void setUp(){
        contact = new Contact();

    }
    @Test
    public void addNumberTest(){
        //Given
        String number = "872-345-2298";
        contact.addNumber(number);
        //When
        boolean numberHasBeenAdded = contact.getPhoneNumbers().contains(number);
        //Then
        assertTrue(numberHasBeenAdded);

    }
    @Test
    public void removeNumberTest(){
        //Given
        String number = "872-345-2298";
        contact.addNumber(number);
        //When
        contact.removeNumber(number);
        boolean numberHasBeenRemoved = !contact.getPhoneNumbers().contains(number);
        //Then
        assertTrue(numberHasBeenRemoved);
    }
    @Test
    public void toStringTest(){
        //Given
        String newName = "April";
        String newNumber = "7584339876";
        Contact contactUnderTest = new Contact(newName, newNumber);

        String expectedString = "April 7584339876";
        String actualString = contactUnderTest.toString();
        assertEquals(expectedString, actualString);

    }
    @Test
    public void getListOfPhoneNumbersTest(){
        String newName = "April";
        String newNumber = "7584339876";
        Contact contactUnderTest = new Contact(newName, newNumber);
        contactUnderTest.addNumber("3457765489");
        String expectedListOfNumbers = "7584339876 3457765489";
        String actualListOfNumbers = contactUnderTest.getListOfPhoneNumbers();
        assertEquals(expectedListOfNumbers, actualListOfNumbers);

    }


}
