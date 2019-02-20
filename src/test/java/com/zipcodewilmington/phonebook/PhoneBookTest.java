package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void testAdd(){
        //Given - create a new instance of the class PhoneBook
        PhoneBook phoneBook = new PhoneBook();
        Integer expected = 1;

        //When
        phoneBook.add("Mocha","123");

        //Then
        Integer actual = phoneBook.size();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testRemove(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Mocha","215-555-7890");
        Integer expected = 0;

        //When
        phoneBook.remove("Mocha");

        //Then
        Integer actual = phoneBook.size();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testLoopUp(){
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String expected = "215-555-7890";
        String name = "Mocha";
        phoneBook.add(name, expected);

        //When
        //when the method returns, store the result into a variable (actual)
        //use the actual to test that the actual is equal to expected
        String actual = phoneBook.lookUp(name);

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testReverseLoopUp() {
        //Given
        PhoneBook phoneBook = new PhoneBook();
        String expected = "Mocha";
        String phoneNumber = "215-555-7890";
        phoneBook.add(expected,phoneNumber);

        //When
        String actual = phoneBook.reverseLookUp(phoneNumber);

        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testDisplay(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Zebra", "111-222-333");
        phoneBook.add("Dog", "222-444-4444");

        //When
        String actual = phoneBook.display();
        String expected = "Dog 222-444-4444\n" +
                          "Zebra 111-222-333\n";
        //Then
        Assert.assertEquals(expected,actual);



    }


}
