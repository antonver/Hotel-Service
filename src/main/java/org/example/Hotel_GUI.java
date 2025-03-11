package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hotel_GUI {
    public static String[] findHotel(JFrame frame, String label) {
        JLabel infoLabel = new JLabel(label);
        infoLabel.setBounds(50, 50, 300, 30);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setBounds(50, 100, 100, 30);
        JTextField countryField = new JTextField();
        countryField.setBounds(150, 100, 200, 30);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(50, 150, 100, 30);
        JTextField cityField = new JTextField();
        cityField.setBounds(150, 150, 200, 30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 100, 30);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(infoLabel);
        panel.add(countryLabel);
        panel.add(countryField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(submitButton);

        final String[] hotelInfo = new String[2];

        submitButton.addActionListener(e -> {
            hotelInfo[0] = countryField.getText();
            hotelInfo[1] = cityField.getText();

            frame.dispose();
        });

        JDialog dialog = new JDialog(frame, "Find Hotel", true);
        dialog.setContentPane(panel);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);

        return hotelInfo;
    }
}
