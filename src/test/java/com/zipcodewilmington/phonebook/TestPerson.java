package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class TestPerson {





    @Test
    public void testGetName() {
        //we place the expected on top
        String expected = "Nathaniel";
        Person person = new Person("Nathaniel", expected);


        //I don't need a setter, because i did "this.name"...remember
        String actual = person.getName();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetPhoneNumbers(){
        String expected = "8567744773";
        Person person = new Person("Nathaniel",expected);


        ArrayList<String> actual = person.getPhoneNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetAddAdditionalNumbers(){
        //Given
        String expected = "Karen";

        //When
        person.setPhoneNumbers(expected);


    }








  /*  @Test
    public void testSetAddName() {
        Person person = new Person();
        String expected = "Nathaniel";

        person.setAddName(expected);

        String actual = person.getAddName();
        Assert.assertEquals(expected, actual);


    }


    @Test
    public void testSetAddNumber() {
        Person person = new Person();
        String expected = "8567744733";

        person.setAddNumber(expected);

        String actual = person.getAddNumber();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetLookup() {
        Person person = new Person();
        String expected = "Samantha";

        person.setLookup(expected);

        String actual = person.getLookup();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRemoveName() {
        Person person = new Person();
        String expected = "Removal";

        person.setRemoveName(expected);

        String actual = person.getRemoveName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRemoveNumber() {
        Person person = new Person();
        String expected = "Remove Number";

        person.setRemoveNumber(expected);

        String actual = person.getRemoveNumber();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetListNames() {
        Person person = new Person();
        String expected = "List of Names";

        person.setListNames(expected);

        String actual = person.getListNames();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetListNumber() {
        Person person = new Person;
        String expected = "List Number";

        person.setListNumber(expected);

        String actual = person.getListNumber();
        Assert.assertEquals(expected, actual);
    }*/

}
