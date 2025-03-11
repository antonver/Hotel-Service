package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    public static String[] login(JFrame frame, String credentials) {
        JLabel infoLabel = new JLabel(credentials);
        infoLabel.setBounds(50, 50, 300, 30);

        JLabel agencyLabel = new JLabel("Agency:");
        agencyLabel.setBounds(50, 100, 100, 30);
        JTextField agencyField = new JTextField();
        agencyField.setBounds(150, 100, 200, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 150, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 200, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 200, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 250, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(infoLabel);
        panel.add(agencyLabel);
        panel.add(agencyField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);

        final String[] loginInfo = new String[3];

        submitButton.addActionListener(e -> {
            loginInfo[0] = agencyField.getText();
            loginInfo[1] = emailField.getText();
            loginInfo[2] = new String(passwordField.getPassword());

            frame.dispose();
        });

        JDialog dialog = new JDialog(frame, "Login", true);
        dialog.setContentPane(panel);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        return loginInfo;
    }
}
