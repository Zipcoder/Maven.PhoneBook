package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map <String, List<String>> mapPhone;
    private List<String> existingList = new ArrayList<>();



    public PhoneBook(Map<String, List<String>> map) {
        this.mapPhone = map;
    }


    public PhoneBook() {
        mapPhone = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (mapPhone.containsKey(name))
        {
            existingList = mapPhone.get(name);
            existingList.add(phoneNumber);
            mapPhone.replace(name, existingList);
        }
        else
        {
            // existingList = new ArrayList<>();
            existingList.add(phoneNumber);
            mapPhone.put(name,existingList);
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        if (mapPhone.containsKey(name))
        {
            existingList = mapPhone.get(name);
            ArrayList ph = new ArrayList<String>(Arrays.asList(phoneNumbers));
            existingList.addAll(ph);
            mapPhone.replace(name, existingList);
        }
        else
        {
            // existingList = new ArrayList<>();
            ArrayList ph = new ArrayList<String>(Arrays.asList(phoneNumbers));
            existingList.addAll(ph);
            mapPhone.put(name,existingList);
        }
    }


    public void remove(String name) {
        mapPhone.remove(name);
    }

    public Boolean hasEntry(String phoneNumber) {
        return reverseLookup(phoneNumber)!="";
    }

    public List<String> lookup(String name) {
        return mapPhone.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String nameofPhonenumber = "";
        Iterator it = mapPhone.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            existingList  = (List<String>)pair.getValue();
            if (existingList.contains(phoneNumber))
            {
                nameofPhonenumber = (String)pair.getKey();
                break;
            }
        }
        return nameofPhonenumber;
    }

    public List<String> getAllContactNames() {
        existingList.clear();
        Set nameSet = mapPhone.keySet();
        existingList.addAll(nameSet);
        return existingList;
    }

    public Map<String, List<String>> getMap() {
        return mapPhone;
    }
}







//package com.zipcodewilmington.phonebook;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
///**
// * Created by leon on 1/23/18.
// */
//public class PhoneBook {
//    private LinkedHashMap <String, List<String>> map;
//    private List<String> existingList;
//
//    //THE KEY IS NAME THE VALUE IS THE PHONE NUMBERS
//    //THE ARRAY LIST IS PART OF THE (HASH)MAP
//
//
//    public PhoneBook(LinkedHashMap<String, List<String>> map) {
//        this.map = map;
//    }
//
//    public PhoneBook() {
//
//        this.map = new LinkedHashMap<>(0);
//    }
//
//    public void add(String name, String phoneNumber) {
//            if (map.containsKey(name))
//            {
//                existingList = map.get(name);
//                existingList.add(phoneNumber);
//                map.replace(name, existingList);
//            }
//            else
//            {
//                // existingList = new ArrayList<>();
//                existingList.add(phoneNumber);
//                map.put(name,existingList);
//            }
//
//        }
//
////        if(this.map.containsKey(name)) {
////            this.map.get(name).add(phoneNumber);
////        } else {
////            this.map.put(name, new ArrayList<>());
////            this.map.get(name).add(phoneNumber);
////        }
//
//
//       // map.put(name, Arrays.asList(phoneNumber));
//
//
////        ArrayList<String> numbers;
////        if(this.map.containsKey(name)){
////           numbers = map.get(name);   //pulls out and returns the value for the key "name" in the ArrayList of existing phone numbers
////            numbers.add(phoneNumber); }  //adds the phone number to the array List
////        else
////        {
////             numbers = new ArrayList<>(Arrays.asList(phoneNumber)); //If the key isn't there we create a new ArrayList key for it
////        }
////        map.put(name, numbers);        //puts the new information into the map
//    //}
//
//    public void addAll(String name, String... phoneNumbers) {
//        if(this.map.containsKey(name)) {
//            this.map.get(name).addAll(Arrays.asList(phoneNumbers));
//        } else {
//            this.map.put(name, Arrays.asList(phoneNumbers));
//        }
//
//
//        //adds many phone numbers to a single name entry
//        //map.put(name, Arrays.asList(phoneNumbers));
//
////        ArrayList<String> numbers;
////
////            numbers = map.getOrDefault(name, new ArrayList <String>());      //pulls out the ArrayList of existing phone numbers
////            ArrayList<String> incomingNums = new ArrayList<>(Arrays.asList(phoneNumbers));  //turns the regular Array of incoming phone numbers to an array List
////            numbers.addAll(incomingNums);
////
////        map.put(name, numbers);
//    }
//
//    public void remove(String name) {
//        this.map.remove(name);
//    }
//
//    public Boolean hasEntry(String name) {
//        existingList = new ArrayList <String> (map.keySet());
//
//        return map.containsKey(name);
//    }
//
//    public List<String> lookup(String name) {
//        return map.get(name);
//    }
//
//    public String reverseLookup(String phoneNumber) {
//        //ArrayList<String> values= new ArrayList<String>(map.values());
//
//        String nameToFind = "";
//        ArrayList<String> phoneNums = new ArrayList<>();
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            phoneNums = (ArrayList<String>) pair.getValue();
//            if (phoneNums.contains(phoneNumber)) {
//                nameToFind = (String) pair.getKey();
//                break;
//            }
//
//        }
//        return nameToFind;
//    }
//
//
////        for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
////            List<String> listOfPhoneNumbers = map.get(entry.getKey());
////            for (int i = 0; i < listOfPhoneNumbers.size(); i++) {
////                if (listOfPhoneNumbers.get(i).equals(phoneNumber)) {
////                    nameToFind = entry.getKey();
////                }
////            }
////        }
////        return nameToFind;
////    }
//
//    public List<String> getAllContactNames() {
//
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String,List<String>> entry: map.entrySet()) {
//            result.add(entry.getKey());
//        }
//        return result;
//    }
//
//    public Map<String, List<String>> getMap() {
//
//        return this.map;
//    }
//}
