package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */




public class PhoneBookTest {
    private static PhoneBook phoneBookRecord;

    @Before
    public void setUp() {
        //PhoneBook phoneBookRecord;
        Map<String,String>initialRecord = new TreeMap<String, String>(){ {put("John","1234567890");put("Micheal","5678901234");
            put("James","1234554321");}};
        this.phoneBookRecord=new PhoneBook(initialRecord);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLookup() {
        String expected = "5678901234";
        String actual = phoneBookRecord.lookup("Micheal");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testListNames(){
        String expected = "James\n" +
                            "John\n"+
                            "Micheal\n";
        String actual = phoneBookRecord.listNames();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testListNumbersAndNumbers(){
        String expected = "James    "+ "1234554321\n"+
                "John   "+"1234567890\n"+
                "Micheal    "+"5678901234";
        String actual =phoneBookRecord.listNamesAndNumbers();
        Assert.assertEquals(expected, actual);
    }


}
