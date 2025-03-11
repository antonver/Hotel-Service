package services;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/find_hotel", new FindHotelWebServiceImpl());
        Endpoint.publish("http://localhost:8080/reservation", new ReservationWebServiceImpl());
        System.err.println("Server is ready");
    }
}
