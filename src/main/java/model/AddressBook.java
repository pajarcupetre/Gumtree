package model;

import java.util.HashMap;

public class AddressBook {
    private HashMap<String, User> users;

    public AddressBook(HashMap<String, User> users) {
        this.users = users;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
}
