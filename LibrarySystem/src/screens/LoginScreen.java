package screens;

import javax.swing.*;
import java.awt.*;
import models.*;

public class LoginScreen {
    private JFrame frame;
    public LoginScreen() {

        frame = new JFrame("Login Screen");
        frame.setSize(1920, 1750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        
        JLabel LogIn = new JLabel("LogIn");
        LogIn.setForeground(Color.WHITE);
        LogIn.setFont(new Font("Arial", Font.BOLD, 40));
        LogIn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel IDlabel = new JLabel("ID");
        IDlabel.setForeground(Color.WHITE);
        IDlabel.setFont(new Font("Arial", Font.BOLD, 24));
        IDlabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField IDField = new JTextField(15);
        IDField.setMaximumSize(new Dimension(300, 40));
        IDField.setFont(new Font("Arial", Font.BOLD, 20));
        IDField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passField = new JPasswordField(15);
        passField.setMaximumSize(new Dimension(300, 40));
        passField.setFont(new Font("Arial", Font.BOLD, 20));
        passField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(e -> {

            String id = IDField.getText();
            String password = new String(passField.getPassword());

            if (!id.matches("\\d+")) {
                JOptionPane.showMessageDialog(frame,
                        "ID must be numbers only!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            long userId = Long.parseLong(id);
            long userpass = Long.parseLong(password);

            User u = LibrarySystem.findUserById(userId);
            
            if (u == null || Long.parseLong(u.getPassword()) != userpass) {
                JOptionPane.showMessageDialog(frame,
                        "Invalid ID or password",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String role = u.getRole();
            if (role.equalsIgnoreCase("Admin")) {
            }
            else if (role.equalsIgnoreCase("Patron")) {
            }
            else if (role.equalsIgnoreCase("Librarian")) {
                new screens.librarian.Welcome(u).setVisible(true);
            }

            frame.dispose();
        });
        
        panel.add(Box.createVerticalStrut(40));
        panel.add(LogIn);
        panel.add(Box.createVerticalStrut(40));
        panel.add(IDlabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(IDField);
        panel.add(Box.createVerticalStrut(25));
        panel.add(passLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(passField);
        panel.add(Box.createVerticalStrut(35));
        panel.add(loginButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }
}
