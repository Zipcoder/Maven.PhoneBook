package com.zipcodewilmington.phonebook;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.*;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    PhoneBook testPhoneBook;
    @Before
    public void setup (){
        testPhoneBook = new PhoneBook();
    }

    private TreeMap<String, String> phoneBook = new TreeMap<String, String>();


    @Test
    public void testlookUpNameToGetAccompanyingPhoneNumber() {
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        testPhoneBook.addEntry("Elena", "234-123-3344");
        testPhoneBook.addEntry("Robert", "332-233-7821");
        String expected = "332-233-7821";
        String actual = testPhoneBook.lookupNameToGetAccompanyingPhoneNumber("Robert").get(0);
        Assert.assertEquals("should return Robert's phone number", expected, actual);

    }
    @Test
    public void testAddEntry() {
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        String expected = "233-123-3445";
        String actual = testPhoneBook.lookupNameToGetAccompanyingPhoneNumber("Rodrigo").get(0);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveEntry(){
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        testPhoneBook.addEntry("Elena", "234-123-3344");
        testPhoneBook.addEntry("Robert", "332-233-7821");
        String actual =testPhoneBook.removeEntry("Robert");
        String name = "Robert";
        String expected = null;
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testListNames() {
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        testPhoneBook.addEntry("Elena", "234-123-3344");
        testPhoneBook.addEntry("Robert", "332-233-7821");
        System.out.println(testPhoneBook.listNames());
        }

    @Test
    public void testListNamesandNumbers() {
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        testPhoneBook.addEntry("Elena", "234-123-3344");
        testPhoneBook.addEntry("Robert", "332-233-7821");
        System.out.println(testPhoneBook.listNamesAndNumbers());
    }

    @Test
    public void testReverseLookup() {
        testPhoneBook.addEntry("Rodrigo", "233-123-3445");
        testPhoneBook.addEntry("Elena", "234-123-3344");
        testPhoneBook.addEntry("Robert", "332-233-7821");
        String actual= testPhoneBook.reverseLookup("234-123-3344");
        String expected = "Elena";
        Assert.assertEquals("should return who the phone number is assigned to ", expected, actual);
        }
}


