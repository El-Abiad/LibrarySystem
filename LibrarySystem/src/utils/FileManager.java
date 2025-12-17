package utils;

import java.util.*;
import java.io.*;
import models.*;

public abstract class FileManager {

    private static String usersfilepath = "src/files/users.txt";
    private static String booksfilepath = "src/files/books.txt";
    private static String transactionsfilepath = "src/files/transactions.txt";
    private static String Reservationfilepath = "src/files/Reservation.txt";
    private static String separator = "\\|";

    public static ArrayList<User> ReadUsers() {
        File f = new File(usersfilepath);
        ArrayList<User> u = new ArrayList<>();
        try {
            Scanner r = new Scanner(f);
            while (r.hasNext()) {
                String line = r.nextLine().trim();
                String[] parts = line.split(separator);
                User user = new User(Long.parseLong(parts[0]), parts[1], parts[2],
                        parts[3], parts[4], parts[5]);
                u.add(user);
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return u;
    }

    private static int FindUser(long id) {
        ArrayList<User> users = ReadUsers();
        int index=0;
        for (User user : users) {
            if (user.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void WriteUsers(ArrayList<User> users) {
        File f = new File(usersfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (FindUser(user.getId())!=-1) {
                    System.out.println("This user is in file,don't add him again.");
                    continue;
                }
                p.println(user.getId() + "|" + user.getUsername() + "|" + user.getPassword() + "|"
                        + user.getPhone() + "|" + user.getEmail() + "|" + user.getRole());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void SaveUsers(ArrayList<User> users) {
        File f = new File(usersfilepath);
        try {
            PrintWriter p = new PrintWriter(f);
            for (User user : users) {
                p.println(user.getId() + "|" + user.getUsername() + "|" + user.getPassword() + "|"
                        + user.getPhone() + "|" + user.getEmail() + "|" + user.getRole());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void SaveBooks(ArrayList<Book> books) {
        File f = new File(booksfilepath);
        try {
            PrintWriter p = new PrintWriter(f);
            for (Book b : books) {
                p.println(b.getId() + "|" + b.getTitle() + "|" + b.getAuthor() + "|"
                        + b.getGenre() + "|" + b.getPublicationYear());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void SaveTransactions(ArrayList<Transaction> transactions) {
        File f = new File(transactionsfilepath);
        try {
            PrintWriter p = new PrintWriter(f);
            for (Transaction t : transactions) {
                p.println(t.getId() + "|" + t.getPatronId() + "|" + t.getLibrarianId() + "|"
                        + t.getBookId() + "|" + t.getType());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void SaveReservations(ArrayList<Reservation> reservations) {
        File f = new File(Reservationfilepath);
        try {
            PrintWriter p = new PrintWriter(f);
            for (Reservation r : reservations) {
                p.println(r.getId() + "|" + r.getPatronId() + "|" + r.getBookId());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void updateuser(User u) {
        ArrayList<User> users = ReadUsers();
        int index=FindUser(u.getId());
        if (index!=-1) {
            users.set(index, u);
            SaveUsers(users);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void DeleteUser(Long uid) {
        ArrayList<User> users = ReadUsers();
        int index=FindUser(uid);
        if (index!=-1) {
            users.remove(index);
            SaveUsers(users);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User ID not found.");
        }
    }

    public static ArrayList<Book> ReadBooks() {
        File f = new File(booksfilepath);
        ArrayList<Book> b = new ArrayList<>();
        try {
            Scanner r = new Scanner(f);
            while (r.hasNext()) {
                String line = r.nextLine().trim();
                String[] parts = line.split(separator);
                Book book = new Book(Long.parseLong(parts[0]), parts[1], parts[2], parts[3],
                        Integer.parseInt(parts[4]));
                b.add(book);
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return b;
    }

    private static int FindBook(long id) {
        ArrayList<Book> books = ReadBooks();
        int index=0;
        for (Book b : books) {
            if (b.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void WriteBooks(ArrayList<Book> books) {
        File f = new File(booksfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (FindBook(b.getId())!=-1) {
                    System.out.println("This book is in file,don't add it again.");
                    continue;
                }
                p.println(b.getId() + "|" + b.getTitle() + "|" + b.getAuthor() + "|"
                        + b.getGenre() + "|" + b.getPublicationYear());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void UpdateBook(Book b) {
        ArrayList<Book> books = ReadBooks();
        int index=FindBook(b.getId());
        if (index!=-1){
            books.set(index, b);
            SaveBooks(books);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void DeleteBook(Long bid) {
        ArrayList<Book> books = ReadBooks();
        int index=FindBook(bid);
        if (index!=-1){
            books.remove(index);
            SaveBooks(books);
            System.out.println("Book Deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public static ArrayList<Transaction> ReadTransactions() {
        File f = new File(transactionsfilepath);
        ArrayList<Transaction> T = new ArrayList<>();
        try {
            Scanner r = new Scanner(f);
            while (r.hasNext()) {
                String line = r.nextLine().trim();
                String[] parts = line.split(separator);
                Transaction action = new Transaction(Long.parseLong(parts[0]), Long.parseLong(parts[1]),
                        Long.parseLong(parts[2]), Long.parseLong(parts[3]), parts[4]);
                T.add(action);
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return T;
    }

    private static int FindTransaction(long id) {
        ArrayList<Transaction> ts = ReadTransactions();
        int index=0;
        for (Transaction t : ts) {
            if (t.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void WriteTransaction(ArrayList<Transaction> transactions) {
        File f = new File(transactionsfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                if (FindTransaction(t.getId())!=-1) {
                    System.out.println("This Transaction is in file,don't add it again.");
                    continue;
                }
                p.println(t.getId() + "|" + t.getPatronId() + "|" + t.getLibrarianId() + "|"
                        + t.getBookId() + "|" + t.getType());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void UpdateTransaction(Transaction t) {
        ArrayList<Transaction> transactions = ReadTransactions();
        int index=FindTransaction(t.getId());
        if (index!=-1) {
            transactions.set(index,t);
            SaveTransactions(transactions);
            System.out.println("Transaction updated successfully.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    public static void DeleteTransaction(Long tid) {
        ArrayList<Transaction> transactions = ReadTransactions();
        int index=FindTransaction(tid);
        if (index!=-1) {
            transactions.remove(index);
            SaveTransactions(transactions);
            System.out.println("Transaction deleted successfully.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    public static ArrayList<Reservation> ReadReservations() {
        File f = new File(Reservationfilepath);
        ArrayList<Reservation> R = new ArrayList<>();
        try {
            Scanner r = new Scanner(f);
            while (r.hasNext()) {
                String line = r.nextLine().trim();
                String[] parts = line.split(separator);
                Reservation reserve = new Reservation(Long.parseLong(parts[0]),
                        Long.parseLong(parts[1]), Long.parseLong(parts[2]));
                R.add(reserve);
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return R;
    }

    private static int FindReservation(Long id) {
        ArrayList<Reservation> reservations = ReadReservations();
        int index=0;
        for (Reservation r : reservations) {
            if (r.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void WriteReservation(ArrayList<Reservation> reservations) {
        File f = new File(Reservationfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < reservations.size(); i++) {
                Reservation r = reservations.get(i);
                if (FindReservation(r.getId())!=-1) {
                    System.out.println("This Reservation is in file,don't add it again.");
                    continue;
                }
                p.println(r.getId() + "|" + r.getPatronId() + "|" + r.getBookId());
            }
            p.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void UpdateReservation(Reservation r) {
        ArrayList<Reservation> reservations = ReadReservations();
        int index=FindReservation(r.getId());
        if (index!=-1) {
            reservations.set(index, r);
            SaveReservations(reservations);
            System.out.println("Reservation updated successfully.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public static void DeleteReservation(Long rid) {
        ArrayList<Reservation> reservations = ReadReservations();
        int index=FindReservation(rid);
        if (index!=-1) {
            reservations.remove(index);
            SaveReservations(reservations);
            System.out.println("Reservation deleted successfully.");
        } else {
            System.out.println("Reservation ID not found.");
        }
    }
}
