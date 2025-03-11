package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FindHotelWebService {

    @WebMethod(operationName = "loginInAgency")
    public String loginInAgency(@WebParam(name = "agency")String agency,
                                @WebParam(name = "email")String email,
                                @WebParam(name = "password")String password);

    @WebMethod(operationName = "giveListOfOffers")
    public String giveListOfOffers(@WebParam(name = "country")String country,
                                   @WebParam(name = "city")String city);

}
