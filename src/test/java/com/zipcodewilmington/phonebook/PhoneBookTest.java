package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

//    @Test
//    public void lookup_ValidEntry_ReturnsNumber() {
//        // Arrange
//        String input = "215-333-4444";
//        String expected = "215-333-4444";
//
//        // Act
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("theresa", input);
//        String actual = phoneBook.lookup("theresa");
//
//        // Assert
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void lookUp_NoEntry_ReturnsNull() {
//        PhoneBook phoneBook = new PhoneBook();
//        Assert.assertNull(actual);
//    }

    @Test
    public void add_EntryDoesNotExists_CreatesNewArrayListAndAppendsNumber() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "215-333-4444";
        phoneBook.add("theresa", "215-333-4444");
        String actual = phoneBook.lookup("theresa").get(0);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void add_EntryExists_AppendsNumberToArrayList() {
        PhoneBook phoneBook = new PhoneBook();
        String expected = "215-333-4444";
        phoneBook.add("theresa", "215-333-5555");
        phoneBook.add("theresa", "215-333-4444");
        String actual = phoneBook.lookup("theresa").get(1);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void remove_EntryExists_RemoveNumberToArrayList() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("theresa", "215-333-5555");
        phoneBook.add("theresa", "215-333-4444");


        phoneBook.remove("215-333-5555");
        ArrayList<String> actual = phoneBook.lookup("theresa");
        Assert.assertEquals(1, actual.size());
    }

    @Test
    public void remove_MultipleEntryExists_RemoveNumberToArrayList() {
        // Arrange
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("theresa", "215-333-5555");
        phoneBook.add("theresa", "215-333-4444");
        phoneBook.add("min", "215-333-5555");
        phoneBook.add("min", "215-333-4444");
        phoneBook.add("joe", "215-333-2141");

        // Act
        phoneBook.remove("215-333-5555");

        // Assert
        ArrayList<String> actual1 = phoneBook.lookup("theresa");
        ArrayList<String> actual2 = phoneBook.lookup("min");
        Assert.assertEquals(1, actual1.size());
        Assert.assertEquals(1, actual2.size());

    }
//
//    @Test
//    public void removeRecord_RemovesEntry() {
//        PhoneBook phoneBook = new PhoneBook();
//        String expected = "215-333-4444";
//        phoneBook.add("theresa", expected);
//        phoneBook.removeRecord("theresa");
//        ArrayList<String> actual = phoneBook.lookup("theresa");
//        Assert.assertNotNull(actual);
//    }
//
//    @Test
//    public void display_HasEntry_ReturnsString() {
//        // Arrange
//        String input = "215-333-4444";
//        String expected = "theresa 215-333-4444\n";
//
//        // Act
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("theresa", input);
//        String actual = phoneBook.display();
//
//        // Assert
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void display_HasMultipleEntry_ReturnsString() {
//        // Arrange
//        String expected = "min 215-222-4444\ntheresa 215-333-4444\n";
//
//        // Act
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("theresa", "215-333-4444");
//        phoneBook.add("min", "215-222-4444");
//
//        String actual = phoneBook.display();
//
//        // Assert
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @Test
//    public void reverseLookUp_EntryExists_ReturnsName() {
//        // Arrange
//        String expected = "min";
//
//        // Act
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.add("theresa", "215-333-4444");
//        phoneBook.add("min", "215-222-4444");
//
//        String actual = phoneBook.reverseLookUp("215-222-4444");
//
//        // Assert
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void reverseLookUp_EntryDoesExists_ReturnsNull() {
//        // Arrange
//
//        // Act
//        PhoneBook phoneBook = new PhoneBook();
//
//        String actual = phoneBook.reverseLookUp("215-222-4444");
//
//        // Assert
//        Assert.assertNull(actual);
//    }
//

}