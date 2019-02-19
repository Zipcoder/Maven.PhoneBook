package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

   private PhoneBook testPhoneBook;

   @Before
   public void createPhone(){
      this.testPhoneBook = new PhoneBook();
   }

   @Test
   public void testAddEntry(){
      String number = "111111111";
      String name = "Albert";
      testPhoneBook.addEntry(name, number);
      String actual = testPhoneBook.entryLookup(name);
      String expected = "[111111111]";
      Assert.assertEquals(expected, actual);


   }

   @Test
   public void testAddEntry1(){
      String expected = null;
      String name = "Albert";
      testPhoneBook.addEntry(name, expected);
      String actual = testPhoneBook.entryLookup(name);
      Assert.assertFalse("You did not enter a number", false);
   }


   @Test (expected =  NullPointerException.class)
   public void testRemoveEntry(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.removeEntry(name, number);
      String actual = testPhoneBook.entryLookup(name);


   }

   @Test (expected = NullPointerException.class)
   public void testRemoveEntry1(){
      String expected = "Albert";
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.removeEntry(name, number);
      String actual = testPhoneBook.entryLookup(name);
   }

   @Test
   public void testEntryLookup(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.addEntry("Albert", "111111111");
      testPhoneBook.entryLookup(name);
      String expected = "[111111111]";
      String actual = testPhoneBook.entryLookup(name);
      Assert.assertEquals(expected, actual);

   }


   @Test
   public void testEntryListNames(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.addEntry(name, number);
      String name1 = "Bobby";
      String number1 = "222222222";
      testPhoneBook.addEntry(name1, number1);
      String name2 = "Catherine";
      String number2 = "333333333";
      testPhoneBook.addEntry(name2, number2);

      String expected = "[Albert, Bobby, Catherine]";
      String actual = testPhoneBook.entryListNames();
      Assert.assertEquals(expected, actual);

   }

//   @Test
//   public void testEntryListNumbers(){
//
//   }

   @Test
   public void testEntryListAll(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.addEntry(name, number);
      String name1 = "Bobby";
      String number1 = "222222222";
      testPhoneBook.addEntry(name1, number1);
      String name2 = "Catherine";
      String number2 = "333333333";
      testPhoneBook.addEntry(name2, number2);

      String expected = "Albert : [111111111]\nBobby : [222222222]\nCatherine : [333333333]\n";
      String actual = testPhoneBook.entryListAll();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void testReverseEntry(){
      String name = "Albert";
      String number = "111111111";
      testPhoneBook.addEntry(name, number);
      String expected = "Albert";
      String actual = testPhoneBook.reverseLookup(number);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void testremoveOnePhoneNum(){
      String name = "Albert";
      String number = "111111111";
      String number1 = "222222222";
      testPhoneBook.addEntry(name, number, number1);
      testPhoneBook.removeOneNumberfromEntry("Albert", "111111111");
      String expected = "[222222222]";
      String actual = testPhoneBook.entryLookup("Albert");
      Assert.assertEquals(expected, actual);

   }

}
