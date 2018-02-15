package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;


public class ListingTest {


    @Test
    public void testNewListing(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");

        //When
        String expectedNumber = "867-5309";
        String expectedName = "Jenny";
        String actual = jenny.printName() + jenny.printNumbers();


        //Then
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testAddNumber(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");

        //When
        jenny.addNumber("117-2490");
        String expectedNumber = "117-2490";
        String actual = jenny.printNumbers();

        //Then
        Assert.assertTrue(actual.contains(expectedNumber));
    }

    @Test
    public void testPrintName(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");

        //When
        String expectedName = "Jenny";
        String actual = jenny.printName();

        //Then
        Assert.assertTrue(actual.equals(expectedName));
    }

    @Test
    public void testPrintNumbers(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");
        jenny.addNumber("117-2490");

        //When
        String expectedNumbers = "867-5309 | 117-2490";
        String actual = jenny.printNumbers();

        //Then
        Assert.assertTrue(actual.equals(expectedNumbers));
    }

    @Test
    public void testRemoveNumber(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");
        jenny.addNumber("117-2490");

        //When
        jenny.removeNumber("117-2490");
        String expectedNumbers = "867-5309";
        String actual = jenny.printNumbers();

        //Then
        Assert.assertTrue(actual.equals(expectedNumbers));
    }

    @Test
    public void testRemoveFirstNumber(){
        //Given
        Listing jenny = new Listing("Jenny", "867-5309");
        jenny.addNumber("117-2490");

        //When
        jenny.removeNumber("867-5309");
        String expectedNumbers = "117-2490";
        String actual = jenny.printNumbers();

        //Then
        Assert.assertTrue(actual.equals(expectedNumbers));
    }


}
