package services;

import org.example.hotel__.*;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;

@WebService(endpointInterface = "services.FindHotelWebService")

public class FindHotelWebServiceImpl implements FindHotelWebService {
    public static Agency agency_ = null;
    public static Data data = new Data();
    public static ArrayList<Hotel> appropriate_hotels= new ArrayList<Hotel>();

    @Override
    public String loginInAgency(String agency, String email, String password){
        agency_ = data.loginInAgency(agency, email, password);
        if (agency_ != null){
            return "Access is successful";
        }
        agency = null;
        return "Access is  not successful";
    }


    @Override
    public String giveListOfOffers(String country,
                                   String city) {
        appropriate_hotels.clear();
        if (agency_ == null){
            throw new IllegalStateException("You need to be logged in to view offers");
        }
        ArrayList<Hotel> given_hotels = data.findHotelByLocation(agency_.getHotels(), country, city);
        String given_hotels_ = "";
        int counter  = 0;
        for (Hotel hotel : given_hotels){
            counter++;
            given_hotels_ += counter+". " + hotel.toString() + "\n";
            appropriate_hotels.add(hotel);
        }
        return given_hotels_;
    }
}
