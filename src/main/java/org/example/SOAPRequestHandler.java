package org.example;

import okhttp3.*;

import java.nio.charset.StandardCharsets;

public class SOAPRequestHandler {

    public static String sendLoginRequest(String agency, String email, String password) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType SOAP_XML = MediaType.get("text/xml; charset=utf-8");

        String xmlPayload = createLoginSOAPPayload(agency, email, password);

        RequestBody body = RequestBody.create(xmlPayload, SOAP_XML);

        Request request = new Request.Builder()
                .url("http://localhost:8080/find_hotel")
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                return response.body().string();
            } else {
                throw new Exception("Response body is null.");
            }
        }
    }

    private static String createLoginSOAPPayload(String agency, String email, String password) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <S:Body>\n" +
                "      <ns2:loginInAgency xmlns:ns2=\"http://services/\">\n" +
                "         <agency>" + agency + "</agency>\n" +
                "         <email>" + email + "</email>\n" +
                "         <password>" + password + "</password>\n" +
                "      </ns2:loginInAgency>\n" +
                "   </S:Body>\n" +
                "</S:Envelope>";
    }

    public static String sendFindHotelRequest(String country, String city) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType SOAP_XML = MediaType.get("text/xml; charset=utf-8");

        String xmlPayload = createFindHotelSOAPPayload(country, city);

        RequestBody body = RequestBody.create(xmlPayload, SOAP_XML);

        Request request = new Request.Builder()
                .url("http://localhost:8080/find_hotel")
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                return response.body().string();
            } else {
                throw new Exception("Response body is null.");
            }
        }
    }

    private static String createFindHotelSOAPPayload(String country, String city) {
        return """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services/">
                        <soapenv:Header/>
                        <soapenv:Body>
                            <ser:giveListOfOffers>
                                <country>%s</country>
                                <city>%s</city>
                            </ser:giveListOfOffers>
                        </soapenv:Body>
                    </soapenv:Envelope>
                """.formatted(country, city);  // .formatted() replaces %s with the respective values
    }

    public static String getRoomsRequest(String hotel_name,
                                                String arrival_date,
                                                String departure_date) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType SOAP_XML = MediaType.get("text/xml; charset=utf-8");

        String xmlPayload = getRoomsSOAPPayload(hotel_name, arrival_date, departure_date);

        RequestBody body = RequestBody.create(xmlPayload, SOAP_XML);

        Request request = new Request.Builder()
                .url("http://localhost:8080/reservation")
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                return response.body().string();
            } else {
                throw new Exception("Response body is null.");
            }
        }
    }
    private static String getRoomsSOAPPayload(String hotel_name,
                                                       String arrival_date,
                                                       String departure_date) {
        return """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services/">
           <soapenv:Header/>
           <soapenv:Body>
              <ser:giveListOfRooms>
                <hotel_name>%s</hotel_name>
                <arrival_date>%s</arrival_date>
                <departure_date>%s</departure_date>
              </ser:giveListOfRooms> <!-- Correct closing tag -->
           </soapenv:Body>
        </soapenv:Envelope>
    """.formatted(hotel_name, arrival_date, departure_date);
    }

    public static String sendReservationRequest(String first_name, String last_name, int age, String email, String roomNumbers) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType SOAP_XML = MediaType.get("text/xml; charset=utf-8");

        String xmlPayload = sendReservationSOAPPayload(first_name, last_name, age, email, roomNumbers);

        RequestBody body = RequestBody.create(xmlPayload, SOAP_XML);

        Request request = new Request.Builder()
                .url("http://localhost:8080/reservation")
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                return response.body().string();
            } else {
                throw new Exception("Response body is null.");
            }
        }
    }
    private static String sendReservationSOAPPayload(String first_name, String last_name, int age, String email, String roomNumbers) {
        return """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services/">
           <soapenv:Header/>
           <soapenv:Body>
              <ser:bookRooms>
                <first_name>%s</first_name>
                <last_name>%s</last_name>
                <age>%d</age>
                <email>%s</email>
                <roomNumbers>%s</roomNumbers>
              </ser:bookRooms>
           </soapenv:Body>
        </soapenv:Envelope>
    """.formatted(first_name, last_name, age, email, roomNumbers);
    }


}
