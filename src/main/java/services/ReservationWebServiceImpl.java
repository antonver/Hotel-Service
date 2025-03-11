package services;

import org.example.hotel__.*;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;

@WebService(endpointInterface = "services.ReservationWebService")
public class ReservationWebServiceImpl implements ReservationWebService{
    Hotel hotel_ = null;
    ArrayList<Room> availableRooms = new ArrayList<>();
    public static Date arrivalDate = null;
    public static Date departureDate = null;
    @Override
    public String giveListOfRooms(
                                  String hotel_name,
                                  String arrival_date,
                                  String departure_date
    ){
        arrivalDate = Data.getDateFromUser(arrival_date);
        departureDate = Data.getDateFromUser(departure_date);
        for (Hotel hotel: FindHotelWebServiceImpl.appropriate_hotels){
            if (hotel.getName().equalsIgnoreCase(hotel_name)){
                hotel_ = hotel;
                break;
            }
        }
        if(hotel_ == null){
            return  "No available hotels.";
        }
        availableRooms = FindHotelWebServiceImpl.data.giveAvailableRooms(
                hotel_,
                arrivalDate,
                departureDate);

        return FindHotelWebServiceImpl.data.displayAvailableRooms(
                FindHotelWebServiceImpl.agency_,
                availableRooms);

    }

    @Override
    public String bookRooms(String first_name,
                            String last_name,
                            Integer age,
                            String email,
                            String roomNumbers) {
        if (arrivalDate == null || departureDate == null) {
            throw new IllegalStateException("You need to use giveListOfRooms before to provide arrival and departure dates.");
        } else if (hotel_ == null) {
            throw new IllegalStateException("You need to use giveListOfRooms before to choose the hotel.");
        } else if (availableRooms.isEmpty()) {
            throw new IllegalStateException("It is no rooms to book for provided dates");
        } else if (first_name == null || first_name.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        } else if (last_name == null || last_name.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        } else if (age == null || age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        } else if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email must be valid.");
        } else if (roomNumbers == null || roomNumbers.isEmpty()) {
            throw new IllegalArgumentException("Room numbers cannot be null or empty.");
        }

        // Parse and validate room numbers
        ArrayList<Room> selectedRooms = new ArrayList<>();
        for (String num : roomNumbers.trim().split("\\s+")) { // Trim and split by whitespace
            if (num.isEmpty()) {
                continue; // Skip empty strings
            }
            try {
                int roomIndex = Integer.parseInt(num) - 1; // Convert room number to zero-based index
                if (roomIndex >= 0 && roomIndex < availableRooms.size()) {
                    selectedRooms.add(availableRooms.get(roomIndex));
                } else {
                    throw new IllegalStateException("Invalid room number: " + num);
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Invalid room number format: " + num);
            }
        }

        if (selectedRooms.isEmpty()) {
            throw new IllegalStateException("No valid room numbers were provided.");
        }

        return Data.makeReservation(arrivalDate,
                departureDate,
                hotel_,
                selectedRooms,
                first_name,
                last_name,
                age,
                email,
                roomNumbers
        );
    }






    public String getReservation(){
        String reserv = "\n";
        for (Reservation res: hotel_.getReservations()){
            reserv += res + ".\n";
        }
        return reserv;
    }
}
