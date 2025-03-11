package org.example;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class SOAPResponseHandler {

    public static String processResponse(String response) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(
                    new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8))
            );
            String result = document.getElementsByTagName("return").item(0).getTextContent();
            return result;

        } catch (Exception e) {
            System.err.println("Error parsing the response: ");
            e.printStackTrace();
            return "Wrong";
        }
    }
}
//Travel Express
//john@example.com
//        password123