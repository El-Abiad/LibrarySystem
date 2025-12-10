package models;

import java.util.Map;

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


    public Boolean login(Long id, String password) {
        return this.Id.equals(id) && this.password.equals(password);
    }

    public void logout() {
        
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername(){
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
    
    public Book searchBook(Long bookId, Map<Long, Book> bookMap) {
        if (bookMap != null && bookMap.containsKey(bookId)) {
            return bookMap.get(bookId);
        }
        return null;
    }
}
