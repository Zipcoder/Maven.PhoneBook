package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */

public class PhoneBookTest {
    PhoneBook testBook;

    @Before
    public void setup() {

        testBook = new PhoneBook();
    }

    @Test
    public void LookUpNumberByNameTest() {
        testBook.add("Keith", "396.322.7899");
        String testNumber = testBook.lookupNumberByName("Keith");
        Assert.assertTrue(testNumber.equals("[396.322.7899]"));
    }

    @Test
    public void LookUpNumberByNameTest2() {
        testBook.add("Ralf", "254.678.9876");
        String testNumber = testBook.lookupNumberByName("Ralf");
        Assert.assertTrue(testNumber.equals("[254.678.9876]"));

    }

    @Test
    public void LookupNameByNumberTest() {
        testBook.add("George", "123.456.7890");
        String testNumber = testBook.lookupNameByNumber("123.456.7891");
        Assert.assertFalse(testNumber.equals("George"));
    }

    @Test
    public void reverseLookupTest2() {
        testBook.add("Zeke", "146.346.7345");
        String testNumber = testBook.lookupNameByNumber("146.346.7345");
        Assert.assertTrue(testNumber.equals("Zeke"));
    }

    @Test
    public void addMultipleNumbers() {
        testBook.add("George", "142.678.4932");
        testBook.nameNumberBook.get("George").addNumbers("111.111.1111");
        testBook.nameNumberBook.get("George").addNumbers("222.222.2222");
        String actual = testBook.display();
        String expected = "George: [142.678.4932, 111.111.1111, 222.222.2222]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPersonTest() {
        testBook.add("George", "123.456.7890");
        String testNumber = testBook.lookupNumberByName("George");
        Assert.assertTrue(testNumber.equals("[123.456.7890]"));
    }

    @Test
    public void removeRecordTest1() {
        testBook.add("Bob", "938.204.7890");
        testBook.add("Junior", "869.456.3215");
        testBook.removeRecord("Bob");
        String actual = testBook.display();
        String expected = "Junior: [869.456.3215]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecordTest2() {
        testBook.add("Sage", "887.875.3456");
        testBook.add("Pete", "869.456.3215");
        testBook.removeRecord("Pete");
        String actual = testBook.display();
        String expected = "Sage: [887.875.3456]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeEachNumberTest(){
        testBook.add("Alex", "584.965.0934");
        testBook.nameNumberBook.get("Alex").addNumbers("496.304.2467");
        testBook.nameNumberBook.get("Alex").addNumbers("496.246.0987");
        testBook.nameNumberBook.get("Alex").removeNumbers("496.246.0987");
        String actual = testBook.display();
        String expected = "Alex: [584.965.0934, 496.304.2467]\n";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void displayTest() {
        testBook.add("Brad","609.489.2345");
        testBook.add("Donald","609.456.5574");
        testBook.add("Mark","609.298.5968");
        String actual = testBook.display();
        String expected = "Brad: [609.489.2345]\nDonald: [609.456.5574]\nMark: [609.298.5968]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayTest2() {
        testBook.add("Brad", "609.489.2345");
        testBook.add("Pitt", "609.356.1865");
        String actual = testBook.display();
        String expected = "Jeff: [609.489.2345]\nPitt: [609.356.1865]\n";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void listNamesTest() {
        testBook.add("George", "123.456.7890");
        testBook.add("Pete", "839.302.8594");
        testBook.add("Alex", "395.823.0987");
        testBook.add("Vincent", "973.920.8132");
        String actual = testBook.listNames();
        String expected = "Alex\nGeorge\nPete\nVincent\n";
        Assert.assertEquals(expected, actual);
        }
}
