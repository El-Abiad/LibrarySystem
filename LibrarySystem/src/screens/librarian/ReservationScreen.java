package screens.librarian;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import models.*;
import utils.FileManager;

public class ReservationScreen extends JFrame {

    private JTextField patronField;
    private JTextField bookField;

    public ReservationScreen(User librarian) {
        setTitle("Reserve Book");
        setSize(1920, 1750);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Reserve Book", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 72));
        titleLabel.setBounds(0, 100, 1920, 100);
        add(titleLabel);

        JLabel patronLabel = new JLabel("Patron ID:");
        patronLabel.setForeground(Color.WHITE);
        patronLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        patronLabel.setBounds(600, 300, 250, 50);
        add(patronLabel);

        patronField = new JTextField();
        patronField.setBounds(900, 300, 300, 50);
        patronField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(patronField);

        JLabel bookLabel = new JLabel("Book ID:");
        bookLabel.setForeground(Color.WHITE);
        bookLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        bookLabel.setBounds(600, 400, 250, 50);
        add(bookLabel);

        bookField = new JTextField();
        bookField.setBounds(900, 400, 300, 50);
        bookField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(bookField);

        JButton reserveBtn = new JButton("Reserve Book");
        reserveBtn.setBounds(760, 550, 400, 80);
        reserveBtn.setBackground(Color.DARK_GRAY);
        reserveBtn.setForeground(Color.WHITE);
        reserveBtn.setFont(new Font("Arial", Font.BOLD, 36));
        add(reserveBtn);

        reserveBtn.addActionListener(e -> {
            try {
                Long patronId = Long.parseLong(patronField.getText());
                Long bookId = Long.parseLong(bookField.getText());

                ArrayList<Reservation> reservations = FileManager.ReadReservations();
                Reservation r = new Reservation(System.currentTimeMillis(), patronId, bookId);
                reservations.add(r);

                FileManager.WriteReservation(reservations);
                JOptionPane.showMessageDialog(this, "Book reserved successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric IDs!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred during reservation.");
            }
        });
    }
     
}
