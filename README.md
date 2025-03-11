# **Project Explanation**

## **Overview**
This project is a hotel booking application that uses a graphical interface to interact with a REST server. The client application (`rest-api-client`) sends REST requests to the server (`rest-api`) to perform various operations, such as:

- **Login**
- **Hotel search**
- **Room reservation**
- **Booking confirmation**

## **API Design**

### **a. Endpoints**
Endpoints are the API entry points where requests are sent. Each endpoint is associated with a specific feature.

### **b. Data Transfer Objects (DTOs)**
DTOs are used to transfer data between the client and the server. They encapsulate the necessary data for each request and response.

### **c. Services**
Services are classes that contain business logic. They interact with DTOs and endpoints to process requests and generate responses.

### **d. Security & Authentication**

- **Authentication**: The agency must log in before accessing other features.
- **Authorization**: The hotel search and room booking endpoints require successful authentication.

### **e. Error Handling**

- **HTTP Status Codes**: Used to indicate the success or failure of requests (200 OK, 401 Unauthorized, 400 Bad Request, etc.).
- **Error Messages**: Returned in the response body to provide additional information about the failure.

## **Step-by-Step Client Usage**

### **1. Launching the Application**
Run the `Main.java` file to start the application. A main window will appear with a button **"I want to book the hotel"**.

### **2. Login**
- Click the **"I want to book the hotel"** button.
- A login window appears.
- Enter your credentials (agency, email, password) and click **"Submit"**.
    - **Success**: You proceed to the next step.
    - **Error**: An error message appears, and you must retry.
    - If the credentials are incorrect, the label changes, and you must re-enter the correct information.

### **3. Hotel Search**
- After logging in, a hotel search window appears.
- Enter the **country** and **city**, then click **"Submit"**.
- The available hotels will be displayed in a new window.
    - **Success**: You proceed to the next step.
    - **Error**: An error message appears, and you must retry.
    - If the country or city is incorrect, the label changes, and you must re-enter the correct information.

### **4. Displaying Available Rooms**
- In the hotel details window, click the **"Get Rooms"** button.
- A new window appears with the list of available rooms for the selected hotel.
    - **Success**: You proceed to the next step.
    - **Error**: An error message appears, and you must retry.
    - The **departure date** cannot be earlier than the **arrival date**.

### **5. Room Reservation**
- In the available rooms window, click the **"Make Reservation"** button.
- A reservation window opens where you enter details:
    - **First Name, Last Name, Age, Email, Room Numbers**
- Click **"Submit"** after filling in the information.
    - **Success**: You proceed to the next step.
    - **Error**: An error message appears, and you must retry.
    - **All fields must be filled in.**

### **6. Booking Confirmation**
- A confirmation window appears, indicating that the reservation was successfully completed.

## **Technical Explanation**

### **REST API**
- The server processes REST requests sent by the client.
- It handles operations such as **login, hotel search, and room booking**.
- It returns appropriate responses to the client.

### **REST API Client**
- The client uses a graphical interface for user interaction.
- It sends REST requests to the server.
- Server responses are displayed in user-friendly graphical windows.

## **Conclusion**
The API design focuses on providing **clear and well-defined** functionalities for hotel reservation management. The endpoints are designed to be **simple and intuitive**, while the DTOs encapsulate the necessary data for each request and response. Security and error handling are also considered to ensure a **smooth and secure** user experience.
