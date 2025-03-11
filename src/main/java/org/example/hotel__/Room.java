package org.example.hotel__;

public class Room {
    private int number_of_beds;
    private double price;
    private String type;

    public Room(int number_of_beds, double price, String type) {
        this.number_of_beds = number_of_beds;
        this.price = price;
        this.type = type;
    }
    @Override
    public String toString() {
        return "Room. Number of beds: "+ this.number_of_beds + " Price: ";
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public int getNumber_of_beds() {
        return this.number_of_beds;
    }

    public void setNumber_of_beds(int number_of_beds){
        this.number_of_beds = number_of_beds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
