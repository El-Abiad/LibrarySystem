package screens.admin;
import models.Book;
import utils.IDGenerator;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ManageBooksFrame extends JFrame {

    ArrayList<Book> books = new ArrayList<>();
    DefaultListModel<Book> model = new DefaultListModel<>();
    private final String FILE_NAME = "books.txt";

    public ManageBooksFrame() {
        setTitle("Manage Books");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        loadBooks();

        JTextField titleField = new JTextField(10);
        JTextField genreField = new JTextField(10);
        JTextField authorFiled = new JTextField(10);
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"Available","Checked Out","Reserved"});
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");

        JList<Book> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting() && list.getSelectedValue() != null){
                Book b = list.getSelectedValue();
                titleField.setText(b.getTitle());
                authorFiled.setText(b.getAuthor()); 
                genreField.setText(b.getGenre());  
                statusBox.setSelectedItem(b.getStatus());
            }
        });



        addBtn.addActionListener(e -> {
            if(titleField.getText().isEmpty()) return;
            long id = IDGenerator.GenerateBookId();
            Book b = new Book(id, titleField.getText(), authorFiled.getText(), genreField.getText(), 2025);
            b.updateStatus(statusBox.getSelectedItem().toString());
            books.add(b);
            model.addElement(b);
            saveBooks();
            titleField.setText("");
            authorFiled.setText(""); 
            genreField.setText("");   
        });



        updateBtn.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if(index == -1) return;
            Book b = books.get(index);
            b.updateInfo(titleField.getText(), authorFiled.getText(), 2025, genreField.getText());
            b.updateStatus(statusBox.getSelectedItem().toString());
            list.repaint();
            saveBooks();
        });



        deleteBtn.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if(index==-1) return;
            books.remove(index);
            model.remove(index);
            saveBooks();
        });

        searchBtn.addActionListener(e -> {
            String query = searchField.getText().toLowerCase();
            model.clear();
            for(Book b : books){
                if(String.valueOf(b.getId()).contains(query) ||
                   b.getTitle().toLowerCase().contains(query) ||
                   b.getStatus().toLowerCase().contains(query)){
                    model.addElement(b);
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorFiled); 
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusBox);
        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn); btnPanel.add(updateBtn); btnPanel.add(deleteBtn);
        inputPanel.add(btnPanel);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        add(inputPanel,BorderLayout.NORTH);
        add(new JScrollPane(list),BorderLayout.CENTER);
        add(searchPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    private void saveBooks(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(books);
        }catch(IOException e){e.printStackTrace();}
    }

    private void loadBooks(){
        File f = new File(FILE_NAME);
        if(!f.exists()) return;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            books = (ArrayList<Book>) ois.readObject();
            books.forEach(model::addElement);
        }catch(Exception e){e.printStackTrace();}
    }
}
