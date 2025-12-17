//
//package GUI;
//
//
//
//import models.User;
//import utils.IDGenerator;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.*;
//import java.util.ArrayList;
//
//public class ManageUsersFrame extends JFrame {
//
//    ArrayList<User> users = new ArrayList<>();
//    DefaultListModel<User> model = new DefaultListModel<>();
//    private final String FILE_NAME = "users.txt";
//
//    public ManageUsersFrame() {
//        setTitle("Manage Users");
//        setSize(900,500);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        loadUsers();
//
//        JTextField usernameField = new JTextField(10);
//        JPasswordField passwordField = new JPasswordField(10);
//        JTextField phoneField = new JTextField(10);
//        JTextField emailField = new JTextField(10);
//        JComboBox<String> roleBox = new JComboBox<>(new String[]{"Admin","Librarian","Patron"});
//
//        JButton addBtn = new JButton("Add");
//        JButton updateBtn = new JButton("Update");
//        JButton deleteBtn = new JButton("Delete");
//
//        JTextField searchField = new JTextField(15);
//        JButton searchBtn = new JButton("Search");
//
//        JList<User> list = new JList<>(model);
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        // ربط الحقول عند اختيار مستخدم
//        list.addListSelectionListener(e -> {
//            if(!e.getValueIsAdjusting() && list.getSelectedValue()!=null){
//                User u = list.getSelectedValue();
//                usernameField.setText(u.getUsername());
//                passwordField.setText(u.getPassword());
//                phoneField.setText(u.getPhone());
//                emailField.setText(u.getEmail());
//                roleBox.setSelectedItem(u.getRole());
//            }
//        });
//
//        // ADD
//        addBtn.addActionListener(e -> {
//            if(usernameField.getText().isEmpty()) return;
//            long id = IDGenerator.GenerateUserId();
//            User u = new User(id,
//                    usernameField.getText(),
//                    new String(passwordField.getPassword())
//            );
//            u.setPhone(phoneField.getText());
//            u.setEmail(emailField.getText());
//            u.setRole(roleBox.getSelectedItem().toString());
//
//            users.add(u);
//            model.addElement(u);
//            saveUsers();
//            clearFields(usernameField,passwordField,phoneField,emailField);
//        });
//
//        // UPDATE
//        updateBtn.addActionListener(e -> {
//            int index = list.getSelectedIndex();
//            if(index==-1) return;
//            User u = users.get(index);
//            u.setUsername(usernameField.getText());
//            u.setPassword(new String(passwordField.getPassword()));
//            u.setPhone(phoneField.getText());
//            u.setEmail(emailField.getText());
//            u.setRole(roleBox.getSelectedItem().toString());
//            list.repaint();
//            saveUsers();
//        });
//
//        // DELETE
//        deleteBtn.addActionListener(e -> {
//            int index = list.getSelectedIndex();
//            if(index==-1) return;
//            users.remove(index);
//            model.remove(index);
//            saveUsers();
//        });
//
//        // SEARCH
//        searchBtn.addActionListener(e -> {
//            String query = searchField.getText().toLowerCase();
//            model.clear();
//            for(User u : users){
//                if(String.valueOf(u.getId()).contains(query) ||
//                   u.getUsername().toLowerCase().contains(query) ||
//                   u.getEmail().toLowerCase().contains(query) ||
//                   u.getPhone().toLowerCase().contains(query) ||
//                   u.getRole().toLowerCase().contains(query)){
//                    model.addElement(u);
//                }
//            }
//        });
//
//        JPanel inputPanel = new JPanel(new GridLayout(2,6,5,5));
//        inputPanel.add(new JLabel("Username")); inputPanel.add(new JLabel("Password"));
//        inputPanel.add(new JLabel("Phone")); inputPanel.add(new JLabel("Email"));
//        inputPanel.add(new JLabel("Role")); inputPanel.add(new JLabel("")); // empty
//
//        inputPanel.add(usernameField); inputPanel.add(passwordField);
//        inputPanel.add(phoneField); inputPanel.add(emailField);
//        inputPanel.add(roleBox);
//        JPanel btnPanel = new JPanel();
//        btnPanel.add(addBtn); btnPanel.add(updateBtn); btnPanel.add(deleteBtn);
//        inputPanel.add(btnPanel);
//
//        JPanel searchPanel = new JPanel();
//        searchPanel.add(new JLabel("Search:"));
//        searchPanel.add(searchField);
//        searchPanel.add(searchBtn);
//
//        add(inputPanel,BorderLayout.NORTH);
//        add(new JScrollPane(list),BorderLayout.CENTER);
//        add(searchPanel,BorderLayout.SOUTH);
//
//        setVisible(true);
//    }
//
//    private void clearFields(JTextField username,JPasswordField password,JTextField phone,JTextField email){
//        username.setText("");
//        password.setText("");
//        phone.setText("");
//        email.setText("");
//    }
//
//    private void saveUsers(){
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
//            oos.writeObject(users);
//        }catch(IOException e){e.printStackTrace();}
//    }
//
//    private void loadUsers(){
//        File f = new File(FILE_NAME);
//        if(!f.exists()) return;
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
//            users = (ArrayList<User>) ois.readObject();
//            users.forEach(model::addElement);
//        }catch(Exception e){e.printStackTrace();}
//    }
//}
