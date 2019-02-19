package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private static PhoneBook PhoneBookTest;

    public void setUp() {
        PhoneBookTest = new PhoneBook();
    }

    @Test
    public void recordShouldAddToPhoneBook() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        String expectedValue = phoneBookContact.returnNumber("Nick");
        Assert.assertEquals(expectedValue, "3029876543");
    }

    @Test
    public void recordShouldAddMultipleNumbersToPerson() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        phoneBookContact.nameAndNumber ("Nick", "3029876541");
        phoneBookContact.nameAndNumber ("Nick", "3029876546");
        String actualValue = phoneBookContact.returnNumber("Nick");
        Assert.assertEquals( "3029876543, 3029876541, 3029876546", actualValue);
    }

    @Test
    public void ShouldRetrieveNumbersByName() {
        PhoneBook phoneBookContact= new PhoneBook();
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        String expectedValue = phoneBookContact.returnNumber("Nick");
        Assert.assertEquals(expectedValue, "3029876543");
    }

    @Test
    public void ShouldRetrieveMultipleNumbersByName() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber("Jake", "3024556789");
        phoneBookContact.nameAndNumber("Jake", "3024556788");
        phoneBookContact.nameAndNumber("Jake", "3024556787");
        String actualValue = phoneBookContact.returnNumber("Jake");
        Assert.assertEquals( "3024556789, 3024556788, 3024556787", actualValue);
    }


    @Test
    public void receiveNameUsingNumber() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        String expectedValue = phoneBookContact.returnName("3029876543");
        Assert.assertEquals(expectedValue, "Nick");
    }


    @Test
    public void recordShouldDeleteFromPhoneBook() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        phoneBookContact.deleteNameAndNumber("Nick");
        String expectedValue = phoneBookContact.listAllNames();
        Assert.assertEquals(expectedValue, "");
    }

    @Test
    public void DeletePersonFromPhoneBookWithMoreThanOneNumber() {
        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Javez", "3024785643");
        phoneBookContact.nameAndNumber ("Javez", "3024785642");
        phoneBookContact.nameAndNumber ("Javez", "3024785656");
        phoneBookContact.deleteNameAndNumber("Javez");
        String expectedValue = phoneBookContact.listAllNames();
        Assert.assertEquals(expectedValue, "");
    }


    @Test
    public void listAllNamesAlphabeticalOrder() {
        PhoneBook phoneBookContact= new PhoneBook();
        phoneBookContact.nameAndNumber("Alex", "3025557896");
        phoneBookContact.nameAndNumber("Jake", "3024556789");
        phoneBookContact.nameAndNumber ("Javez", "3024785643");
        phoneBookContact.nameAndNumber ("Jordan", "3028990078");
        phoneBookContact.nameAndNumber("Lance", "3021245432");
        String actual = phoneBookContact.listAllNames();
        String testList = "Name: Alex\nName: Jake\nName: Javez\nName: Jordan\nName: Lance\n";
        Assert.assertEquals(testList, actual);
    }


    @Test
    public void listAllNamesAndNumbers() {

        PhoneBook phoneBookContact = new PhoneBook();
        phoneBookContact.nameAndNumber ("Javez", "3024785643");
        phoneBookContact.nameAndNumber("Alex", "3025557896");
        phoneBookContact.nameAndNumber("Jake", "3024556789");
        phoneBookContact.nameAndNumber ("Nick", "3029876543");
        phoneBookContact.nameAndNumber("Lance", "3021245432");
        String actual = phoneBookContact.listAllNames();
        String testList = "Name: Alex\nName: Jake\nName: Javez\nName: Lance\nName: Nick\n";
        Assert.assertEquals(testList, actual);
    }


}


