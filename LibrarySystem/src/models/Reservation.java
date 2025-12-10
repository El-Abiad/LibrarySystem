package models;

import java.time.LocalDate;

public class Reservation {
    private Long id;
    private Long patronId;
    private Long bookId;
    private LocalDate reservationDate;
    private boolean notified;

    public Reservation(Long id, Long patronId, Long bookId) {
        this.id = id;
        this.patronId = patronId;
        this.bookId = bookId;
        this.reservationDate = LocalDate.now();
        this.notified = false;
    }

    public void markAsNotified() {
        this.notified = true;
    }

    public Long getId() { 
        return id; 
    }
    public Long getPatronId() { 
        return patronId; 
    }
    public Long getBookId() { 
        return bookId; 
    }
    public LocalDate getReservationDate() { 
        return reservationDate; 
    }
    public boolean isNotified() { 
        return notified; 
    }
}
