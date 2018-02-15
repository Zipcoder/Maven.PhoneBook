package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PhoneBookTest {

    private static PhoneBook testPhoneBook;

    @Before
    public void createPhoneBook() {
        this.testPhoneBook = new PhoneBook();
    }

    @Test
    public void testAddEntryToPhoneBook() {
        String name = "fdsafaf";
        String phonenumber = "54235252";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        String actual = testPhoneBook.lookupPhonenumber(name);
        String expected = "[54235252]";
        Assert.assertEquals(expected, actual);


    }

    @Test(expected = NullPointerException.class)
    public void testRemoveEntryFromPhoneBook() {
        String name = "heya";
        String phonenumber = "4235354325";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.removeEntryFromPhoneBook(name);
        testPhoneBook.lookupPhonenumber(name);
    }

    @Test
    public void testListAllNames() {
        String name = "fdjakfdanf";
        String phonenumber = "3659547852";
        String name2 = "hgfdfgsdg";
        String phonenumber2 = "8412578524";
        String name3 = "kjhgjtts";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "[fdjakfdanf, hgfdfgsdg, kjhgjtts]";
        String actual = testPhoneBook.listAllNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListAllEntries() {
        String name = "ndjskaonfdsa";
        String phonenumber = "3659547852";
        String name2 = "nsafdaosf";
        String phonenumber2 = "8412578524";
        String name3 = "neuiwofdsioaf";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "[ndjskaonfdsa=[3254785485], nsafdaosf=[3659547852], neuiwofdsioaf=[8412578524]]";
        String actual = testPhoneBook.listAllEntries();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLookupNameByPhonenumber() {
        String name = "hgfdgdsfdgfs";
        String phonenumber = "3659547852";
        String name2 = "fdsafdsa";
        String phonenumber2 = "8412578524";
        String name3 = "dsnaufhifndshm";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber);
        testPhoneBook.addEntryToPhoneBook(name2, phonenumber2);
        testPhoneBook.addEntryToPhoneBook(name3, phonenumber3);
        String expected = "dsnaufhifndshm";
        String actual = testPhoneBook.lookupNameByPhonenumber("[3254785485]");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLookupNameByPhonenumber2() {
        String name = "asfdasf";
        String phonenumber = "3659547852";
        String name2 = "dfadfasgds";
        String phonenumber2 = "8412578524";
        String name3 = "adfadsfadsf";
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
        String name = "qwerewqrewr";
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
        String name = "fdnsaijfodn";
        String phonenumber = "3659547852";
        String phonenumber2 = "8412578524";
        String phonenumber3 = "3254785485";
        testPhoneBook.addEntryToPhoneBook(name, phonenumber, phonenumber2, phonenumber3);
        testPhoneBook.removeSinglePhonenumber("fdnsaijfodn", "8412578524");
        String expected = "[3659547852, 3254785485]";
        String actual = testPhoneBook.lookupPhonenumber("fdnsaijfodn");
        Assert.assertEquals(expected, actual);
    }

}