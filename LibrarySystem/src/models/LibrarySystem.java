package models;

import java.util.ArrayList;

public class LibrarySystem {
    private final ArrayList<User> users;
    private final ArrayList<Book> books;
    private final ArrayList<Reservation> reservations;
    private final ArrayList<Transaction> transactions;

    public LibrarySystem() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public User getUserById(Long id) {
    for (User u : users) {
        if (u.getId().equals(id)) return u;
    }
    return null;
    }

    public Book getBookById(Long id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }
    public Reservation getReservationById(Long id) {
        for (Reservation r : reservations) {
            if (r.getId().equals(id)) return r;
        }
        return null;
    }

    public String getUsername(Long userId) {
        User user = getUserById(userId);
        return (user != null) ? user.getUsername() : null;
    }

    public String getUserPhone(Long userId) {
        User user = getUserById(userId);
        return (user != null) ? user.getPhone() : null;
    }
    
    public String getUserEmail(Long userId) {
        User user = getUserById(userId);
        return (user != null) ? user.getEmail() : null;
    }
    
    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
}
