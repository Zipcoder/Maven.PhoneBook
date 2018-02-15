package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    PhoneBook testPhoneBook;

    @Before
    public void setup() {
        testPhoneBook = new PhoneBook();
    }


    @Test
    public void addTest1() {
        new Person("Vince", "555.848.0907");
        testPhoneBook.add("Vince", "555.848.0907");
        String testNumber = testPhoneBook.lookup("Vince");
        Assert.assertTrue(testNumber.equals("[555.848.0907]"));
    }

    @Test
    public void addTest2() {
        new Person("Will", "800.588.2300");
        testPhoneBook.add("Will", "800.588.2300");
        String testNumber = testPhoneBook.lookup("Will");
        Assert.assertFalse(testNumber.equals("[800.123.9000]"));
    }



    @Test
    public void removeTest1() {
        testPhoneBook.add("Marky", "123.321.9999");
        testPhoneBook.add("Ricky", "999.543.1234");
        testPhoneBook.remove("Marky");
        String testNumber = testPhoneBook.lookup("Ricky");
        Assert.assertNotEquals(null, testNumber);
    }

    @Test
    public void removeTest2() {
        testPhoneBook.add("Marky", "123.321.9999");
        testPhoneBook.add("Ricky", "999.543.1234");
        testPhoneBook.remove("Ricky");
        String actual = testPhoneBook.listNames();
        Assert.assertTrue(actual.equals("Marky\n"));
    }


    @Test
    public void lookupTest1() {
        testPhoneBook.add("Vince", "555.867.5309");
        String testNumber = testPhoneBook.lookup("Vince");
        Assert.assertTrue(testNumber.equals("[555.867.5309]"));
    }

    @Test
    public void lookupTest2() {
        testPhoneBook.add("Marky", "555.867.5309");
        String testNumber = testPhoneBook.lookup("Marky");
        Assert.assertFalse(testNumber.equals("[555.867.1234]"));
    }


    @Test
    public void reverseLookupTest1() {
        testPhoneBook.add("Vince", "555.867.5309");
        String testNumber = testPhoneBook.reverseLookup("555.867.5309");
        Assert.assertTrue(testNumber.equals("Vince"));
    }

    @Test
        public void reverseLookupTest2() {
            testPhoneBook.add("Tim", "555.867.5309");
            testPhoneBook.add("Tebow", "555.867.5309");
            testPhoneBook.myTree.get("Tebow").addNumbers("111.222.3333");
            String testNumber = testPhoneBook.reverseLookup("111.222.3333");
            Assert.assertTrue(testNumber.equals("Tebow"));
    }

    @Test
    public void reverseLookupTest3() {
        testPhoneBook.add("Tim", "555.867.5309");
        testPhoneBook.add("Tebow", "555.867.5309");
        testPhoneBook.myTree.get("Tebow").addNumbers("111.222.3333");
        String testNumber = testPhoneBook.reverseLookup("111.999.3333");
        Assert.assertFalse(testNumber.equals("Tebow"));
    }

    @Test
    public void listNamesTest1() {
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNames();
        String expected = "Danny\nMarky\nRicky\nTerri\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNamesTest2() {
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNames();
        String expected = "Danny\nMarky\nGood Will\nTerri\n";
        Assert.assertNotEquals(expected, actual);
    }


    @Test
    public void listNamesAndNumbersTest1() {
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Danny: [888.546.9087]\nMarky: [888.546.9876]\nRicky: [888.555.3376]\nTerri: [888.123.7862]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listNamesAndNumbersTest2() {
        testPhoneBook.add("Marky", "888.546.9876");
        testPhoneBook.add("Ricky", "888.555.3376");
        testPhoneBook.add("Danny", "888.546.9087");
        testPhoneBook.add("Terri", "888.123.7862");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Joey: [888.546.9087]\nRobby: [888.546.9876]\nJohnny: [888.555.3376]\nBrian: [888.123.7862]\n";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void addMultipleNumbers1 () {
        testPhoneBook.add("Joey", "888.555.7890");
        testPhoneBook.add("Robby", "888.123.1234");
        testPhoneBook.add("Johnny", "888.321.5522");
        testPhoneBook.add("Brian", "888.999.9876");
        testPhoneBook.myTree.get("Robby").addNumbers("123.444.5555");
        testPhoneBook.myTree.get("Robby").addNumbers("123.555.1234");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Brian: [888.999.9876]\nJoey: [888.555.7890]\nJohnny: [888.321.5522]\nRobby: [888.123.1234, 123.444.5555, 123.555.1234]\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addMultipleNumbers2 () {
        testPhoneBook.add("Joey", "888.555.7890");
        testPhoneBook.add("Robby", "888.123.1234");
        testPhoneBook.add("Johnny", "888.321.5522");
        testPhoneBook.add("Brian", "888.999.9876");
        testPhoneBook.myTree.get("Robby").addNumbers("123.444.5555");
        testPhoneBook.myTree.get("Robby").addNumbers("123.555.1234");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Brian: [888.999.9876]\nJoey: [888.555.7890]\nJohnny: [888.321.5522]\nRobby: [888.123.1234]\n";
        Assert.assertNotEquals(expected, actual);
    }


    @Test
    public void removeNumberTest1 () {
        testPhoneBook.add("Joey", "888.555.7890");
        testPhoneBook.add("Robby", "888.123.1234");
        testPhoneBook.add("Johnny", "888.321.5522");
        testPhoneBook.add("Brian", "888.999.9876");
        testPhoneBook.myTree.get("Robby").addNumbers("123.444.5555");
        testPhoneBook.myTree.get("Robby").addNumbers("123.555.1234");
        testPhoneBook.myTree.get("Robby").removeNumbers("888.123.1234");
        String actual = testPhoneBook.listNamesAndNumbers();
        String expected = "Brian: [888.999.9876]\nJoey: [888.555.7890]\nJohnny: [888.321.5522]\nRobby: [123.444.5555, 123.555.1234]\n";
        Assert.assertEquals(expected, actual);
    }


}