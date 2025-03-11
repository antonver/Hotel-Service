package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    public JFrame frame;

    public Frame() {
        this.frame = new JFrame("Hotel Booking System");
    }

    public void frame_initialiser() {
        this.frame.setSize(800, 800);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(null);

        JButton initialButton = new JButton("I want to book the hotel");
        initialButton.setBounds(250, 300, 300, 50);

        initialButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            Client.login(frame);
        });

        this.frame.add(initialButton);
        this.frame.setVisible(true);
    }
}
