package screens.librarian;

import models.*;
import java.awt.*;
import javax.swing.*;

public class Welcome extends JFrame {

    private User librarian;

    private JPanel jPanel1;
    private JLabel jLabel1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    public Welcome(User librarian) {
        this.librarian = librarian;
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setSize(1920, 1750);
        setLocationRelativeTo(null); 

       
        setLayout(new BorderLayout());

       
        jPanel1.setBackground(Color.BLACK);
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 20, 20);

       
        jLabel1.setText("Welcome Librarian");
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 48));
        jLabel1.setForeground(new Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridy = 0;
        jPanel1.add(jLabel1, gbc);

        
        Font btnFont = new Font("Segoe UI", Font.BOLD, 24);
        Dimension btnSize = new Dimension(300, 60);

        jButton1.setText("Checkout Book");
        jButton1.setFont(btnFont);
        jButton1.setPreferredSize(btnSize);
        jButton1.addActionListener(e ->
                new CheckoutScreen(librarian).setVisible(true));

        gbc.gridy = 1;
        jPanel1.add(jButton1, gbc);

        jButton2.setText("Return Book");
        jButton2.setFont(btnFont);
        jButton2.setPreferredSize(btnSize);
        jButton2.addActionListener(e ->
                new ReturnScreen(librarian).setVisible(true));

        gbc.gridy = 2;
        jPanel1.add(jButton2, gbc);

        jButton3.setText("Make Reservation");
        jButton3.setFont(btnFont);
        jButton3.setPreferredSize(btnSize);
        jButton3.addActionListener(e ->
                new ReservationScreen(librarian).setVisible(true));

        gbc.gridy = 3;
        jPanel1.add(jButton3, gbc);

        jButton4.setText("Edit Profile");
        jButton4.setFont(btnFont);
        jButton4.setPreferredSize(btnSize);
        jButton4.addActionListener(e ->
                new EditScreen(librarian).setVisible(true));

        gbc.gridy = 4;
        jPanel1.add(jButton4, gbc);

        add(jPanel1, BorderLayout.CENTER);
    }
}
