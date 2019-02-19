package com.zipcodewilmington.phonebook;

import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

private String nameEntry;
private String numberEntry;



   private TreeMap<String, ArrayList<String>> phoneBook = new TreeMap<String, ArrayList<String>>();

     public void addEntry(String nameEntry, String...numberEntry){
        ArrayList<String> phoneList = new ArrayList<String>();
        for (String number : numberEntry){
            phoneList.add(number);
        }
         phoneBook.put(nameEntry, phoneList);

    }

//    public String addNewNumbertoEntry(String nameEntry, String numberEntry) {
//         ContactEntry entry = new ContactEntry(nameEntry);
//         entry.addNumber((entryLookup(nameEntry)));
//         entry.addNumber(numberEntry);
//         addEntry(nameEntry, numberEntry);
//         return entryLookup(nameEntry);
//    }

     public void removeEntry(String nameEntry , String numberEntry){
        phoneBook.remove(nameEntry, numberEntry);

     }

     protected String entryLookup(String nameEntry){
        return phoneBook.get(nameEntry).toString();

     }

    public String entryListNames() {

        return phoneBook.keySet().toString();

        }

//    public String entryListNumbers() {
//        String fullListNumbers = "";
//        Set<String> keys = phoneBook.keySet();
//        for (String key: keys){
//            fullListNumbers += phoneBook.get(key) + "\n";
//
//        }
//        return fullListNumbers;
//    }

     public String entryListAll() {
        String fullListAll = "";
         Set<String> keys = phoneBook.keySet();
        for (String key: keys){
            fullListAll += key + " : " + phoneBook.get(key) + "\n";

        }
        return fullListAll;
     }

     public String reverseLookup(String numberEntry){
         Set<String> keys = phoneBook.keySet();
         for (String key: keys){
             if(phoneBook.get(key).contains(numberEntry)) {
                 return key;
             }
         }
         return "That number does not exist";
     }

     public void removeOneNumberfromEntry(String nameEntry, String numberEntry){
         int counter = 0;
         for (String phoneNum : phoneBook.get(nameEntry)){
             if (phoneNum.equals(numberEntry)){
                 phoneBook.get(nameEntry).remove(counter);
             }
         } counter++;
     }


    public static void main(String[] args) {
       PhoneBook nameNumber = new PhoneBook();
       nameNumber.addEntry("Albert", "111111111");
       nameNumber.addEntry("Bobby", "222222222");
       nameNumber.addEntry("Albert", "333333333", "444444444");
      //  System.out.println(nameNumber.entryLookup("Albert"));
        System.out.println(nameNumber.entryListAll());
        System.out.println(nameNumber.reverseLookup("333333333"));
    }

}
