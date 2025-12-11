package main;

import java.util.HashMap;
import models.User;
import models.Book;
import models.Reservation;

public class LibrarySystem {
    private final HashMap<Long, User> userMap;
    private final HashMap<Long, Book> bookMap;
    private final HashMap<Long, Reservation> resMap;

    public LibrarySystem() {
        this.userMap = new HashMap<>();
        this.bookMap = new HashMap<>();
        this.resMap = new HashMap<>();
    }

    public String getUsername(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getUsername();
        }
        return null;
    }

    public String getUserPhone(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getPhone();
        }
        return null;
    }

    public String getUserEmail(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getEmail();
        }
        return null;
    }
    
    public HashMap<Long, Book> getBookMap() {
        return this.bookMap;
    }

    public HashMap<Long, User> getUserMap() {
        return this.userMap;
    }
}
