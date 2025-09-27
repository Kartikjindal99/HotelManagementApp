# HotelManagement
---------------------

A Spring Boot backend project for managing hotels. This REST API supports **CRUD operations**, updating hotel addresses, and bulk deletion. Fully compatible with **Java 25** and ready for frontend integration or Postman testing.

---

## Features

- Create a new hotel  
- Retrieve all hotels  
- Retrieve hotel by ID  
- Update hotel details  
- Update only hotel address  
- Delete a hotel by ID  
- Delete all hotels  

---

## Technologies Used

- Java 25  
- Spring Boot 3.x  
- Spring Data JPA  
- Hibernate  
- MySQL (or any relational DB)  
- Maven  

---

## Project Structure

HotelManagement/
├── src/main/java/com/example/HotelManagement
│ ├── Controller/ # REST API endpoints
│ ├── DTO/ # Data Transfer Objects
│ ├── Entity/ # JPA Entity classes
│ ├── Repository/ # JPA Repositories
│ └── Service/ # Business logic
├── src/main/resources/
│ └── application.properties
├── pom.xml # Maven dependencies (Java 25)
└── README.md


---

## API Endpoints

| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/hotel/create` | Create a new hotel |
| GET    | `/hotel/getallhotels` | Get all hotels |
| GET    | `/hotel/gethotelbyid/{id}` | Get hotel by ID |
| PUT    | `/hotel/updatehotel/{id}` | Update hotel details |
| PUT    | `/hotel/updatehoteladdress/{id}` | Update hotel address only |
| DELETE | `/hotel/deletehotel/{id}` | Delete hotel by ID |
| DELETE | `/hotel/deleteallhotels` | Delete all hotels |

---

## Sample JSON Requests

### 1. Create a new hotel (POST `/hotel/create`)
```JSON
{
  "name": "Hotel Taj",
  "address": "Mumbai, India",
  "city": "Mumbai",
  "postalCode": 400001,
  "rating": 5,
  "available": true
}
```
2. Update hotel details (PUT /hotel/updatehotel/1)
```   
{
  "name": "Hotel Taj Deluxe",
  "address": "Mumbai, India",
  "city": "Mumbai",
  "postalCode": 400001,
  "rating": 5,
  "available": true
}
```
3. Update hotel address only (PUT /hotel/updatehoteladdress/1)
```
{
  "address": "Nariman Point, Mumbai",
  "city": "Mumbai",
  "postalCode": 400021
}
```

Sample Responses (Postman)

1. Get all hotels (GET /hotel/getallhotels)
```
[
    {
        "id": 1,
        "name": "Hotel Taj",
        "address": "Mumbai, India",
        "city": "Mumbai",
        "postalCode": 400001,
        "rating": 5.0,
        "available": true
    },
    {
        "id": 2,
        "name": "The Grand Hotel",
        "address": "123 Main Street",
        "city": "Meerut",
        "postalCode": 250001,
        "rating": 4.5,
        "available": true
    }
]
```

2. Get hotel by ID (GET /hotel/gethotelbyid/1)
```
{
    "id": 1,
    "name": "Hotel Taj",
    "address": "Mumbai, India",
    "city": "Mumbai",
    "postalCode": 400001,
    "rating": 5.0,
    "available": true
}
```

3. Delete hotel by ID (DELETE /hotel/deletehotel/1)
```
"Hotel with ID 1 deleted successfully."
```
5. Delete all hotels (DELETE /hotel/deleteallhotels)
```
"All hotels deleted successfully."
```


How to Run
-----------------

Clone the repository:
```
git clone https://github.com/<your-username>/HotelManagement.git
```
Navigate to project directory:
```
cd HotelManagement
```
Configure database connection in src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
Ensure Java 25 is active:
```
java -version
# Should show: java version "25" ...
```
Build and run with Maven:
```
mvn spring-boot:run
```
Test APIs using Postman on:
```
http://localhost:8080
```
