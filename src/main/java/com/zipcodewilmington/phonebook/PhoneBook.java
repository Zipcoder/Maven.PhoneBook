package com.zipcodewilmington.phonebook;
import java.util.*;
import java.util.Arrays;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, List<String>> phoneBookRecords;

    public PhoneBook() {
        phoneBookRecords = new TreeMap<String, List<String>>();
    }

    /**
     * adds a name and corresponding phone number to phone book
     *
     * @param name
     * @param number
     */
    public Boolean nameAndNumber(String name, String number) {
        if (phoneBookRecords.containsKey(name)) {
            phoneBookRecords.get(name).add(number);
            return true;
        }
        List<String> newNumber = new ArrayList<String>();
        newNumber.add(number);
        phoneBookRecords.put(name, newNumber);
        return true;
    }

    /**
     * uses name to retrieve and delete both name and phone number
     *
     * @param name
     */
    public boolean deleteNameAndNumber(String name) {
        return phoneBookRecords.remove(name) != null;
    }


    /**
     * retrieves phone number by name
     *
     * @param name
     */
    public String returnNumber(String name) {
        return join(phoneBookRecords.get(name));
    }

    /**
     * retrieves name by phone number
     *
     * @param number
     */
    public String returnName(String number) {
        for (String nameKey : phoneBookRecords.keySet()) {
            List<String> name4Number = phoneBookRecords.get(nameKey);
            if(name4Number.contains(number)){
                return nameKey;
            }
        }
        return "";
    }

    /**
     * returns alphabetical list of all names in phoneBook
     */
    public String listAllNames() {
        StringBuilder list = new StringBuilder();
        Formatter listNames = new Formatter(list);
        for (String nameKey : phoneBookRecords.keySet()) {
            listNames.format("Name: %s%n", nameKey);
        }
        return list.toString();
    }

    /**
     * returns alphabetical list of all records in phoneBook
     */
    public String listAllNamesAndNumbers() {
        StringBuilder list = new StringBuilder();
        Formatter listNameNNumbers = new Formatter(list);
        for (String nameKey : phoneBookRecords.keySet()) {
            listNameNNumbers.format("Name: %s PhoneNumber: %-10s%n", nameKey, join(phoneBookRecords.get(nameKey)));
        }
        return list.toString();
    }

    /**
     * joins a list by a delimiter
     * @param listNum
     * @return String
     */
    public static String join(List<String> listNum){

        if(listNum.size() == 1){
            return listNum.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < listNum.size(); i++)
        {
            sb.append(listNum.get(i));
            if (i < listNum.size()-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        PhoneBook lancasterPeople = new PhoneBook();
        lancasterPeople.nameAndNumber("Javez", "3024785643");
        lancasterPeople.nameAndNumber("Nick", "3029876543");
        lancasterPeople.nameAndNumber("Jake", "3024556789");
        lancasterPeople.nameAndNumber("Jayden", "3028990078");
        lancasterPeople.nameAndNumber("Alex", "3025557896");
        lancasterPeople.nameAndNumber("Logan", "3023324566");
        lancasterPeople.nameAndNumber("Lance", "3021245432");


        String x = lancasterPeople.listAllNamesAndNumbers();
        System.out.println(x);

        String y = lancasterPeople.listAllNames();
        System.out.println(y);


    }

}