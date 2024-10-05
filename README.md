# RestApiEmployeeAgreement

## Overview
This is a RESTful API for managing employment agreements. It provides endpoints to create, read, update, delete, and search for employment agreements. The service includes validation, error handling, and proper response codes.
The project is built using Spring Boot and supports CRUD operations for employment agreements with Swagger API documentation.

Requirements
Java 17+
Maven
H2 database
Postman (for API testing)
Any IDE that supports Spring Boot (e.g., VS code, IntelliJ, Eclipse)

## Architecture
This project uses MVC architecture which consists of Presentation, Service and Persistence layers to perform the operations

 ![mvc architecture](https://github.com/user-attachments/assets/20fba177-a44f-41f4-b028-d0aa12e863e3)


## Installation
Clone the repository:
git clone https://github.com/sidddot/RestApiEmployeeAgreement

cd RestApiEmployeeAgreement

### Configure database:
Set up the H2 database

Configure the database connection in src/main/resources/application.properties:

spring.h2.console.enabled =true

## Build the project:

mvn clean install

Run the application

mvn spring-boot:run

Running the Service

OR

Click on "Run Java" in VS code IDE

Once the application is running, you can access the API at:
http://localhost:7000/api/employment-agreements

## Endpoints

POST /api/employment-agreements: Create a new employment agreement.

GET /api/employment-agreements/{id}: Retrieve an agreement by ID.

GET /api/employment-agreements: Retrieve a list of all agreements.

PUT /api/employment-agreements/{id}: Update an agreement by ID.

DELETE /api/employment-agreements/{id}: Delete an agreement by ID.

GET /api/employment-agreements/search: Search agreements by employee name or role.

## Swagger API Documentation

You can interact with all the endpoints directly from the Swagger UI interface, including sending requests and viewing responses.

URL: http://localhost:7000/swagger-ui.html

## Testing

Testing API endpoints using Postman:

![Screenshot 2024-10-05 115945](https://github.com/user-attachments/assets/8e854fdd-f1ff-4408-a03f-8fab0950f16f)
![Screenshot 2024-10-05 120132](https://github.com/user-attachments/assets/509ef332-4ca9-410e-8a75-bf8120300bd3)
![Screenshot 2024-10-05 120149](https://github.com/user-attachments/assets/208e8f51-cabe-4e35-8db6-bdb7f56d89d7)
![Screenshot 2024-10-05 120320](https://github.com/user-attachments/assets/234f59a1-0507-4881-92a9-567fbb58937c)
![Screenshot 2024-10-05 120337](https://github.com/user-attachments/assets/6ccb4e1e-e914-4b62-8121-1e66b72f5577)
![Screenshot 2024-10-05 120438](https://github.com/user-attachments/assets/b281fb3c-8a79-4df5-a385-38393afbdb72)


To run unit tests using cli:

mvn test

Integration Tests

To run integration tests (e.g., service-layer tests):

mvn verify

## Database Setup

H2 Database:

To use H2 for development, you can switch the datasource configuration in application.properties:

spring.h2.console.enabled=true

You can access the h2 database at http://localhost:7000/h2-console

## Error Handling
The service uses a global error-handling mechanism with @ExceptionHandler to provide proper responses for different error scenarios:

Some errors that might occur are:

404 Not Found: Returned when an employment agreement is not found.

400 Bad Request: Returned for validation failures.

500 Internal Server Error: Returned for unexpected server errors.
