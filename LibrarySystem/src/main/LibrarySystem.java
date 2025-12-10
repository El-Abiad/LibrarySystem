package main;

import java.util.HashMap;
import models.User;
import models.Book;
import models.Reservation;

public class LibrarySystem {
    private final HashMap<Long, User> userMap;
    private final HashMap<Long, Book> bookMap;
    private final HashMap<Long, Reservation> resMap;
    private Long userCount;
    private Long bookCount;

    public LibrarySystem() {
        this.userMap = new HashMap<>();
        this.bookMap = new HashMap<>();
        this.resMap = new HashMap<>();
        this.userCount = 0L;
        this.bookCount = 0L;
    }

    public String getUsername(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getUsername();
        }
        return null;
    }

    public String getUserPhone(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getPhone(); // Assumes User has getPhone() (implied by attributes)
        }
        return null;
    }

    public String getUserEmail(Long userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId).getEmail(); // Assumes User has getEmail() (implied by attributes)
        }
        return null;
    }

    public void decrementUsers() {
        if (this.userCount > 0) {
            this.userCount--;
        }
    }

    public void incrementUsers() {
        this.userCount++;
    }

    public void decrementBooks() {
        if (this.bookCount > 0) {
            this.bookCount--;
        }
    }

    public void incrementBooks() {
        this.bookCount++;
    }

    public Long getUserCount(){
        return this.userCount;
    }
    
    public HashMap<Long, Book> getBookMap() {
        return this.bookMap;
    }

    public HashMap<Long, User> getUserMap() {
        return this.userMap;
    }
}
