package screens.admin;

import models.Book;
import utils.IDGenerator;
import utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManageBooksFrame extends JFrame {

    ArrayList<Book> books = new ArrayList<>();
    DefaultListModel<Book> model = new DefaultListModel<>();

    public ManageBooksFrame() {
        setTitle("Manage Books");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        refreshListData();

        JTextField titleField = new JTextField(10);
        JTextField genreField = new JTextField(10);
        JTextField authorField = new JTextField(10);
        JTextField yearField = new JTextField(5);
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"Available", "Checked Out", "Reserved"});

        JList<Book> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && list.getSelectedValue() != null) {
                Book b = list.getSelectedValue();
                titleField.setText(b.getTitle());
                authorField.setText(b.getAuthor());
                genreField.setText(b.getGenre());
                yearField.setText(String.valueOf(b.getPublicationYear()));
            }
        });

        JButton addBtn = new JButton("Add Book");
        addBtn.addActionListener(e -> {
            if (titleField.getText().isEmpty()) return;

            long id = IDGenerator.GenerateBookId();
            int year = yearField.getText().isEmpty() ? 2024 : Integer.parseInt(yearField.getText());
            
            Book b = new Book(id, titleField.getText(), authorField.getText(), genreField.getText(), year);
            
            ArrayList<Book> temp = new ArrayList<>();
            temp.add(b);
            FileManager.WriteBooks(temp);

            refreshListData();
            clearFields(titleField, authorField, genreField, yearField);
        });

        JButton updateBtn = new JButton("Update Selected");
        updateBtn.addActionListener(e -> {
            Book selected = list.getSelectedValue();
            if (selected == null) return;

            int year = yearField.getText().isEmpty() ? 2024 : Integer.parseInt(yearField.getText());
            
            selected.updateInfo(titleField.getText(), authorField.getText(), year, genreField.getText());
            
            FileManager.UpdateBook(selected);
            
            refreshListData();
        });

        JButton deleteBtn = new JButton("Delete Selected");
        deleteBtn.addActionListener(e -> {
            Book selected = list.getSelectedValue();
            if (selected == null) return;

            FileManager.DeleteBook(selected.getId());
            
            refreshListData();
        });


        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Book Details"));
        inputPanel.add(new JLabel("Title:")); inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:")); inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:")); inputPanel.add(genreField);
        inputPanel.add(new JLabel("Year:")); inputPanel.add(yearField);
        inputPanel.add(new JLabel("Status:")); inputPanel.add(statusBox);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        Dimension btnSize = new Dimension(150, 40);
        addBtn.setMaximumSize(btnSize);
        updateBtn.setMaximumSize(btnSize);
        deleteBtn.setMaximumSize(btnSize);

        controlPanel.add(addBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(updateBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(deleteBtn);

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            model.clear();
            for (Book b : books) {
                if (String.valueOf(b.getId()).contains(query) ||
                    b.getTitle().toLowerCase().contains(query) ||
                    b.getAuthor().toLowerCase().contains(query)) {
                    model.addElement(b);
                }
            }
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Title/ID:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
        add(searchPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshListData() {
        books = FileManager.ReadBooks();
        model.clear();
        for (Book b : books) {
            model.addElement(b);
        }
    }

    private void clearFields(JTextField... fields) {
        for (JTextField f : fields) f.setText("");
    }
}