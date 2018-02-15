package com.zipcodewilmington.phonebook;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)


@Suite.SuiteClasses({
        ListingTest.class,
        PhoneBookTest.class
})
public class TestSuite {
}