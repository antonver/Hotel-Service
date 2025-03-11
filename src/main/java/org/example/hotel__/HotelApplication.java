package org.example.hotel__;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
        Room[] rooms = initializeRooms();
        ArrayList<Hotel> hotels = new ArrayList<>();

        // Initialize hotel with rooms
        Hotel hotel1 = new Hotel("Hotel1", rooms, "Paris", "France", 5, "+33 891-060-52", "hotel1@gmail.com", "rue de Paris1");
        hotels.add(hotel1);

        // Start booking process
        startBookingProcess(hotels);
    }


    // Initialize rooms with predefined types
    private static Room[] initializeRooms() {
        Room[] rooms = new Room[9];
        for (int i = 1; i < 10; i++) {
            Room room = new Room(i, 50 * i, "Simple");
            rooms[i - 1] = room;
        }
        return rooms;
    }

    private static void startBookingProcess(ArrayList<Hotel> hotels) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to book an apartment in the hotel? (yes/no)");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                handleHotelBooking(hotels, sc);
            } else {
                break;
            }
        }
    }


    private static void handleHotelBooking(ArrayList<Hotel> hotels, Scanner sc) {
        System.out.println("Enter the country where you want to go:");
        String country = sc.nextLine();
        System.out.println("Enter the city where you want to go:");
        String city = sc.nextLine();

        ArrayList<Hotel> selectedHotels = findHotelByLocation(hotels, country, city);
        if (selectedHotels != null) {
            System.out.println("Choose the hotel by writing its name");
            for(Hotel hotel: selectedHotels){
                System.out.println(hotel.getName() + " " + hotel.getNumber_of_stars());
            }
            String selectedHotel_name = sc.nextLine();
            for(Hotel hotel: selectedHotels){
                if(selectedHotel_name.equalsIgnoreCase(hotel.getName())){
                    handleReservation(hotel, sc);
                }
            }
        } else {
            System.out.println("No hotels found in the specified location.");
        }
    }


    private static ArrayList<Hotel> findHotelByLocation(ArrayList<Hotel> hotels, String country, String city) {
        ArrayList<Hotel> found_hotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCountry().equalsIgnoreCase(country) && hotel.getCity().equalsIgnoreCase(city)) {
                found_hotels.add(hotel);
            }
        }
        if (!found_hotels.isEmpty()){
            return found_hotels;
        }
        return null;
    }

    // Handle reservation for a hotel
    private static void handleReservation(Hotel hotel, Scanner sc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();

        // Input arrival and departure dates
        Date arrivalDate = getDateFromUser(sc, "arrival");
        Date departureDate = getDateFromUser(sc, "departure");

        if (arrivalDate == null || departureDate == null || !validateDates(arrivalDate, departureDate, today)) {
            return;
        }

        ArrayList<Room> availableRooms = hotel.findAvailableRooms(arrivalDate, departureDate);
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for the selected dates.");
            return;
        }

        displayAvailableRooms(availableRooms);

        // Handle room selection
        System.out.println("Would you like to reserve rooms? (yes/no)");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            makeReservation(sc, availableRooms, hotel, arrivalDate, departureDate);
        }
    }

    // Get date from user
    private static Date getDateFromUser(Scanner sc, String type) {
        System.out.println("Enter the " + type + " date (dd-MM-yyyy):");
        String dateStr = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + e.getMessage());
            return null;
        }
    }

    // Validate the arrival and departure dates
    private static boolean validateDates(Date arrivalDate, Date departureDate, Date today) {
        if (arrivalDate.after(departureDate)) {
            System.out.println("Arrival date must be before departure date.");
            return false;
        }
        if (arrivalDate.before(today)) {
            System.out.println("Arrival date cannot be before today.");
            return false;
        }
        return true;
    }

    // Display available rooms
    private static void displayAvailableRooms(ArrayList<Room> availableRooms) {
        System.out.println("Available rooms:");
        int index = 1;
        for (Room room : availableRooms) {
            System.out.println(index++ + ". " + room);
        }
    }

    // Make a reservation
    private static void makeReservation(Scanner sc, ArrayList<Room> availableRooms, Hotel hotel, Date arrivalDate, Date departureDate) {
        System.out.println("Enter your details for the reservation:");
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        // Input room selection
        System.out.println("Enter room numbers to reserve (e.g., '1 2 3'):");
        String roomNumbers = sc.nextLine();
        ArrayList<Room> selectedRooms = new ArrayList<>();
        for (String num : roomNumbers.trim().split(" ")) {
            int roomIndex = Integer.parseInt(num) - 1;
            if (roomIndex >= 0 && roomIndex < availableRooms.size()) {
                selectedRooms.add(availableRooms.get(roomIndex));
            }
        }
        // Create reservation
        Client client = null;
        for (Client client_: hotel.getClients()){
            if (client_.getEmail().equals(email)){
                    client = client_;
                    break;
            }
        }
        if (client == null){
            client = new Client(firstName, lastName, age, email);
        }
        Reservation reservation = new Reservation(client, arrivalDate, departureDate, selectedRooms);
        hotel.addReservation(reservation);
        System.out.println("Reservation confirmed.");
    }
}
