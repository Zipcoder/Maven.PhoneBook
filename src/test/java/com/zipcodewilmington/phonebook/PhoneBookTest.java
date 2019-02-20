package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void AddTest(){
        //Given
        String expectedname = "Marlon";
        String expectednumber = "8005674563";
        //When
        PhoneBook phoneBook = new PhoneBook();
        //Then

    }

    @Test
    public void LookupTest(){
        //Given
        String expectedname = "Katrice";
        String expectednumber = "8567744773";
        //When
        PhoneBook phonebook = new PhoneBook();
        //Then
        //String actualnamephonebook = phonebook.treemap.getKey();
        //String actualnumberphonebook = phonebook.treemap.getKey();


        String actualnumber = phonebook.getNumber();
        Assert.assertEquals(expectednumber, actualnumber);
    }



    }




