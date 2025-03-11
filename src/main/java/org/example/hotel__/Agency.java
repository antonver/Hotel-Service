package org.example.hotel__;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agency {
    private String name;
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private double reduction;
    private HashMap<Client, List<String>> clients = new HashMap<>();

    public Agency() {

    }

    // Constructor
    public Agency(String name, ArrayList<Hotel> hotels, double reduction) {
        this.name = name;
        this.hotels = hotels;
        this.reduction = reduction;
    }

    // Add client to the agency with email and password in List
    public void addClient(Client client, String email, String password) {
        List<String> clientDetails = new ArrayList<>();
        clientDetails.add(email); // Add email
        clientDetails.add(password); // Add password
        clients.put(client, clientDetails);
    }

    // Getter for clients (just for demonstration purposes)
    public HashMap<Client, List<String>> getClients() {
        return clients;
    }


    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


