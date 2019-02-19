package com.zipcodewilmington.phonebook;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private static PhoneBook testPhoneBook;

    @Before
    public void createPhoneBook() {
        this.testPhoneBook = new PhoneBook();
    }

    @Test
    public void testAddEntryToPhoneBook() {
        String name = "John Johnson";
        String phonenumber = "2369542255";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        String actual = testPhoneBook.lookupPhonenumber(name);
        String expected = "[2369542255]";
        Assert.assertEquals(expected, actual);


    }

    @Test(expected = NullPointerException.class)
    public void testRemoveEntryFromPhoneBook() {
        String name = "John Johnson";
        String phonenumber = "3692587896";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.removeEntryFromPhoneBook(name);
        testPhoneBook.lookupPhonenumber(name);
    }

    @Test
    public void testListAllNames() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String name2 = "Steve Stevenson";
        String phonenumber2 = "8412578524";
        String name3 = "Jack Jackson";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "[Jack Jackson, John Johnson, Steve Stevenson]";
        String actual = testPhoneBook.listAllNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListAllEntries() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String name2 = "Steve Stevenson";
        String phonenumber2 = "8412578524";
        String name3 = "Jack Jackson";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "[Jack Jackson=[3254785485], John Johnson=[3659547852], Steve Stevenson=[8412578524]]";
        String actual = testPhoneBook.listAllEntries();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLookupNameByPhonenumber() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String name2 = "Steve Stevenson";
        String phonenumber2 = "8412578524";
        String name3 = "Jack Jackson";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "Jack Jackson";
        String actual = testPhoneBook.lookupNameByPhonenumber("[3254785485]");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLookupNameByPhonenumber2() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String name2 = "Steve Stevenson";
        String phonenumber2 = "8412578524";
        String name3 = "Jack Jackson";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "Number not found";
        String actual = testPhoneBook.lookupNameByPhonenumber("[3254786485]");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addingMultiplePhonenumbers() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String phonenumber2 = "8412578524";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber, phonenumber2, phonenumber3);
        String expected = "[3659547852, 8412578524, 3254785485]";
        String actual = testPhoneBook.lookupPhonenumber(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removingASinglePhonenumber() {
        String name = "John Johnson";
        String phonenumber = "3659547852";
        String phonenumber2 = "8412578524";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber, phonenumber2, phonenumber3);
        testPhoneBook.removeSinglePhonenumber("John Johnson", "8412578524");
        String expected = "[3659547852, 3254785485]";
        String actual = testPhoneBook.lookupPhonenumber("John Johnson");
        Assert.assertEquals(expected, actual);
    }

}
