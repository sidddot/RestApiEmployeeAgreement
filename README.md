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
Unit Tests
To run unit tests:

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
