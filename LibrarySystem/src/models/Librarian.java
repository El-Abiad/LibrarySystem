package models;

import java.util.*;
import utils.IDGenerator;

public class Librarian extends User {

    private final LibrarySystem librarySystem;

    public Librarian(String username, String password, String phone, String email, LibrarySystem librarySystem) {
        super(IDGenerator.GenerateUserId(), username, password, phone, email, "Librarian");
        this.librarySystem = librarySystem;
    }

    public Transaction checkoutBook(Long patronId, Long bookId) {
        Book book = librarySystem.getBookById(bookId);

        if (book != null && "Available".equals(book.getStatus())) {
            book.updateStatus("Checked Out");

            return new Transaction(
                IDGenerator.GenerateTransactionId(),
                patronId,
                this.getId(),
                bookId,
                "Checkout"
            );
        }

        return null;
    }

    public boolean returnBook(Long patronId, Long bookId) {
        Book book = librarySystem.getBookById(bookId);

        if (book != null) {
            book.updateStatus("Available");
            return true;
        }

        return false;
    }

    public Reservation createReservation(Long patronId, Long bookId) {
        Book book = librarySystem.getBookById(bookId);

        if (book != null) {
            book.updateStatus("Reserved");
        }

        Reservation res = new Reservation(
            IDGenerator.GenerateReservationId(),
            patronId,
            bookId
        );

        librarySystem.getReservations().add(res);

        return res;
    }

    public void notifyPatron(Long reservationId) {
        Reservation res = librarySystem.getReservationById(reservationId);

        if (res != null) {
            res.markAsNotified();
        }
    }
}
