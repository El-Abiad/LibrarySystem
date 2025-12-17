package models;

import java.util.ArrayList;
public class LibrarySystem {
    private final static ArrayList<User> users = new ArrayList<>();
    private final static ArrayList<Book> books= new ArrayList<>();
    private final static ArrayList<Reservation> reservations = new ArrayList<>();
    private final static ArrayList<Transaction> transactions = new ArrayList<>();

    public LibrarySystem() {
        
    }

    public static User findUserById(Long userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private Book findBookById(Long bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private Reservation findReservationById(Long resId) {
        for (Reservation res : reservations) {
            if (res.getId().equals(resId)) {
                return res;
            }
        }
        return null;
    }

    public String getUsername(Long userId) {
        User user = findUserById(userId);
        return (user != null) ? user.getUsername() : null;
    }

    public String getUserPhone(Long userId) {
        User user = findUserById(userId);
        return (user != null) ? user.getPhone() : null;
    }

    public String getUserEmail(Long userId) {
        User user = findUserById(userId);
        return (user != null) ? user.getEmail() : null;
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
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
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
}
