package services;

import org.example.hotel__.Hotel;
import org.example.hotel__.Room;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;

@WebService
public interface ReservationWebService {

    @WebMethod(operationName = "giveListOfRooms")
    public String giveListOfRooms(@WebParam(name = "hotel_name")String hotel_name,
                                  @WebParam(name = "arrival_date")String arrival_date,
                                  @WebParam(name = "departure_date")String departure_date);

    @WebMethod(operationName = "bookRooms")
    public String bookRooms(@WebParam(name = "first_name")String first_name,
                            @WebParam(name = "last_name")String last_name,
                            @WebParam(name = "age")Integer age,
                            @WebParam(name = "email")String email,
                            @WebParam(name = "roomNumbers")String roomNumbers
                            );
    @WebMethod(operationName = "getReservation")
    public String getReservation();

}
