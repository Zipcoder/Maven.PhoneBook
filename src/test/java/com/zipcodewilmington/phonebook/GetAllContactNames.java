package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GetAllContactNames {
    @Test
    public void test1() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String[] names = new String[]{"Jay", "Jim", "Joe", "John"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            phoneBook.add(name, "");
        }

        // when
        List<String> actualNames = phoneBook.getAllContactNames();

        // then
        Assert.assertEquals(Arrays.asList(names), actualNames);
    }

    @Test
    public void test2() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String[] names = new String[]{"Chris", "Christian", "Christina", "Christopher"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            phoneBook.add(name, "");
        }

        // when
        List<String> actualNames = phoneBook.getAllContactNames();

        // then
        Assert.assertEquals(Arrays.asList(names), actualNames);
    }

    @Test
    public void test3() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String[] names = new String[]{"Aaron", "Albert", "Alfred", "Ashley"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            phoneBook.add(name, "");
        }

        // when
        List<String> actualNames = phoneBook.getAllContactNames();

        // then
        Assert.assertEquals(Arrays.asList(names), actualNames);
    }
}
