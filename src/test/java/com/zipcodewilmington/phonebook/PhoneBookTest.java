package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private static PhoneBook phonebook;

    @Before
    public void setup() {
        this.phonebook = new PhoneBook() ;
    }

    @Test
    public void defaultConstructorTest() {
        Assert.assertNotNull(this.phonebook);
    }


    @Test
    public void lookupTest() {
        Person expectedPerson = new Person("Jane", "(111) 222-3333");
        this.phonebook.addEntry("Jane", "(111) 222-3333");

        String actualPersonName = expectedPerson.getName();
        String actualPersonPhoneNumber = expectedPerson.phoneNumberList.get(0);

        boolean actualPersonNameExists = this.phonebook.treeMap.containsKey("Jane");

        Assert.assertTrue(actualPersonNameExists);
    }


    @Test
    public void addEntryTest() {
        this.phonebook.addEntry("Adam", "(000) 000-0000", "(111) 111-1111");

        boolean actualPersonName = this.phonebook.treeMap.containsKey("Adam");
        boolean actualPhoneNumber = this.phonebook.treeMap.containsValue(this.phonebook.treeMap.get("Adam"));
        Assert.assertTrue(actualPersonName);
        Assert.assertTrue(actualPhoneNumber);

        String expectedPhoneNumber1 = "(000) 000-0000";
        String expectedPhoneNumber2 = "(111) 111-1111";

        String actualPhoneNumber1 = this.phonebook.treeMap.get("Adam").phoneNumberList.get(0);
        String actualPhoneNumber2 = this.phonebook.treeMap.get("Adam").phoneNumberList.get(1);

        Assert.assertEquals(expectedPhoneNumber1, actualPhoneNumber1);
        Assert.assertEquals(expectedPhoneNumber2, actualPhoneNumber2);

    }

    @Test
    public void removeRecordTest() {
        this.phonebook.addEntry("Bob", "(333) 444-5555");
        this.phonebook.removeRecord("Bob");

        boolean actualPersonName = this.phonebook.treeMap.containsKey("Bob");
        boolean actualPersonObject = this.phonebook.treeMap.containsValue(this.phonebook.treeMap.get("Bob"));

        Assert.assertFalse(actualPersonName);
        Assert.assertFalse(actualPersonObject);
    }

    @Test
    public void getKeySetTest() {
        this.phonebook.addEntry("Frank", "(000) 000-0000", "(100) 000-0000");
        this.phonebook.addEntry("Gabriel", "(100) 000-0000", "(110) 000-0000");

        System.out.println("getAllEntriesTest:");
        String expectedKeySet = "[Frank, Gabriel]";
        String actualKeySet = this.phonebook.getKeySet().toString();

        Assert.assertEquals(expectedKeySet, actualKeySet);
    }

    @Test
    public void displayAllEntriesTest() {
        this.phonebook.addEntry("Herbert", "(200) 000-0000", "(210) 000-0000");
        this.phonebook.addEntry("Isabel", "(300) 000-0000", "(310) 000-0000");

        String expectedEntries = "Herbert" + "\n" +
                                 "\t" + "(200) 000-0000" + "\n" +
                                 "\t" + "(210) 000-0000" + "\n" +
                                 "Isabel" + "\n" +
                                 "\t" + "(300) 000-0000" + "\n" +
                                 "\t" + "(310) 000-0000" + "\n";
        String actualEntries = this.phonebook.displayAllEntries().toString();

//        System.out.println("displayAllEntriesTest:");
//        System.out.println(expectedEntries);
//        System.out.println(actualEntries);

        Assert.assertEquals(expectedEntries, actualEntries);
    }

    @Test
    public void reverseLookupTest() {

        // This method should allow you to look up names by the phone number associated with them.

        // Given
        String givenPhoneNumber = "(000) 111-2222";

        // When
        this.phonebook.addEntry("Ava", "(000) 111-2222");
        Person expectedPerson = new Person("Ava", "(000) 111-2222");

        String expectedName = "Ava";
        String expectedPhoneNumber = "(000) 111-2222";

        String actualNameFromPhoneBook = "Ava";
        boolean actualPhoneNumberFromPhoneBook = this.phonebook.treeMap.get(actualNameFromPhoneBook).phoneNumberList.contains(expectedPhoneNumber);

        Assert.assertEquals(expectedName, this.phonebook.reverseLookup(givenPhoneNumber));
        // Then



    }

}




