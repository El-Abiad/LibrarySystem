package screens.patron;

import models.User;
import utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatronContactScreen extends JFrame {

    private User currentUser;
    private JTextField phoneField;
    private JTextField emailField;
    private JButton saveButton;

    public PatronContactScreen(User user) {
        this.currentUser = user;

        setTitle("Patron Contact Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel emailLabel = new JLabel("Email:");

        // Text fields
        phoneField = new JTextField(user.getPhone(), 20);
        emailField = new JTextField(user.getEmail(), 20);

        // Save button
        saveButton = new JButton("Save Changes");
        saveButton.addActionListener(e -> saveChanges());

        // Dark mode colors
        getContentPane().setBackground(Color.DARK_GRAY);
        phoneLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        phoneField.setBackground(Color.GRAY);
        phoneField.setForeground(Color.WHITE);
        emailField.setBackground(Color.GRAY);
        emailField.setForeground(Color.WHITE);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);

        // Add components
        gbc.gridx = 0; gbc.gridy = 0; add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; add(saveButton, gbc);

        setVisible(true);
    }

    private void saveChanges() {
        String newPhone = phoneField.getText().trim();
        String newEmail = emailField.getText().trim();

        currentUser.setPhone(newPhone);
        currentUser.setEmail(newEmail);

        // Call FileManager update function
        FileManager.updateuser(currentUser);

        JOptionPane.showMessageDialog(this, "Contact information updated!");
    }

    // Standalone test
}
