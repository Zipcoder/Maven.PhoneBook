package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    @Test
    public static void add() {
        //Given
        PhoneBook phoneBook = new PhoneBook();

        //When
        String expected = "1234567890";
        PhoneBook.add();
        //Assert
        String actual = PhoneBook.lookup();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void add2() {
        //Given
        PhoneBook phoneBook = new PhoneBook();

        //When
        String expected = "1234567890";
        phoneBook.add("bovice", "1234567890");
        phoneBook.add("bovice", "1234567890");

        //Assert
        String actual = phoneBook.lookup("bovice").get(1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void remove() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        //When
        phoneBook.add("bovice", "7777777777");
        phoneBook.add("bovice", "1234567890");
        phoneBook.remove("1234567890");

        //Assert
        ArrayList<String> actual = phoneBook.lookup("bovice");
        Assert.assertEquals(1, actual.size());
    }

    @Test
    public static String lookup() {
//Still needs a look up function
        return null;
    }

    @Test
    public void remove2() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("bovice", "7777777777");
        phoneBook.add("bovice", "1234567890");
        phoneBook.add("vance", "8888888888");
        phoneBook.add("vance", "0987654321");
        phoneBook.add("dr shivago", "3027778899");

        //When
        phoneBook.remove("7777777777");

        //Assert
        ArrayList<String> actual1 = phoneBook.lookup("bovice");
        ArrayList<String> actual2 = phoneBook.lookup("vance");
        Assert.assertEquals(1, actual1.size());
        Assert.assertEquals(1, actual2.size());
    }
}