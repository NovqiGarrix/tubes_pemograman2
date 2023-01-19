package com.novqigarrix.java.database;

import com.novqigarrix.java.database.model.UserModel;
import com.novqigarrix.java.database.repository.UserRepositoryImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register extends JFrame {
    private JTextField namalengkapTextField;
    private JTextField userTextField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JComboBox rolecomboBox;
    private JButton registerButton;
    private JPanel mainPannel;

    public Register() {
        super("Create new Account");
        this.setContentPane(mainPannel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String nama = namalengkapTextField.getText();
        String username = userTextField.getText();
        String password = String.valueOf(passwordField1.getPassword());
        String Conpassword = String.valueOf(passwordField2.getPassword());
        String role = rolecomboBox.getSelectedItem().toString();


        if (nama.isEmpty() || username.isEmpty() || password.isEmpty() || Conpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Mohon isi data diri dengan benar !!",
                    "Coba Lagi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(Conpassword)) {
            JOptionPane.showMessageDialog(this,
                    "Pastikan Password sesuai",
                    "Coba Lagi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        UserModel register = new UserModel();
        register.setNama(nama);
        register.setUsername(username);
        register.setPassword(password);
        register.setRole(role);

        UserRepositoryImpl repository = new UserRepositoryImpl();
        try {
            repository.create(register);

        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Database Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showMessageDialog(this,
                "Sukses !!",
                "Akun terdaftar",
                JOptionPane.INFORMATION_MESSAGE);


    }


    public static void main(String[] args) {
        JFrame mainFrame = new Register();
        mainFrame.setVisible(true);
    }
}
