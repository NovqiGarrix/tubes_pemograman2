package com.novqigarrix.java.database;

import com.novqigarrix.java.database.model.UserModel;
import com.novqigarrix.java.database.repository.UserRepositoryImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame{
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JPanel mainPanel;
    private JButton registerButton;
    private JButton loginButton;

    public Login() {
        super("Create new Account");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String username = userTextField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Mohon Isi Form Login dengan benar !!",
                    "Coba Lagi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(password)) {
            JOptionPane.showMessageDialog(this,
                    "Pastikan Password sesuai",
                    "Coba Lagi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserModel login = new UserModel();
        login.setUsername(username);
        login.setPassword(password);

        UserRepositoryImpl repository = new UserRepositoryImpl();
        try{
            repository.findOne(login.getUserId());

        }catch (SQLException e){
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Database Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showMessageDialog(this,
                "Sukses !!",
                "Selamat Datang  " + username,
                JOptionPane.INFORMATION_MESSAGE);


    }

    public static void main(String[] args) {
        JFrame mainFrame = new Login();
        mainFrame.setVisible(true);
    }
}
