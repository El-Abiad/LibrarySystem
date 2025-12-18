package models;

import java.util.ArrayList;
import LibrarySystem;

public class Patron extends User {
    private ArrayList<Transaction> history;

    public Patron(Long id, String username, String password, String phone, String email) {
        super(id, username, password, phone, email, "Patron");
        this.history = new ArrayList<>();
    }
    
    public Book searchBook(String keyword, ArrayList<Book> books) {
        for (Book b : books) {
            if (b.getTitle().contains(keyword.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

    public Book searchAuthor(String keyword, ArrayList<Book> books) {
        for (Book b : books) {
            if (b.getAuthor().contains(keyword.toLowerCase())) {
                return b;
            }
        }
        return null;
    }

    public ArrayList<Transaction> viewHistory() {
        return history;
    }

    public boolean renewBook(Long bookId) {
        return true;
    }

    public Transaction reserveBook(Long bookId, Long librarianId) {
        return new Transaction(IDGenerator.GenerateTransactionId(), this.getId(), librarianId, bookId, "Reservation");
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
}


