package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

/**
 * Created by Kay.
 */
public class PhoneBookTest {
//instantiating new object for each test so that they are not reliant on each other. unique...
    @Test
    public void addTest() {
        PhoneBook phTest = new PhoneBook();
        String name = "Kay";
        String number = "1234567890";
        phTest.add(name, number);
        Assert.assertTrue(phTest.lookup(name).contains(number));
    }

    @Test
    public void addFailTest() {
        PhoneBook phTest = new PhoneBook();
        String name = "Kay";
        String number = "1234567890";
        phTest.add(name, number);
        Assert.assertTrue(phTest.lookup("Pony") == null);
    }

    @Test
    public void removeTest() {
        PhoneBook phTest = new PhoneBook();
        String name = "Bob";
        String number = "3456784523";
        //adding a test value key pair to test for removal
        phTest.add(name, number);
        Assert.assertTrue(phTest.lookup(name).contains(number));
        //after confirmation that it has been added, it needs to be removed
        phTest.remove(name);
        Assert.assertTrue(phTest.lookup(name) == null);

    }

    @Test
    public void lookupTest() {
        PhoneBook phTest = new PhoneBook();
        String name = "John";
        String number = "8765930";
        phTest.add(name, number);
        Assert.assertTrue(phTest.lookup(name).contains(number));
    }


    @Test
    public void listNameTest() {
        PhoneBook phTest = new PhoneBook();
        phTest.add("Joe", "12334");
        phTest.add("Kay", "45873423");
        phTest.add("Elisha", "234234");
        phTest.add("Nico", "24234");

        //Set is used because it is a method of tree map HAD TO IMPORT
        Set<String> names = phTest.listNames();
        Assert.assertTrue(names.size() == 4);
        Assert.assertTrue(names.contains("Joe"));
        Assert.assertTrue(names.contains("Kay"));
        Assert.assertTrue(names.contains("Elisha"));
        Assert.assertTrue(names.contains("Nico"));
    }

    @Test
    public void listNamesFailTest() {
        PhoneBook phTest = new PhoneBook();
        phTest.add("Cat", "12334");
        phTest.add("Dog", "45873423");


        //Set is used because it is a method of tree map HAD TO IMPORT
        Set<String> names = phTest.listNames();
        Assert.assertTrue(names.size() == 2);
        Assert.assertFalse(names.contains("Joe"));
        Assert.assertFalse(names.contains("Kay"));
    }

    @Test
    public void listRecordsTest() {
        PhoneBook phTest = new PhoneBook();
        //added two new entries to test
        phTest.add("Dumbo", "487542");
        phTest.add("Blumbo", "1800234583");

        //turned into an array to iterate through.
        Object[] array = phTest.listRecords().toArray();
        //to.Array returns Object[] array
        for (int i = 0; i < array.length; i++) {
            //Object that was in array was Map.Entry: a record on map (key value pair)
            Map.Entry<String, List<String>> record = (Map.Entry) array[i];
            //0 index = Laura because treemap is sorted alphabetically
            if (i == 0) {
                Assert.assertTrue(record.getKey().equals("Blumbo"));
                Assert.assertTrue(record.getValue().contains("1800234583"));
            } else {
                Assert.assertTrue(record.getKey().equals("Dumbo"));
                Assert.assertTrue(record.getValue().contains("487542"));
            }
        }
    }

    @Test
    public void reverselookupTest() {
        PhoneBook phTest = new PhoneBook();
        String expectedName = "Blumbo";
        String expectedNumber = "1234567";
        phTest.add(expectedName, expectedNumber);
        //adding entry to test return
        String actual = phTest.reverseLookup(expectedNumber);
        Assert.assertEquals(expectedName, actual);

    }

    @Test
    public void addTwoNumbersTest() {
        ArrayList<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add("1111");
        phoneNumbers.add("2222");

        PhoneBook phTest = new PhoneBook();
        String expectedName = "Blumbo";
        phTest.add(expectedName, phoneNumbers.get(0));
        phTest.add(expectedName, phoneNumbers.get(1));



        //adding entry to test return
        List<String> actual = phTest.lookup(expectedName);

        for(String phoneNumber : phoneNumbers) {
            Assert.assertTrue(actual.contains(phoneNumber));
        }


    }


    }