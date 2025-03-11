package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room_GUI {
    public static String[] getRooms(JFrame frame, String label) {
        JLabel infoLabel = new JLabel(label);
        infoLabel.setBounds(50, 50, 300, 30);

        JLabel hotelNameLabel = new JLabel("Hotel Name:");
        hotelNameLabel.setBounds(50, 100, 100, 30);
        JTextField hotelNameField = new JTextField();
        hotelNameField.setBounds(150, 100, 200, 30);

        JLabel arrivalDateLabel = new JLabel("Arrival Date (dd-mm-yyyy):");
        arrivalDateLabel.setBounds(50, 150, 150, 30);
        JTextField arrivalDateField = new JTextField();
        arrivalDateField.setBounds(200, 150, 150, 30);

        JLabel departureDateLabel = new JLabel("Departure Date (dd-mm-yyyy):");
        departureDateLabel.setBounds(50, 200, 150, 30);
        JTextField departureDateField = new JTextField();
        departureDateField.setBounds(200, 200, 150, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 250, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(infoLabel);
        panel.add(hotelNameLabel);
        panel.add(hotelNameField);
        panel.add(arrivalDateLabel);
        panel.add(arrivalDateField);
        panel.add(departureDateLabel);
        panel.add(departureDateField);
        panel.add(submitButton);

        final String[] roomInfo = new String[3];

        submitButton.addActionListener(e -> {
            roomInfo[0] = hotelNameField.getText();
            roomInfo[1] = arrivalDateField.getText();
            roomInfo[2] = departureDateField.getText();

            frame.dispose();
        });

        JDialog dialog = new JDialog(frame, "Get Rooms", true);
        dialog.setContentPane(panel);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        return roomInfo;
    }
}
