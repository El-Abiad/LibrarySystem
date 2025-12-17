package screens.librarian;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import models.*;
import utils.FileManager;

public class EditScreen extends JFrame {

    private JTextField emailField;
    private JTextField phoneField;
    private User user; 

    public EditScreen(User user) {
        if (user == null) {
            JOptionPane.showMessageDialog(null, "User is null! Cannot edit profile.");
            dispose();
            return;
        }
        this.user = user;

        setTitle("Edit Profile");
        setSize(1920, 1750);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Edit Profile", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 72));
        titleLabel.setBounds(0, 100, 1920, 100);
        add(titleLabel);

     
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        emailLabel.setBounds(600, 300, 200, 50);
        add(emailLabel);

        emailField = new JTextField(user.getEmail());
        emailField.setBounds(900, 300, 400, 50);
        emailField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(emailField);

     
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        phoneLabel.setBounds(600, 400, 200, 50);
        add(phoneLabel);

        phoneField = new JTextField(user.getPhone());
        phoneField.setBounds(900, 400, 400, 50);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(phoneField);

    
        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setBounds(760, 550, 400, 80);
        saveBtn.setBackground(Color.DARK_GRAY);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("Arial", Font.BOLD, 36));
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            try {
              
                user.setEmail(emailField.getText().trim());
                user.setPhone(phoneField.getText().trim());

               
                FileManager.updateuser(user);

                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while updating profile.");
            }
        });
    }

                 
}
