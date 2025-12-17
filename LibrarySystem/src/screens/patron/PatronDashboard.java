package screens.patron;

import models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatronDashboard extends JFrame {

    private User currentUser;

    public PatronDashboard(User user) {
        this.currentUser = user;

        setTitle("Patron Dashboard");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.DARK_GRAY);

        // Top panel - Welcome
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new Dimension(800, 80));
        JLabel welcomeLabel = new JLabel("Welcome, " + currentUser.getUsername());
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(welcomeLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setLayout(new GridLayout(2, 2, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JButton myBooksButton = createButton("My Books");
        JButton reservationsButton = createButton("Reservations");
        JButton transactionsButton = createButton("Transactions");
        JButton profileButton = createButton("Profile");

        centerPanel.add(myBooksButton);
        centerPanel.add(reservationsButton);
        centerPanel.add(transactionsButton);
        centerPanel.add(profileButton);

        add(centerPanel, BorderLayout.CENTER);

        // Button actions
        //myBooksButton.addActionListener(e -> new MyBooksScreen(currentUser));
        reservationsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Reservations Screen"));
        transactionsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Open Transactions Screen"));
        profileButton.addActionListener(e -> new PatronContactScreen(currentUser));

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.LIGHT_GRAY);
                button.setForeground(Color.BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.GRAY);
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }    
}
