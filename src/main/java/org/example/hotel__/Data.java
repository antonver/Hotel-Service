package org.example.hotel__;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Data {
    List<Agency> agencies;

    public Data() {
        Room room1 = new Room(1, 100.0, "Lux");
        Room room2 = new Room(2, 60.0, "Simple");
        Room room3 = new Room(1, 120.0, "Lux");
        Room room4 = new Room(2, 80.0, "Simple");
        Room room5 = new Room(1, 150.0, "Lux");
        Room room6 = new Room(2, 70.0, "Simple");
        Room room7 = new Room(1, 110.0, "Lux");
        Room room8 = new Room(2, 65.0, "Simple");
        Room room9 = new Room(1, 130.0, "Lux");
        Room room10 = new Room(2, 75.0, "Simple");


        // Creating arrays of 10 rooms for each hotel
        Room[] roomsForHotel1 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};


        Room[] roomsForHotel2 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel3 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel4 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel5 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel6 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel7 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel8 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel9 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};
        Room[] roomsForHotel10 = {room1, room2, room3, room4, room5, room6, room7, room8, room9, room10};

        // Create 10 Hotel objects, each with 10 rooms
        Hotel hotel1 = new Hotel("Grand Palace", roomsForHotel1, "Paris", "France", 5, "123-456-7890", "grandpalace@example.com", "123 Main St");
        Hotel hotel2 = new Hotel("Ocean Breeze", roomsForHotel2, "Miami", "USA", 4, "987-654-3210", "oceanbreeze@example.com", "456 Beach Rd");
        Hotel hotel3 = new Hotel("Mountain Retreat", roomsForHotel3, "Denver", "USA", 3, "555-123-4567", "mountainretreat@example.com", "789 Hilltop Ln");
        Hotel hotel4 = new Hotel("City Lights", roomsForHotel4, "New York", "USA", 4, "555-987-6543", "citylights@example.com", "101 Urban Blvd");
        Hotel hotel5 = new Hotel("Desert Oasis", roomsForHotel5, "Dubai", "UAE", 5, "444-222-1111", "desertoasis@example.com", "202 Sand Dr");
        Hotel hotel6 = new Hotel("Forest Haven", roomsForHotel6, "Vancouver", "Canada", 3, "333-111-2222", "foresthaven@example.com", "303 Greenway Ave");
        Hotel hotel7 = new Hotel("Sunny Shores", roomsForHotel7, "Barcelona", "Spain", 4, "222-333-4444", "sunnyshores@example.com", "404 Coastal Rd");
        Hotel hotel8 = new Hotel("Northern Lights", roomsForHotel8, "Reykjavik", "Iceland", 5, "111-444-3333", "northernlights@example.com", "505 Aurora Ln");
        Hotel hotel9 = new Hotel("Royal Castle", roomsForHotel9, "London", "UK", 5, "000-555-6666", "royalcastle@example.com", "606 Monarch St");
        Hotel hotel10 = new Hotel("Golden Sands", roomsForHotel10, "Maldives", "Maldives", 5, "999-888-7777", "goldensands@example.com", "707 Sunset Blvd");

        Agency agency1 = new Agency("Travel Express", new ArrayList<>(List.of(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10)), 10.0);
        Agency agency2 = new Agency("Holiday Getaways", new ArrayList<>(List.of(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10)), 15.0);
        Agency agency3 = new Agency("Global Adventures", new ArrayList<>(List.of(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10)), 12.0);


        Client client1 = new Client("John", "Doe", 30, "john.doe@example.com");
        Client client2 = new Client("Jane", "Smith", 28, "jane.smith@example.com");
        Client client3 = new Client("Alice", "Johnson", 35, "alice.johnson@example.com");
        List<Agency> agenecies = List.of(agency1, agency2, agency3);
        // Adding clients to agencies with email and password
        agency1.addClient(client1, "john@example.com", "password123");
        agency1.addClient(client2, "jane@example.com", "securepass");
        agency1.addClient(client3, "alice@example.com", "mypassword");
        agency2.addClient(client1, "john@example.com", "password123");
        agency2.addClient(client2, "jane@example.com", "securepass");
        agency2.addClient(client3, "alice@example.com", "mypassword");
        agency3.addClient(client1, "john@example.com", "password123");
        agency3.addClient(client2, "jane@example.com", "securepass");
        agency3.addClient(client3, "alice@example.com", "mypassword");
        this.agencies = List.of(agency1, agency2, agency3);
    }

    public ArrayList<Hotel> findHotelByLocation(ArrayList<Hotel> hotels, String country, String city) {
        ArrayList<Hotel> found_hotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCountry().equalsIgnoreCase(country) && hotel.getCity().equalsIgnoreCase(city)) {
                found_hotels.add(hotel);
            }
        }
        if (!found_hotels.isEmpty()) {
            return found_hotels;
        }
        return null;
    }

    public Agency loginInAgency(String agency, String email, String password) {
        // Adding clients to agencies with email and password
        for (Agency a : this.agencies) {
            if (a.getName().equalsIgnoreCase(agency)) {
                for (List<String> c : a.getClients().values()) {
                    if (c.get(0).equals(email) && c.get(1).equals(password)) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    public static Date getDateFromUser(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalStateException("Invalid date format: " + e.getMessage());
        }
    }

    private static boolean validateDates(Date arrivalDate, Date departureDate, Date today) {
        if (arrivalDate.after(departureDate)) {
            throw new IllegalStateException("Arrival date must be before departure date.");
        }
        if (arrivalDate.before(today)) {
            throw new IllegalStateException("Arrival date cannot be before today.");
        }
        return true;
    }

    public String displayAvailableRooms(Agency agency, ArrayList<Room> availableRooms) {
        String rooms = "\nAvailable rooms:\n";
        int index = 1;
        if (availableRooms.isEmpty()) {
            return "\nNo rooms available";
        }
        for (Room room : availableRooms) {
            rooms += index++ + ". " + room + room.getPrice() * (100 - agency.getReduction()) / 100 + "\n";
        }
        return rooms;
    }

    public ArrayList<Room> giveAvailableRooms(Hotel hotel, Date arrivalDate, Date departureDate) {
        Date today = new Date();

        // Input arrival and departure dates

        validateDates(arrivalDate, departureDate, today);

        return hotel.findAvailableRooms(arrivalDate, departureDate);


    }

    public static String makeReservation(Date arrivalDate,
                                         Date departureDate,
                                         Hotel hotel,
                                         ArrayList<Room> availableRooms,
                                         String firstName,
                                         String lastName,
                                         Integer age,
                                         String email,
                                         String roomNumbers) {
        // Validate input parameters
        if (arrivalDate == null || departureDate == null || hotel == null || availableRooms == null ||
                email == null || roomNumbers == null || age == null || firstName == null || lastName == null) {
            throw new IllegalStateException("Wrong");
        }

        // Parse and validate room numbers
        ArrayList<Room> selectedRooms = new ArrayList<>();
        for (String num : roomNumbers.trim().split("\\s+")) { // Trim and split by whitespace
            try {
                int roomIndex = Integer.parseInt(num) - 1; // Convert room number to zero-based index
                if (roomIndex >= 0 && roomIndex < availableRooms.size()) {
                    selectedRooms.add(availableRooms.get(roomIndex));
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Wrong");
            }
        }

        // Find existing client or create a new one
        Client client = null;
        for (Client existingClient : hotel.getClients()) {
            if (existingClient.getEmail().equalsIgnoreCase(email)) {
                client = existingClient;
                break;
            }
        }
        if (client == null) {
            client = new Client(firstName, lastName, age, email);
        }

        // Check if at least one room was selected
        if (!selectedRooms.isEmpty()) {
            Reservation reservation = new Reservation(client, arrivalDate, departureDate, selectedRooms);
            hotel.addReservation(reservation);
            return "Reservation confirmed.";
        } else {
            return "No valid room numbers were provided. Client was created, but no reservation was made.";
        }
    }
}
