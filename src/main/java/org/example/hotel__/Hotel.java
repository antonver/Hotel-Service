package org.example.hotel__;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;
    private String address;
    private String city;
    private String country;
    private ArrayList<Reservation> reservations;
    private int number_of_stars;
    private String telephone_number;
    private String email;
    private ArrayList<Client> clients = new ArrayList<>();
    public Hotel(String name, Room[] rooms, String city, String country, int number_of_stars, String telephone_number,
                 String email, String address) {
        this.name = name;
        this.rooms = new ArrayList<>(Arrays.asList(rooms));
        this.city = city;
        this.country = country;
        this.reservations = new ArrayList<Reservation>();
        this.number_of_stars = number_of_stars;
        this.telephone_number = telephone_number;
        this.email = email;
        this.address = address;
    }

    public ArrayList<Room> findAvailableRooms(Date arrival_date, Date departure_date) {
        ArrayList<Room> rooms_occupied = new ArrayList<>();
        ArrayList<Room> all_rooms = new ArrayList<>(this.rooms);
        for (Reservation reservation : this.reservations) {
            if (((reservation.getDeparture_date().after(arrival_date) && (reservation.getDeparture_date().before(departure_date)) || reservation.getDeparture_date().equals(departure_date))) ||
                    (reservation.getArrival_date().equals(arrival_date)) || (reservation.getArrival_date().after(arrival_date) && reservation.getArrival_date().before(departure_date))) {
                rooms_occupied.addAll(reservation.getRooms());
            }
        }
        all_rooms.removeAll(rooms_occupied);
        return all_rooms;
    }

    @Override
    public String toString() {
        return this.name + ". Number of stars: " + this.number_of_stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation){
        this.getReservations().add(reservation);
        clients.add(reservation.getClient());
    }

    public int getNumber_of_stars() {
        return number_of_stars;
    }

    public void setNumber_of_stars(int number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}

