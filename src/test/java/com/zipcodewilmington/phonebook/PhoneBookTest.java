package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

//Start off here. google "how to write a test for a map"
//    PhoneBook testPhonebook = new PhoneBook(); <=why didn't this work?
    PhoneBook testPhonebook;

    @Before
    public void setup() {
            testPhonebook = new PhoneBook();
    }

    @Test
    public void addEntryTestCase1(){
        //Given
            //a person object
            // a name and a number object
        new Person("Addison", "1234");


        //When
            //we add the person to the phonebook
        testPhonebook.add("Addison", "1234");
        String testNumber = testPhonebook.lookup("Addison");

        //Then
            //we expect to see that person object with assigned name and number

        Assert.assertTrue(testNumber.equals("[1234]"));
    }

    @Test
    public void addEntryTestCase2(){
        new Person("AdDy", "123.4");
        testPhonebook.add("AdDy", "123.4");
        String testNumber = testPhonebook.lookup("AdDy");
        Assert.assertTrue(testNumber.equals("[123.4]"));
    }

//    @Test
//    public void removeEntireEntryTest1(){
//        testPhonebook.add("Allessandra", "4321");
//        testPhonebook.add("Essarella", "4421");
//        testPhonebook.removeEntireEntry("Allessandra");
//        String testNumber = testPhonebook.lookup("Essarella");
//        Assert.assertNotEquals(null, testNumber);
//    }

    @Test
    public void removeEntireEntryTest2(){
        //Given
            //2 person objects
            // 2 names and 2 phone numbers

        testPhonebook.add("Andrea", "8888");
        testPhonebook.add("Alexei", "8877");

        //When
            //a user/dev removes one entry from the phonebook
        testPhonebook.removeEntireEntry("Alexei");
        String testList = testPhonebook.showNamesOnly();

        //Then
            //we expect to see that entry gone. we expect only to see all the other entries.
        Assert.assertTrue(testList.equals("Andrea\n"));

    }

        //newly added thanks to "the falcon"
    @Test
    public void addAddtionalNumberToEntryTest() {
        //Given
            //A name and a number
        testPhonebook.add("test", "123");


        //When
            //we add additional number
        testPhonebook.addAdditionalNumberToEntry("test", "200");


        //Then
            //we expect expect to see that additional number added to the entry
            String expected = "[123, 200]";
            String actual = testPhonebook.lookup("test");
            Assert.assertEquals(expected,actual);
    }

    @Test
    public void testLookup() {

        //Given
            //a person object with name and number

        testPhonebook.add("JohnDoe", "1123");

        //When
            //we try and look up a person's phone number by using their name as the search thing
        String expected = "[1123]";
        String actual = testPhonebook.lookup("JohnDoe");

        //Then
            //we expect to see their number

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testListNamesOnly1 (){
        //Given
            //a bunch of people with names and numbers
        testPhonebook.add("Andrea", "8888");
        testPhonebook.add("Alexei", "8877");
        testPhonebook.add("Addison", "1234");
        testPhonebook.add("AdDy", "1234");

        //When
            //we ask the program to display just the names
        String actual = testPhonebook.showNamesOnly();
        String expected = "AdDy\nAddison\nAlexei\nAndrea\n";

        //Then
            //we expect to see just the names
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayEntirePhoneBookContentsTest(){
        //Given
            //a list of peoples name and numbers
        testPhonebook.add("Andrea", "8888");
        testPhonebook.add("Alexei", "8877");
        //When
            //we ask to see all entries with name and numbers
        String actual = testPhonebook.displayEntirePhoneBookContents();
        String expected = "Alexei's phone number(s): [8877]\nAndrea's phone number(s): [8888]\n";
        //Then
            //we expect to see all entries with name and numbers
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAdditionalNumberTest(){
        //Given
            //a person object with an existing number
        testPhonebook.add("Andrea", "8888");
        //When
            // we add an addtional number to that person object
        testPhonebook.personTreeMap.get("Andrea").addAdditionalNumber("1111");

        //Then
            // we expect to see that number added
        String actual= testPhonebook.displayEntirePhoneBookContents();
        String expected = "Andrea's phone number(s): [8888, 1111]\n";
//        String actual = testPhonebook.lookup("Andrea");
//        String expected = "[8888, 1111]";
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void removeSingleNumberTest(){
        //Given
            //an entry with more than 1 number
        testPhonebook.add("Andrea", "8888");
        testPhonebook.personTreeMap.get("Andrea").addAdditionalNumber("1111");
        testPhonebook.personTreeMap.get("Andrea").addAdditionalNumber("2222");

        //When
            //we try to remove a number
        testPhonebook.personTreeMap.get("Andrea").removeSingleNumber("1111");

        //Then
            //we expect to see the original entry with all of its numbers except the one we removed
        String actual = testPhonebook.displayEntirePhoneBookContents();
        String expected = "Andrea's phone number(s): [8888, 2222]\n";
        Assert.assertEquals(expected, actual);
    }



}
