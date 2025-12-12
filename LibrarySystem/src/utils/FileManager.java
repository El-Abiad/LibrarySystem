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

    private static boolean FindUser(long id) {
        ArrayList<User> users = ReadUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void WriteUsers(ArrayList<User> users) {
        File f = new File(usersfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (FindUser(user.getId())) {
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

    private static boolean FindBook(long id) {
        ArrayList<Book> books = ReadBooks();
        for (Book b : books) {
            if (b.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void WriteBooks(ArrayList<Book> books) {
        File f = new File(booksfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (FindBook(b.getId())) {
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

    private static boolean FindTransaction(long id) {
        ArrayList<Transaction> ts = ReadTransactions();
        for (Transaction t : ts) {
            if (t.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void WriteTransaction(ArrayList<Transaction> transactions) {
        File f = new File(transactionsfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                if (FindTransaction(t.getId())) {
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

    private static boolean FindReservation(Long id) {
        ArrayList<Reservation> reservations = ReadReservations();
        for (Reservation r : reservations) {
            if (r.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void WriteReservation(ArrayList<Reservation> reservations) {
        File f = new File(Reservationfilepath);
        try {
            PrintWriter p = new PrintWriter(new FileWriter(f, true));
            for (int i = 0; i < reservations.size(); i++) {
                Reservation r = reservations.get(i);
                if (FindReservation(r.getId())) {
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
}
