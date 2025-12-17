//package GUI;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class AdminDashboard extends JFrame {
//    public AdminDashboard() {
//        setTitle("Admin Dashboard");
//        setSize(400, 500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBackground(Color.BLACK);
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(15,0,15,0);
//
//        JLabel title = new JLabel("Welcome Admin");
//        title.setForeground(Color.WHITE);
//        title.setFont(new Font("Arial",Font.BOLD,22));
//
//        JButton usersBtn = new JButton("Manage Users");
//        JButton booksBtn = new JButton("Manage Books");
//        JButton profileBtn = new JButton("Edit Profile");
//
//        gbc.gridy = 0; panel.add(title,gbc);
//        gbc.gridy = 1; panel.add(usersBtn,gbc);
//        gbc.gridy = 2; panel.add(booksBtn,gbc);
//        gbc.gridy = 3; panel.add(profileBtn,gbc);
//
//        usersBtn.addActionListener(e -> new ManageUsersFrame());
//        booksBtn.addActionListener(e -> new ManageBooksFrame());
//        profileBtn.addActionListener(e -> new EditProfileFrame());
//
//        add(panel);
//        setVisible(true);
//    }
//}
