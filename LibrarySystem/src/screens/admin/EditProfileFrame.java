
package GUI;


import javax.swing.*;

public class EditProfileFrame extends JFrame {

    public EditProfileFrame() {
        setTitle("Edit Profile");
        setSize(350,200);
        setLocationRelativeTo(null);

        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JButton saveBtn = new JButton("Save");

        saveBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(this,"Profile Updated Successfully")
        );

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(saveBtn);

        add(panel);
        setVisible(true);
    }
}