package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservation_GUI {
    public static String[] getReservationDetails(JFrame frame, String label) {
        JLabel infoLabel = new JLabel(label);
        infoLabel.setBounds(50, 50, 300, 30);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(50, 100, 100, 30);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(150, 100, 200, 30);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(50, 150, 100, 30);
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(150, 150, 200, 30);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 200, 100, 30);
        JTextField ageField = new JTextField();
        ageField.setBounds(150, 200, 200, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 250, 100, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 250, 200, 30);

        JLabel roomNumbersLabel = new JLabel("Room Numbers (e.g., 1 2 3):");
        roomNumbersLabel.setBounds(50, 300, 200, 30);
        JTextField roomNumbersField = new JTextField();
        roomNumbersField.setBounds(250, 300, 200, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 350, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(infoLabel);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(roomNumbersLabel);
        panel.add(roomNumbersField);
        panel.add(submitButton);

        final String[] reservationInfo = new String[5];

        submitButton.addActionListener(e -> {
            reservationInfo[0] = firstNameField.getText();
            reservationInfo[1] = lastNameField.getText();
            reservationInfo[2] = ageField.getText();
            reservationInfo[3] = emailField.getText();
            reservationInfo[4] = roomNumbersField.getText();

            frame.dispose();
        });

        JDialog dialog = new JDialog(frame, "Make Reservation", true);
        dialog.setContentPane(panel);
        dialog.setSize(450, 450);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        return reservationInfo;
    }
}
