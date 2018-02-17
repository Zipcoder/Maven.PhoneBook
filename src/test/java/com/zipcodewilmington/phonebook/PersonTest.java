package com.zipcodewilmington.phonebook;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Created by Luis J. Romero on 2/12/2018
 */

public class PersonTest {

    private static Person person;

    @Before
    public void setup() {
        this.person = new Person("John Smith", "(111) 222-3333");
    }

    @Test
    public void setNameTest() {
        String expected = "John Smith";
        person.setName(expected);
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        String expected = "John Smith";
        String actual = person.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPhoneNumberListArrayTest() {
        this.person = new Person("Adam", "(000) 000-0000", "(011) 111-1111");

        String expectedPhoneNumber1 = "(000) 000-0000";
        String expectedPhoneNumber2 = "(011) 111-1111";

        String actualPhoneNumber1 = person.getPhoneNumberListArray().get(0);
        String actualPhoneNumber2 = person.getPhoneNumberListArray().get(1);

        Assert.assertEquals(expectedPhoneNumber1, actualPhoneNumber1);
        Assert.assertEquals(expectedPhoneNumber2, actualPhoneNumber2);
    }

    @Test
    public void getPhoneNumberListArrayStringTest() {
        this.person = new Person("Adam", "(000) 000-0000", "(011) 111-1111");

        String expectedPhoneNumbers = "\t" + "(000) 000-0000" + "\n" +
                                      "\t" + "(011) 111-1111" + "\n";
        String actualPhoneNumbers = person.getPhoneNumberListString();

//        System.out.println(expectedPhoneNumbers);
//        System.out.println(person.getPhoneNumberListString());

        Assert.assertEquals(expectedPhoneNumbers, actualPhoneNumbers);
    }


    @Test
    public void addPhoneNumbersTest() {
        this.person = new Person("John Smith", "(000) 000-0000");
        String expectedPhoneNumberToAdd1 = "(111) 111-1111";
        String expectedPhoneNumberToAdd2 = "(222) 222-2222";

        this.person.addPhoneNumbers(expectedPhoneNumberToAdd1, expectedPhoneNumberToAdd2);

        String actualPhoneNumberAdded1 = this.person.phoneNumberList.get(1);
        String actualPhoneNumberAdded2 = this.person.phoneNumberList.get(2);

        Assert.assertEquals(expectedPhoneNumberToAdd1, actualPhoneNumberAdded1);
        Assert.assertEquals(expectedPhoneNumberToAdd2, actualPhoneNumberAdded2);

    }

    @Test
    public void removePhoneNumbersTest() {
        this.person = new Person("John Smith", "(000) 000-0000", "(111) 111-1111", "(222) 222-2222");
        String expectedPhoneNumberToDelete1 = "(111) 111-1111";
        String expectedPhoneNumberToDelete2 = "(222) 222-2222";

        this.person.removePhoneNumbers(expectedPhoneNumberToDelete1, expectedPhoneNumberToDelete2);

        boolean isPhoneNumberInList1 = this.person.phoneNumberList.contains(expectedPhoneNumberToDelete1);
        boolean isPhoneNumberInList2 = this.person.phoneNumberList.contains(expectedPhoneNumberToDelete2);

        Assert.assertFalse(isPhoneNumberInList1);
        Assert.assertFalse(isPhoneNumberInList2);
    }

}

