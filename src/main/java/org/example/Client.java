package org.example;

import javax.swing.*;

public class Client {

    public static void login(JFrame frame) {
        boolean loginSuccessful = false;
        String credentials = "Please enter your credentials";
        while (!loginSuccessful) {
            String[] loginData = Login_GUI.login(frame, credentials);
            loginSuccessful = handleLogin(loginData);
            if (loginSuccessful) {
                handleFindHotel(frame);
            } else {
                credentials = "Credentials are not correct please try again";
            }
        }
    }

    private static boolean handleLogin(String[] loginData) {
        try {
            String response = SOAPRequestHandler.sendLoginRequest(loginData[0], loginData[1], loginData[2]);
            String processedResponse = SOAPResponseHandler.processResponse(response);
            return "Access is successful".equalsIgnoreCase(processedResponse);
        } catch (Exception e) {
            System.err.println("Error during login request.");
            e.printStackTrace();
            return false;
        }
    }

    private static void handleFindHotel(JFrame frame) {
        String label = "Please enter the hotel details";
        String[] hotelData = Hotel_GUI.findHotel(frame, label);
        try {
            String response = SOAPRequestHandler.sendFindHotelRequest(hotelData[0], hotelData[1]);
            String processedResponse = SOAPResponseHandler.processResponse(response);
            while (processedResponse.equalsIgnoreCase("Wrong")){
                label = "Invalid input data, please try again";
                hotelData = Hotel_GUI.findHotel(frame, label);
                response = SOAPRequestHandler.sendFindHotelRequest(hotelData[0], hotelData[1]);
                processedResponse = SOAPResponseHandler.processResponse(response);
            }
            displayHotelData(frame, processedResponse);
        } catch (Exception e) {
            System.err.println("Error during hotel query.");
            e.printStackTrace();
        }
    }

    private static void displayHotelData(JFrame frame, String hotelData) {
        JFrame hotelFrame = new JFrame("Hotel Details");
        hotelFrame.setSize(600, 400);
        hotelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hotelFrame.setLayout(null);

        JTextArea textArea = new JTextArea(hotelData);
        textArea.setBounds(50, 50, 500, 250);
        textArea.setEditable(false);

        hotelFrame.add(textArea);

        JButton getRoomsButton = new JButton("Get Rooms");
        getRoomsButton.setBounds(250, 320, 100, 30);
        getRoomsButton.addActionListener(e -> {
            hotelFrame.dispose();
            getRooms(frame);
        });

        hotelFrame.add(getRoomsButton);
        hotelFrame.setVisible(true);
    }

    private static void getRooms(JFrame frame) {
        String label = "Please enter your reservation details";
        String[] roomData = Room_GUI.getRooms(frame, label);
        try {
            String response = SOAPRequestHandler.getRoomsRequest(roomData[0], roomData[1], roomData[2]);
            String processedResponse = SOAPResponseHandler.processResponse(response);
            while (processedResponse.equalsIgnoreCase("Wrong")){
                label = "Invalid input data, please try again";
                roomData = Room_GUI.getRooms(frame, label);
                response = SOAPRequestHandler.getRoomsRequest(roomData[0], roomData[1], roomData[2]);
                processedResponse = SOAPResponseHandler.processResponse(response);
            }
            displayRoomData(frame, processedResponse);
        } catch (Exception e) {
            System.err.println("Error during querying rooms.");
            e.printStackTrace();
        }
    }

    private static void displayRoomData(JFrame frame, String roomData) {
        JFrame roomFrame = new JFrame("Available Rooms");
        roomFrame.setSize(600, 400);
        roomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomFrame.setLayout(null);

        JTextArea textArea = new JTextArea(roomData);
        textArea.setBounds(50, 50, 500, 250);
        textArea.setEditable(false);

        roomFrame.add(textArea);

        JButton reserveButton = new JButton("Make Reservation");
        reserveButton.setBounds(250, 320, 150, 30);
        reserveButton.addActionListener(e -> {
            roomFrame.dispose();
            handleReservation(frame);
        });

        roomFrame.add(reserveButton);
        roomFrame.setVisible(true);
    }

    private static void handleReservation(JFrame frame) {
        String label = "Please enter your reservation details";
        String[] reservationData = Reservation_GUI.getReservationDetails(frame, label);
        try {
            String response = SOAPRequestHandler.sendReservationRequest(
                    reservationData[0],
                    reservationData[1],
                    Integer.parseInt(reservationData[2]),
                    reservationData[3],
                    reservationData[4]
            );
            String processedResponse = SOAPResponseHandler.processResponse(response);
            while (processedResponse.equalsIgnoreCase("Wrong")){
                label = "Invalid input data, please try again";
                reservationData = Reservation_GUI.getReservationDetails(frame, label);
                response = SOAPRequestHandler.sendReservationRequest(
                        reservationData[0],
                        reservationData[1],
                        Integer.parseInt(reservationData[2]),
                        reservationData[3],
                        reservationData[4]
                );
                processedResponse = SOAPResponseHandler.processResponse(response);
            }
            displayReservationSuccess(frame);
        } catch (Exception e) {
            System.err.println("Error during the reservation.");
            e.printStackTrace();
        }
    }

    private static void displayReservationSuccess(JFrame frame) {
        JFrame successFrame = new JFrame("Reservation Successful");
        successFrame.setSize(400, 200);
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        successFrame.setLayout(null);

        JLabel successLabel = new JLabel("Reservation successful! Thank you for booking with us.");
        successLabel.setBounds(50, 50, 300, 30);

        successFrame.add(successLabel);
        successFrame.setVisible(true);
    }
}
