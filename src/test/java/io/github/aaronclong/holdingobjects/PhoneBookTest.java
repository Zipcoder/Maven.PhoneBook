package io.github.aaronclong.holdingobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneBookTest {
  private PhoneBook phoneBook;
  private PhoneNumber phoneNumber;
  private ArrayList<PhoneNumber> numberList;

  @Before
  public void setUp() {
    try {
      phoneBook = new PhoneBook();
      phoneNumber = PhoneNumber.registerNumber(100, 500, 9000);
      numberList = new ArrayList<>();
    } catch(InvalidNumberException e) {
    }
  }

  @Test
  public void testLookupForValidReturn() {
    phoneBook.add("Dennis", phoneNumber);
    numberList.add(phoneNumber);
    assertEquals("Confirming same number Returned from PhoneBook", numberList, phoneBook.lookup("Dennis"));
  }

  @Test
  public void testLookupForNonExistingItem() {
    assertNull("Confirming null on non-existing item", phoneBook.lookup("Dennis"));
  }

  @Test
  public void testReverseLookupForRetrieval() {
    phoneBook.add("Dennis", phoneNumber);
    assertEquals("Asserting that values are retrievable", "Dennis",
            phoneBook.reverseLookup(phoneNumber));
  }

  @Test
  public void testReverseLookupForNullOnNoEntry() {
    assertNull("Confirming that none existing elements return null", phoneBook.reverseLookup(phoneNumber));
  }

  @Test
  public void testRemovalOfItemFromEntry() {
    assertNull("Confirming that none existing elements return null", phoneBook.reverseLookup(phoneNumber));
  }
}
