package screens.admin;

import models.User;
import utils.IDGenerator;
import utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManageUsersFrame extends JFrame {

    ArrayList<User> users = new ArrayList<>();
    DefaultListModel<User> model = new DefaultListModel<>();

    public ManageUsersFrame() {
        setTitle("Manage Users");
        setSize(950, 600); 
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        refreshListData();

        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JTextField phoneField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JComboBox<String> roleBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Patron"});

        JButton addBtn = new JButton("Add User");
        JButton updateBtn = new JButton("Update Selected");
        JButton deleteBtn = new JButton("Delete Selected");

        JList<User> list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && list.getSelectedValue() != null) {
                User u = list.getSelectedValue();
                usernameField.setText(u.getUsername());
                passwordField.setText(u.getPassword());
                phoneField.setText(u.getPhone());
                emailField.setText(u.getEmail());
                roleBox.setSelectedItem(u.getRole());
            }
        });


        addBtn.addActionListener(e -> {
            if (usernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty");
                return;
            }
            long id = IDGenerator.GenerateUserId();
            User u = new User(id, usernameField.getText(), new String(passwordField.getPassword()),
                              phoneField.getText(), emailField.getText(), roleBox.getSelectedItem().toString());

            ArrayList<User> newUserList = new ArrayList<>();
            newUserList.add(u);
            FileManager.WriteUsers(newUserList);
            refreshListData();
            clearFields(usernameField, passwordField, phoneField, emailField);
        });

        updateBtn.addActionListener(e -> {
            User selected = list.getSelectedValue();
            if (selected == null) return;

            selected.setUsername(usernameField.getText());
            selected.setPassword(new String(passwordField.getPassword()));
            selected.setPhone(phoneField.getText());
            selected.setEmail(emailField.getText());
            selected.setRole(roleBox.getSelectedItem().toString());

            FileManager.updateuser(selected);
            refreshListData();
        });

        deleteBtn.addActionListener(e -> {
            User selected = list.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Please select a user to delete");
                return;
            }
            FileManager.DeleteUser(selected.getId());
            refreshListData();
        });

        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 10, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("User Information"));
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(new JLabel("Role:"));

        inputPanel.add(usernameField);
        inputPanel.add(passwordField);
        inputPanel.add(phoneField);
        inputPanel.add(emailField);
        inputPanel.add(roleBox);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        addBtn.setMaximumSize(new Dimension(150, 40));
        updateBtn.setMaximumSize(new Dimension(150, 40));
        deleteBtn.setMaximumSize(new Dimension(150, 40));
        
        controlPanel.add(addBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(updateBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(deleteBtn);

        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Query:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);


        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST); 
        add(searchPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshListData() {
        users = FileManager.ReadUsers();
        model.clear();
        for (User u : users) {
            model.addElement(u);
        }
    }

    private void clearFields(JTextField... fields) {
        for (JTextField f : fields) f.setText("");
    }
}