package screens.patron;

import models.*;
import javax.swing.*;
import java.awt.*;

public class WelcomePatron extends JFrame {

    private User patron; 
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton dashboardBtn;
    private JButton searchBtn;
    private JButton contactBtn;
    private JButton LogOut;

    public WelcomePatron(User patron) {
        this.patron = patron;

        setTitle("Welcome Patron");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 20, 20);

        welcomeLabel = new JLabel("Welcome Patron");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 48));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy = 0;
        mainPanel.add(welcomeLabel, gbc);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 24);
        Dimension btnSize = new Dimension(300, 60);

        dashboardBtn = new JButton("Dashboard");
        dashboardBtn.setFont(btnFont);
        dashboardBtn.setPreferredSize(btnSize);
        dashboardBtn.addActionListener(e ->
                new PatronDashboard(patron).setVisible(true));
        gbc.gridy = 1;
        mainPanel.add(dashboardBtn, gbc);

        searchBtn = new JButton("Search Books");
        searchBtn.setFont(btnFont);
        searchBtn.setPreferredSize(btnSize);
        searchBtn.addActionListener(e ->
                new SearchBooksScreen().setVisible(true));
        gbc.gridy = 2;
        mainPanel.add(searchBtn, gbc);

        contactBtn = new JButton("Contact / Edit Profile");
        contactBtn.setFont(btnFont);
        contactBtn.setPreferredSize(btnSize);
        contactBtn.addActionListener(e ->
                new PatronContactScreen(patron).setVisible(true));
        gbc.gridy = 3;
        mainPanel.add(contactBtn, gbc);
        
        LogOut = new JButton("LogOut");
        LogOut.setFont(btnFont);
        LogOut.setPreferredSize(btnSize);
        LogOut.addActionListener(e -> {this.dispose(); (new screens.LoginScreen()).show();});
        gbc.gridy = 4;
        mainPanel.add(LogOut, gbc);
        add(mainPanel, BorderLayout.CENTER);
    }
}
