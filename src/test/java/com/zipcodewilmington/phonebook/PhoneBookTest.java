package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testDefaultConstructor() {
        PhoneBook book = new PhoneBook();
        Assert.assertNotNull(book);
    }

    @Test
    public void testConstructorWithArgument() {
        PhoneBook book = new PhoneBook();
        ArrayList<String> number = new ArrayList<String>(Arrays.asList("302-555-2222","302-555-3456"));
        book.addEntry("Bob", number);
        Assert.assertNotNull(book);
    }

    @Test
    public void testAddEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> expectedAddition = new ArrayList<String>(Arrays.asList("302-555-2222","302-555-3456"));
        //When
        book.addEntry("Bob", expectedAddition);
        ArrayList<String> actualAddition = new ArrayList<String>(book.lookup("Bob"));
        //Then
        Assert.assertEquals(expectedAddition, actualAddition);
    }

    @Test
    public void addNumberToEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-2234"));
        book.addEntry("Bob", bobNumber);
        //Expected
        ArrayList<String> expectedAddition = new ArrayList<String>(Arrays.asList("302-555-2234","302-555-1111"));
        //When
        book.addNumberToEntry("Bob", "302-555-1111");
        ArrayList<String> actualAddition = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedAddition, actualAddition);
    }

    @Test
    public void removeNumberFromEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-2234","302-555-1111"));
        book.addEntry("Bob", bobNumber);
        //Expected
        ArrayList<String> expectedAfterDeletion = new ArrayList<String>(Arrays.asList("302-555-2234"));
        //When
        book.removeNumberFromEntry("Bob", "302-555-1111");
        ArrayList<String> actualAfterDeletion = book.lookup("Bob");
        //Then
        Assert.assertEquals(expectedAfterDeletion, actualAfterDeletion);
    }

    @Test
    public void testRemoveEntry() {
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-2222","302-555-3456"));
        book.addEntry("Bob", bobNumber);
        //Expected
        String expectedValue = "";
        //When
        book.removeEntry("Bob");
        String actualValue = book.display();
        //Then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testLookup(){
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> expectedNumber = new ArrayList<String>(Arrays.asList("302-555-2223","302-555-3456"));
        book.addEntry("Bob", expectedNumber);
        //When
        ArrayList<String> actualNumber = new ArrayList<String>(book.lookup("Bob"));
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testLookup2(){
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-2223"));
        book.addEntry("Bob", bobNumber);
        //Expected
        ArrayList<String> expectedNumber = new ArrayList<String>(Arrays.asList("302-555-9988"));
        book.addEntry("Frank", expectedNumber);
        //When
        ArrayList<String> actualNumber = new ArrayList<String> (book.lookup("Frank"));
        //Then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testreverseLookup(){
        //Given
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-2223","302-555-5555"));
        String expectedName = "Bob";
        book.addEntry(expectedName, bobNumber);
        //When
        String actualName = book.reverseLookup("302-555-2223");
        //Then
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    public void testDisplay() {
        //Given:
        PhoneBook book = new PhoneBook();
        ArrayList<String> bobNumber = new ArrayList<String>(Arrays.asList("302-555-1234","302-556-1245"));
        book.addEntry("Bob", bobNumber);
        ArrayList<String> frankNumber = new ArrayList<String>(Arrays.asList("777-555-1111"));
        book.addEntry("Frank", frankNumber);
        //Expected
        String expectedNameNumber = "Bob " + bobNumber.toString() + "\n" + "Frank " + frankNumber.toString() + "\n";
        //When
        String actualNameNumber = book.display();
        //Then
        Assert.assertEquals(expectedNameNumber, actualNameNumber);
    }

}
