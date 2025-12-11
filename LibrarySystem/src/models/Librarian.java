package models;

import java.util.*;
import main.LibrarySystem;
import utils.IDGenerator;

public class Librarian extends User {
    private final LibrarySystem librarySystem;
    
    public Librarian(String username, String password, String phone, String email, LibrarySystem librarySystem) {
        super(IDGenerator.GenerateUserId(), username, password, phone, email, "Librarian");
        this.librarySystem = librarySystem;
    }

    public Transaction checkoutBook(Long patronId, Long bookId, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            if (book.isAvailable()) {
                return new Transaction(IDGenerator.GenerateTransactionId(), patronId, this.getId(), bookId, "Checkout");
            }
        }
        return null;
    }

    public boolean returnBook(Long patronId, Long bookId, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.get(bookId).updateStatus(true);
            return true;
        }
        return false;
    }

    public Reservation createReservation(Long patronId, Long bookId, Long librarianId, HashMap<Long, Book> bookMap) {
        if (bookMap.containsKey(bookId)) {
            bookMap.get(bookId).updateStatus(false);
        }
        return new Reservation(IDGenerator.GenerateReservationId(), patronId, bookId);
    }

    public void notifyPatron(Long reservationId, HashMap<Long, Reservation> resMap) {
        if (resMap.containsKey(reservationId)) {
            resMap.get(reservationId).markAsNotified();
        }
    }
}
