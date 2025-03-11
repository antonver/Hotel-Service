package org.example.hotel__;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private Client client;
    private Date arrival_date;
    private Date departure_date;
    private ArrayList<Room> rooms;
    private int id;
    private static int id_ = 0;

    public Reservation(Client client, Date arrival_date, Date departure_date, ArrayList<Room> rooms) {
        this.client = client;

        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.rooms = rooms;
        this.id = id_ + 1;
        id_++;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.client.getLast_name() + " " + this.client.getFirst_name();
    }
}
