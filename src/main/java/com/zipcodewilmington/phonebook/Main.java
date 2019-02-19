package com.zipcodewilmington.phonebook;

public class Main {

    public static void main(String[] args) {

        PhoneBook tester = new PhoneBook();
        tester.addName("Keith", "555-666-7777");
        tester.addName("John", "555-612-7777");
        tester.addName("Mike", "555-623-7777");
        tester.addName("Steve", "555-645-7777");
       String s = tester.listNames();
        System.out.println(s);

        s = tester.listNamesAndNumbers();
        System.out.println(s);
    }
}
