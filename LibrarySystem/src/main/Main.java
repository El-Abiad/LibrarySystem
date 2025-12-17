package main;

import utils.FileManager;
import models.LibrarySystem;
import screens.LoginScreen;

public class Main {
    public static void main(String[] args) {

        LibrarySystem ls = new LibrarySystem();

        ls.getUsers().addAll(FileManager.ReadUsers());

        ls.getBooks().addAll(FileManager.ReadBooks());

        ls.getReservations().addAll(FileManager.ReadReservations());

        ls.getTransactions().addAll(FileManager.ReadTransactions());

        LoginScreen Launch = new LoginScreen();
        Launch.show();
    }
}
