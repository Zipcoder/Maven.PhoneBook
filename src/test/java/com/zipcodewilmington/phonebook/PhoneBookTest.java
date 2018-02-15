package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    PhoneBook test;
    @Before
    public void setup() {
        Listing eric = new Listing("Eric", "555-5555");
        Listing jenny = new Listing("Jenny", "867-5309");
        Listing horatio = new Listing("Horatio", "987-6543");
        Listing terrance = new Listing("Terrance", "111-2222");
        Listing tariq = new Listing("Tariq", "420-6969");
        test = new PhoneBook ("Jenny", jenny);
        test.addListing("Eric", eric);
        test.addListing("Horatio", horatio);
        test.addListing("Terrance", terrance);
        test.addListing("Tariq", tariq);
    }

    @Test
    public void testNewPhoneBook(){
        //Given
        Listing alphonse = new Listing("Alphonse", "999-8765");
        PhoneBook testNew = new PhoneBook("Alphonse", alphonse);

        //When
        String expectedName = "Alphonse";
        String expectedNumber = "999-8765";
        String actual = testNew.book.get("Alphonse").printName() + testNew.book.get("Alphonse").printNumbers();

        //Then
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testAddListing(){
        //Given
        Listing bobby = new Listing("Bobby", "123-4567");

        //When
        test.addListing("Bobby", bobby);
        String expectedName = "Bobby";
        String expectedNumber = "123-4567";
        String actual = test.book.get("Bobby").printName() + test.book.get("Bobby").printNumbers();

        //Then
        Assert.assertTrue(actual.contains(expectedName) && actual.contains(expectedNumber));
    }

    @Test
    public void testRemoveListing(){
        //Given
        //test.book

        //When
        try {
            test.removeListing("Jenny");
        }
        catch(NoListingFoundException e){
            e.printStackTrace();
        }
        String expectedKey = "Jenny";

        //Then
        Assert.assertFalse(test.book.containsKey(expectedKey));
    }

    @Test
    public void testRemoveInvalidListing(){
       //Given
        //test.book

        //When
        boolean thrown = false;
        try {
            test.removeListing("Robby");
        }
        catch(NoListingFoundException e){
            thrown = true;
            System.out.println("Don't be fooled: this exception means it passed the test");
             e.printStackTrace();
        }

        //Then
        Assert.assertTrue(thrown);
    }

    @Test
    public void testLookupByName(){
        //Given
        //test.book

        //When
        String expectedNumber = "867-5309";
        try {
            String actual = test.lookupByName("Jenny");

        //Then
            Assert.assertTrue(actual.equals(expectedNumber));
        }
        catch(NoListingFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLookupByInvalidName(){
        //Given
        //test.book

        //When
        boolean thrown = false;
        try {
            test.lookupByName("Robby");
        }
        catch(NoListingFoundException e){
            thrown = true;
            System.out.println("Don't be fooled: this exception means it passed the test");
            e.printStackTrace();
        }

        //Then
        Assert.assertTrue(thrown);
    }

    @Test
    public void testListAllNames() {
        //Given
        //test.book

        //When
        String expectedList =
                "Eric\n"+
                "Horatio\n"+
                "Jenny\n"+
                "Tariq\n"+
                "Terrance\n";
        String actual = test.listAllNames();

        //Then
        System.out.println("Listing all names");
        System.out.println(test.listAllNames().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }

    @Test
    public void testListAllNamesAndNumbers() {
        //Given
        //test.book

        //When
        String expectedList =
                        "    Eric : 555-5555\n"+
                        " Horatio : 987-6543\n"+
                        "   Jenny : 867-5309\n"+
                        "   Tariq : 420-6969\n"+
                        "Terrance : 111-2222\n";
        String actual = test.listAllNamesAndNumbers();

        //Then
        System.out.println("Listing all names and numbers");
        System.out.println(test.listAllNamesAndNumbers().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }
    @Test
    public void testAddMultipleNumbers(){
       //Given
        //test.book

        //When
        test.book.get("Tariq").addNumber("111-1111");
        String expectedNumbers = "420-6969 | 111-1111";
        String actual = test.book.get("Tariq").printNumbers();

        //Then
        Assert.assertTrue(actual.equals(expectedNumbers));
    }

    @Test
    public void testListAllNamesAndMultipleNumbers() {
        //Given
        //test.book AND
        test.book.get("Tariq").addNumber("111-1111");
        test.book.get("Jenny").addNumber("777-7777");
        test.book.get("Horatio").addNumber("651-9736");
        test.book.get("Horatio").addNumber("324-2424");

        //When
        String expectedList =
                        "    Eric : 555-5555\n"+
                        " Horatio : 987-6543 | 651-9736 | 324-2424\n"+
                        "   Jenny : 867-5309 | 777-7777\n"+
                        "   Tariq : 420-6969 | 111-1111\n"+
                        "Terrance : 111-2222\n";
        String actual = test.listAllNamesAndNumbers();

        //Then
        System.out.println("Listing all names and multiple numbers");
        System.out.println(test.listAllNamesAndNumbers().toString());
        Assert.assertTrue(actual.equals(expectedList));
    }

    @Test
    public void testReverseLookup(){
        //Given
        //test.book

        //When
        String expectedName = "Eric";
        String actual = test.reverseLookup("555-5555");

        //Then
        Assert.assertTrue(actual.equals(expectedName));

    }

    @Test
    public void testReverseLookupWithMultipleNumbers(){
        //Given
        //test.book

        //When
        String expectedName = "Eric";
        test.book.get("Eric").addNumber("333-3333");
        String actual = test.reverseLookup("333-3333");

        //Then
        Assert.assertTrue(actual.equals(expectedName));

    }

    @Test
    public void testReverseLookupInvalidNumber(){
        //Given
        //test.book

        //When
        String expectedName = "Number not found in directory";
        String actual = test.reverseLookup("333-3333");

        //Then
        Assert.assertTrue(actual.equals(expectedName));

    }

}
