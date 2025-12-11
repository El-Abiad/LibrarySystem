package models;

import main.LibrarySystem;
import java.util.*;
import utils.IDGenerator;

public class Admin extends User {
    private final LibrarySystem librarySystem;
    public Admin(String username, String password, String phone, String email, IDGenerator generate, LibrarySystem librarySystem) {
        super(IDGenerator.GenerateUserId(), username, password, phone, email, "Admin");
        this.librarySystem = librarySystem;
    }

    public User createUser(String username, String email, String phone, String password, String role) {
        Long userId = IDGenerator.GenerateUserId();
        User newUser = new User(userId, username, password, phone, email, role);
        librarySystem.getUserMap().put(userId, newUser);
        return newUser;
    }

    public boolean deleteUser(Long userId) {
        if (librarySystem.getUserMap().containsKey(userId)) {
            librarySystem.getUserMap().remove(userId);
            return true;
        }
        return false;
    }
    
    public Boolean updateOwnUsername(Long userId, String newName) {
        if (this.getId().equals(userId)) {
            this.setUsername(newName);
            return true;
        }
        return false;
    }

    public Boolean updateOwnPhone(Long userId, String newPhone) {
        if (this.getId().equals(userId)) {
            this.setPhone(newPhone);
            return true;
        }
        return false;
    }

    public Boolean updateOwnEmail(Long userId, String newEmail) {
        if (this.getId().equals(userId)) {
            this.setEmail(newEmail);
            return true;
        }
        return false;
    }
    
    public Boolean updateUsername(Long userId, String newName, HashMap<Long, User> userMap) {
        if (userMap.containsKey(userId)) {
            User u = userMap.get(userId);
            u.setUsername(newName);
            return true;
        }
        return false;
    }

     public Boolean updateUserPhone(Long userId, String newPhone, HashMap<Long, User> userMap) {
        if (userMap.containsKey(userId)) {
            User u = userMap.get(userId);
            u.setPhone(newPhone);
            return true;
        }
        return false;
    }

    public Boolean updateUserEmail(Long userId, String newEmail, HashMap<Long, User> userMap) {
        if (userMap.containsKey(userId)) {
            User u = userMap.get(userId);
            u.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public Boolean addBook(String title, String author, int year, String genre, int amount, HashMap<Long, Book> bookMap) {
        Long newId = (long) (bookMap.size() + 1);
        Book book = new Book(newId, title, author, genre, year, amount);
        bookMap.put(newId, book);
        IDGenerator.GenerateBookId();
        return true;
    }

    public Boolean updateBook(Long bookId, String title, String author, int year, String genre, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.get(bookId).updateInfo(title, author, year, genre);
            return true;
        }
        return false;
    }

    public boolean removeBook(Long bookId, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.remove(bookId);
            return true;
        }
        return false;
    }

    public Boolean updateBookStatus(Long bookId, String status, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.get(bookId).updateStatus(status);
            return true;
        }
        return false;
    }
}
