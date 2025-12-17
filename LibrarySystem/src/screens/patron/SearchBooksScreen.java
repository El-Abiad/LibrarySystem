package screens.patron;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import models.Book;
import models.LibrarySystem;

public class SearchBooksScreen extends JFrame {

    public SearchBooksScreen() {
        setTitle("Search Books");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Search Books");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(400, 40));
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        searchField.setBackground(Color.DARK_GRAY);
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);

        JButton searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("Arial", Font.BOLD, 20));
        searchBtn.setBackground(Color.GRAY);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFocusPainted(false);
        searchBtn.setMaximumSize(new Dimension(200, 50));
        searchBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setBackground(Color.BLACK);
        resultsArea.setForeground(Color.WHITE);
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scroll = new JScrollPane(resultsArea);
        scroll.getViewport().setBackground(Color.BLACK);
        scroll.setPreferredSize(new Dimension(600, 300));

        panel.add(Box.createVerticalGlue());
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(searchField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(searchBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(scroll);
        panel.add(Box.createVerticalGlue());

        add(panel);
        setVisible(true);

        ArrayList<Book> books = LibrarySystem.getBooks();
        searchBtn.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            StringBuilder results = new StringBuilder();
            for (Book b : books) {
                if (b.getTitle().toLowerCase().contains(query) || b.getAuthor().toLowerCase().contains(query)) {
                    results.append("ID: ").append(b.getId())
                           .append(", Title: ").append(b.getTitle())
                           .append(", Author: ").append(b.getAuthor())
                           .append(", Year: ").append(b.getPublicationYear())
                           .append("\n");
                }
            }
            if (results.length() == 0) results.append("No books found.");
            resultsArea.setText(results.toString());
        });
    }
}
