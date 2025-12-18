package screens.admin;

import javax.swing.*;
import java.awt.*;
import models.LibrarySystem;

public class AdminDashboard extends JFrame {
    public AdminDashboard(LibrarySystem ls) {
        setTitle("Admin Dashboard");
        setSize(1920, 1750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,0,15,0);

        JLabel title = new JLabel("Welcome Admin");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,60));

        JButton usersBtn = new JButton("Manage Users");
        JButton booksBtn = new JButton("Manage Books");
        JButton profileBtn = new JButton("Edit Profile");
        JButton LogOutBtn = new JButton("LogOut");
        usersBtn.setFont(new Font("Arial", Font.BOLD, 36));
        booksBtn.setFont(new Font("Arial", Font.BOLD, 36));
        profileBtn.setFont(new Font("Arial", Font.BOLD, 36));
        LogOutBtn.setFont(new Font("Arial", Font.BOLD, 36));
        gbc.gridy = 0; panel.add(title,gbc);
        gbc.gridy = 1; panel.add(usersBtn,gbc);
        gbc.gridy = 2; panel.add(booksBtn,gbc);
        gbc.gridy = 3; panel.add(profileBtn,gbc);   
        gbc.gridy = 4; panel.add(LogOutBtn, gbc);

        usersBtn.addActionListener(e -> new ManageUsersFrame());
        booksBtn.addActionListener(e -> new ManageBooksFrame());
        profileBtn.addActionListener(e -> new EditProfileFrame());
        LogOutBtn.addActionListener(e -> {this.dispose(); (new screens.LoginScreen(ls)).show();});

        add(panel);
        setVisible(true);
    }
}
