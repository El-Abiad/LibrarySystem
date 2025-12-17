package models;

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
        librarySystem.getUsers().add(newUser);
        return newUser;
    }

    public boolean deleteUser(Long userId) {
        ArrayList<User> users = librarySystem.getUsers();
        return users.removeIf(u -> u.getId().equals(userId));
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

    public Boolean updateUsername(Long userId, String newName) {
        User user = librarySystem.getUserById(userId);
        if (user != null) {
            user.setUsername(newName);
            return true;
        }
        return false;
    }

    public Boolean updateUserPhone(Long userId, String newPhone) {
        User user = librarySystem.getUserById(userId);
        if (user != null) {
            user.setPhone(newPhone);
            return true;
        }
        return false;
    }

    public Boolean updateUserEmail(Long userId, String newEmail) {
        User user = librarySystem.getUserById(userId);
        if (user != null) {
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public Boolean addBook(String title, String author, int year, String genre) {
        Long newId = IDGenerator.GenerateBookId();
        Book book = new Book(newId, title, author, genre, year);
        librarySystem.getBooks().add(book);
        return true;
    }

    public Boolean updateBook(Long bookId, String title, String author, int year, String genre) {
        Book book = librarySystem.getBookById(bookId);
        if (book != null) {
            book.updateInfo(title, author, year, genre);
            return true;
        }
        return false;
    }

    public boolean removeBook(Long bookId) {
        ArrayList<Book> books = librarySystem.getBooks();
        return books.removeIf(b -> b.getId().equals(bookId));
    }

    
}
