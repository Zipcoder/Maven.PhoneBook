package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private String myName;
    private String myName1;
    private String myName2;

    private String myNumber;
    private String myNumber1;
    private String myNumber2;
    private ArrayList<String> myListOfPhoneNumbers;
    private ArrayList<String> myListOfPhoneNumbers1;
    private ArrayList<String> myListOfPhoneNumbers2;

    private TreeMap<String, ArrayList<String>> myPhoneBookEntries;
    private PhoneBook myPhoneBook;

    @Before
    public void setUp() throws Exception {
        myName = "bob";
        myName1 = "tim";
        myName2 = "lady";

        myNumber = "1000";
        myNumber1 = "200";
        myNumber2 = "300";

        myPhoneBook = new PhoneBook();

        myPhoneBook.add(myName, myNumber);
        myPhoneBook.add(myName1, myNumber1);
        myPhoneBook.add(myName2, myNumber2);
    }

    @Test
    public void testAdd() {
        String testName = "bob";
        String testPhone = "777";
        Assert.assertEquals(true, myPhoneBook.add(testName, testPhone));
        // Assert.assertEquals(true, myPhoneBook.add(testName, testPhone));
    }


    @Test
    public void testAddFalse() {
        String testName = "bob";
        String testPhone = "1000";
        Assert.assertEquals(false, myPhoneBook.add(testName, testPhone));
    }

    @Test
    public void testRemove() {
        String testName = "bob";
        String testName1 = "Gordy";
        Assert.assertEquals(true, myPhoneBook.removeListing(testName));
        Assert.assertEquals(false, myPhoneBook.removeListing(testName1));
    }

    @Test
    public void testRemoveAPhoneNumber() {
//        String testName = "Gordy";
        String testName1 = "Lady";
        String testNumber = "8900";
//        String testNumber1 = "9999";
        boolean actual = myPhoneBook.removeAPhoneNumber(myName1, myNumber1);
        boolean actual1 = myPhoneBook.removeAPhoneNumber(myName, myNumber);
        Assert.assertEquals(true, actual);
        //Assert.assertEquals(false,  actual1);
    }

    @Test
    public void testlookUpName() {

        Assert.assertEquals(myName, myPhoneBook.lookUpName(myNumber));

        //Assert.assertEquals(null, myPhoneBook.lookUpPhoneNumber(testNumber1));

    }


    @Test
    public void testlookPhoneNumberForTwoUsers() {
        Assert.assertEquals(myNumber, myPhoneBook.lookUpPhoneNumber(myName).get(0));
        Assert.assertEquals(myNumber2, myPhoneBook.lookUpPhoneNumber(myName2).get(0));
    }

    @Test
    public void testlookPhoneNumber() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add(myNumber);
        String testName = "bob";
        String testName1 = "Steve";


        Assert.assertEquals(expected, myPhoneBook.lookUpPhoneNumber(myName));
        Assert.assertEquals(null, myPhoneBook.lookUpName(testName1));
    }

    @Test
    public void testGetlistAllNames() {
       String expected = "bob    1000\n"
                        +"lady    300\n"
                        +"tim    200\n";

        String actual = myPhoneBook.getlistAllNames();
        Assert.assertEquals(expected, actual);
    }
}


