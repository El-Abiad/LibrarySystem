package main;

import utils.FileManager;
import models.LibrarySystem;

public class Main {
    public static void main(String[] args) {

        LibrarySystem ls = new LibrarySystem();
        FileManager fm = new FileManager();

        ls.getUsers().addAll(fm.ReadUsers());

        ls.getBooks().addAll(fm.ReadBooks());

        ls.getReservations().addAll(fm.ReadReservations());

        ls.getTransactions().addAll(fm.ReadTransactions());

        System.out.println("Library system loaded successfully!");
    }
}
