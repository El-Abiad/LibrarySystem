package models;
import models.LibrarySystem;

public class User {

    private Long Id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String role;

    public User(Long Id, String username, String password, String phone, String email, String role) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }
    public User(Long Id, String username, String password) {
        this(Id, username, password, "", "", "Patron");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getId() {
        return this.Id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }
    public void setPassword(String s){
        this.password = s;
    }
    public void setRole(String s) {
        this.role = s;
    }

    public Book searchBook(Long bookId, LibrarySystem librarySystem) {
        return librarySystem.getBookById(bookId);
    }

    @Override
    public String toString() {
        return this.Id + " " + this.username + " " + this.password + " " + this.phone + " "
                + this.email + " " + this.role;
    }
}
