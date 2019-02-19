package com.zipcodewilmington.phonebook;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest1() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add(name: "", number: "");
        String testNumber = testPhoneBook.lookup(name:);
        Assert.assertFalse(testNumber.equals(""));
    }

    @Test
    public void addTest2() {
                    PhoneBook testPhoneBook = new PhoneBook();
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add ("", "");
        String testNumber = testPhoneBook.lookup ("");
        Assert.assertFalse(testNumber.equals(""));


    }
    @Test
    public void removeTest(){
        PhoneBook testPhoneBook = new PhoneBook();
    }

    @Test
    public void lookupTest1(){
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("", "");
        String testNumber = testPhoneBook.lookup("");
        Assert.assertFalse(testNumber.equals(""));
    }
    @Test
    public void lookupTest2(){
        PhoneBook testPhoneBook = new PhoneBook();
        testPhonebook.add("", "");
        String testNumber = testPhoneBook.lookup("");
        Assert.assertFalse(testNumber.equals(""));
    }
    @Test
    public void listNamesTest() {
        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add("", "");
        testPhoneBook.add("", "");
        testPhoneBook.add("", "");
        testPhoneBook.add("", "");
    }
    @Test
    public void listNamesAndNumbersTest(){

        PhoneBook testPhoneBook = new PhoneBook();
    }

}
