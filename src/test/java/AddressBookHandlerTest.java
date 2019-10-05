import controller.AddressBookHandler;
import model.AddressBook;
import model.User;
import org.junit.Test;
import utils.DateHandler;

import static junit.framework.TestCase.assertEquals;

public class AddressBookHandlerTest {

    private AddressBook getAddressBook() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String inputFile = classloader.getResource("AddressBook").getPath();
        return AddressBookHandler.loadAddress(inputFile);
    }

    @Test
    public void testLoad(){
        AddressBook addressBook = getAddressBook();
        assertEquals(4, addressBook.getUsers().keySet().size());
    }

    @Test
    public void testCountFemale(){
        AddressBook addressBook = getAddressBook();
        long expected = 2;
        long actual = AddressBookHandler.genderCount(addressBook, "female");
        assertEquals(expected, actual);
    }

    @Test
    public void testCountMale(){
        AddressBook addressBook = getAddressBook();
        long expected = 2;
        long actual = AddressBookHandler.genderCount(addressBook, "male");
        assertEquals(expected, actual);
    }

    @Test
    public void testOldest(){
        AddressBook addressBook = getAddressBook();

        User expected = new User("Bill McKnight" ,"Male", DateHandler.formatDate("16/03/77"));
        User actual = AddressBookHandler.getOldestUser(addressBook);
        assertEquals(expected, actual);
    }

    @Test
    public void testDaysBetween() {
        AddressBook addressBook = getAddressBook();
        long actual = AddressBookHandler.countDaysBetWeen(addressBook, "Sarah Stone", "Gemma Lane");
        long expected = 4078;
        assertEquals(expected, actual);
    }
}
