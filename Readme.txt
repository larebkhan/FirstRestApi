Spam Identifier API
Overview
The Spam Identifier API is a RESTful web service built with Java and Spring Boot, using Hibernate ORM for database interactions. This API allows users to register, mark numbers as spam, and search for people by name or phone number.

Prerequisites
Make sure you have the following installed:

Java (version 8 or later)
Maven
MySQL
Database Setup
Create a MySQL database for the application. You can configure the database connection in src/main/resources/application.properties.

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/spam_identifier_db

spring.datasource.username=root

spring.datasource.password=root_password

Run the application to let Hibernate generate the necessary tables in the database.

Running the Application

Open the project in your preferred IDE.

Locate the SpamIdentifierApplication class in src/main/java/com/yourpackagepath/SpamIdentifierApplication.java.

Right-click on the class and choose "Run" or "Debug" to start the application.

The API will be accessible at http://localhost:8080.

API Endpoints

Mark Number as Spam

Endpoint: POST /api/spam/mark

Request Body:

json
Copy code
{
    "phoneNumber": "9876543210"
}
Search by Name
Endpoint: GET /api/search/name/{query}

Example: GET /api/search/name/John

Search by Phone Number

Endpoint: GET /api/search/number/{phoneNumber}

Example: GET /api/search/number/1234567890

Data Population (for Testing)

To populate the database with sample data, the application includes a built-in data populator. When you run the application, it will automatically populate the database with random user accounts, mark some numbers as spam, and simulate a user's contact list.