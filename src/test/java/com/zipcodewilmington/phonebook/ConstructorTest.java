package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ConstructorTest {
    @Test
    public void testNullaryConstructor() {
        // given
        // when
        PhoneBook phoneBook = new PhoneBook();

        // then
        Assert.assertTrue(phoneBook.getMap() instanceof LinkedHashMap);
    }

    @Test
    public void testNonNullaryConstructor() {
        // given
        LinkedHashMap<String, List<String>> dependency = new LinkedHashMap<>();

        // when
        PhoneBook phoneBook = new PhoneBook(dependency);

        // then
        Assert.assertEquals(dependency, phoneBook.getMap());
    }
}
