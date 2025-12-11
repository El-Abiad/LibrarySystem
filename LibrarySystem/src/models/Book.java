package models;

public class Book {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private Boolean available;

    public Book(Long id, String title, String author, String genre, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public void updateInfo(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.genre = genre;
    }

    public void updateStatus(Boolean available) {
        this.available = available;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString() {
        return this.id + " " + this.title + " " + this.author + " " + this.genre + " " + this.publicationYear;
    }

}
