package models;

public class Book{
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String status;
    private Boolean available;
    private int amount;

    public Book(Long id, String title, String author, String genre, int publicationYear, int amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.amount = amount;
        this.available = amount > 0;
        this.status = "Available";
    }

    public boolean isAvailable() {
        return available;
    }

    public void updateInfo(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.genre = genre;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void decrementAmount() {
        if (amount > 0) {
            amount--;
            if (amount == 0) {
                available = false;
                status = "Unavailable";
            }
        }
    }

    public void incrementAmount() {
        amount++;
        if (amount > 0) {
            available = true;
            status = "Available";
        }
    }

    public Long getId() {
        return id; 
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() { 
        return author; 
    }
    public String getGenre() { 
        return genre; 
    }
    public int getPublicationYear() {
        return publicationYear; 
    }
    public String getStatus() { 
        return status; 
    }
    public int getAmount() { 
        return amount; 
    }
}
