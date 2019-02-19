package com.zipcodewilmington.phonebook;
import java.util.Set;
import java.util.TreeMap;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    TreeMap<String, String> myTree = new TreeMap<String, String>();

    public PhoneBook (){

    }

    public void add(String name, String number){
        myTree.put(name, number);
    }

    public void remove(String name){
        myTree.remove(name);
    }

    public String lookup(String name){
        return myTree.get(name);
    }

    public String listNames(){
        String list = "";
        Set<String> keys = myTree.keySet();
        for (String i : keys){
            list += i + ":" + myTree.get(i)+"\n";
        }
        return list;

    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add(name: "", number: "");
        myPhoneBook.add(name: "", number: "");
        myPhoneBook.add(name: "", number: "");
        myPhoneBook.add(name: "", number: "");

        System.out.println(myPhoneBook. listNamesAndNumbers());


    }
}