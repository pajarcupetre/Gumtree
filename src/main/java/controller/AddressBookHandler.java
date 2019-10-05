package controller;

import model.AddressBook;
import model.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import utils.DateHandler;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.DAYS;

public class AddressBookHandler {

    public static AddressBook loadAddress(String fileInput) {
        Reader in = null;
        try {
            HashMap<String, User> users = new HashMap<String, User>();
            in = new FileReader(fileInput);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            for (CSVRecord record : records) {
                String name = record.get(0).trim();
                String gender = record.get(1).trim();
                String date = record.get(2).trim();
                users.put(name, new User(name, gender, DateHandler.formatDate(date)));
            }
            return new AddressBook(users);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long genderCount(AddressBook addressBook, String gender) {
        return addressBook.getUsers().values().stream().filter(
                user -> user.getGender().equalsIgnoreCase(gender)
        ).count();
    }

    public static User getOldestUser(AddressBook addressBook) {
        return addressBook.getUsers().values().stream().min(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        }).get();
    }

    public static long countDaysBetWeen(AddressBook addressBook, String userOne, String userTwo) {
        LocalDate userOneBirthday = addressBook.getUsers().get(userOne).getBirthday();
        LocalDate userTwoBirthday = addressBook.getUsers().get(userTwo).getBirthday();
        long daysBetween = DAYS.between(userOneBirthday, userTwoBirthday);
        return daysBetween;
    }
}
