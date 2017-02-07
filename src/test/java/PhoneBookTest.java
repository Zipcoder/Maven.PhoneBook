import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by randallcrame on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook testBook;
    String  testName = "testName",
            testName2 = "testName2",
            number = "555-555-5555",
            number2 = "555-555-5556",
            tooLong = "jdiggjdneebsh3455hdbsssdghensjeeeqwhd";

    @Before
    public void setUp(){
        testBook =  new PhoneBook();
        testBook.add(testName, number);
    }

    @Test
    public void lookUpTest(){
        String expected = number;
        String actual = testBook.lookUp(testName);
        Assert.assertEquals("Expected number '555-555-5555' to return", expected, actual);
    }

    @Test
    public void lookUpTestNotListed(){
        String expected = "Name not listed";
        String actual = testBook.lookUp(testName2);
        Assert.assertEquals("Expected number 'Name not listed' to return", expected, actual);
    }

    @Test
    public void lookUpTestEmpty(){
        testBook.remove(testName);
        String expected = "List Empty";
        String actual = testBook.lookUp(testName);
        Assert.assertEquals("Expected number 'List Empty' to return", expected, actual);
    }
    @Test
    public void lookUpTestInt(){
        String expected = "Name not listed";
        String actual = testBook.lookUp(testName2);
        Assert.assertEquals("Expected number 'Name not listed' to return", expected, actual);
    }

    @Test
    public void lookUpTestLongString(){
        String expected = "String > 32 characters";
        String actual = testBook.lookUp(tooLong);
        Assert.assertEquals("Expected number 'String > 32' to return", expected, actual);
    }

    @Test
    public void addTest(){
        testBook.add(testName2, number2);
        int expected = 2;
        int actual = testBook.getAddressBook().size();
        Assert.assertEquals("Expect address book size to be 2", expected, actual);
    }

    @Test
    public void addTestDuplicate(){
        testBook.add(testName, number);
        int expected = 1;
        int actual = testBook.getAddressBook().size();
        Assert.assertEquals("Expect address book size to be 1", expected, actual);
    }

    @Test
    public void removeTest(){
        testBook.remove(testName);
        int expected = 0;
        int actual = testBook.getAddressBook().size();
        Assert.assertEquals("Expects size to be 0", expected, actual);
    }

    @Test
    public void removeTestEmpty(){
        testBook.remove(testName);
        testBook.remove(testName);
        int expected = 0;
        int actual = testBook.getAddressBook().size();
        Assert.assertEquals("Expects size to be 0", expected, actual);

    }

    @Test
    public void removeTestNonExist(){
        testBook.remove(testName2);
        int expected = 1;
        int actual = testBook.getAddressBook().size();
        Assert.assertEquals("Expects size to be 1", expected, actual);

    }

    @Test
    public void printNameList(){
        testBook.add(testName2, number2);
        String expected = testName +"\n" +testName2;
        String actual = testBook.printNameList();
        Assert.assertEquals("Expected Name list to return", expected, actual);
    }

    @Test
    public void printNameListEmpty(){
        testBook.remove(testName);
        String expected = "List is empty";
        String actual = testBook.printNameList();
        Assert.assertEquals("Expected 'List is empty' return", expected, actual);
    }
    @Test
    public void printEntryList(){
        testBook.add(testName2, number2);
        String expected = testName +" : " + number + "\n"
                            + testName2 + " : " + number2;
        String actual = testBook.printEntryList();
        Assert.assertEquals("Expected Entry list to return", expected, actual);
    }

    @Test
    public void printEntryListEmpty(){
        testBook.remove(testName);
        String expected = "List is empty";
        String actual = testBook.printEntryList();
        Assert.assertEquals("Expected 'List is empty' return", expected, actual);
    }

    @Test
    public void reverseLookUpTest(){
        String expected = testName;
        String actual = testBook.reverseLookUp(number);
        Assert.assertEquals("Expected testName to return", expected, actual
        );
    }

    @Test
    public void reverseLookUpTestEmpty(){
        testBook.remove(testName);
        String expected = "List is empty";
        String actual = testBook.reverseLookUp(number);
        Assert.assertEquals("Expected 'List is empty' to return", expected, actual);
    }

    @Test
    public void reverseLookUpMissingTest(){
        String expected = "Name not found";
        String actual = testBook.reverseLookUp(number2);
        Assert.assertEquals("Expected 'Name not found' to return", expected, actual
        );
    }

    @Test
    public void reverseLookUpTooLongTest(){
        String expected = "Name not found";
        String actual = testBook.reverseLookUp(tooLong);
        Assert.assertEquals("Expected 'Name not found' to return", expected, actual
        );
    }
}
