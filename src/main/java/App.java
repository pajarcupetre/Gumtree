import controller.AddressBookHandler;
import model.AddressBook;

public class App {

    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String inputFile = classloader.getResource("AddressBook").getPath();
        AddressBook addressBook = AddressBookHandler.loadAddress(inputFile);
        System.out.println("Male count: " + AddressBookHandler.genderCount(addressBook, "male"));
        System.out.println("Oldest User:" + AddressBookHandler.getOldestUser(addressBook));
        System.out.println("Bill number of days older than Paul:" +
                AddressBookHandler.countDaysBetWeen(addressBook, "Bill McKnight", "Paul Robinson"));
    }
}
