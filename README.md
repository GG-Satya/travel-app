# Travel Agency Management System

## Overview
This project implements a Travel Agency Management System using Java Spring Boot. It allows travel agencies to maintain their travel packages' itinerary and passengers, including details of destinations, activities, and passengers.

## Prerequisites
Before running the application, ensure you have the following prerequisites installed:
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL (or any other preferred relational database)

## Setup
1. Clone the repository to your local machine:
```git clone https://github.com/your-username/travel-agency.git```
2. Navigate to the project directory:
```cd travel-agency```
3. Configure the database connection:
- By default it is set with MYSQL 8
- Open `src/main/resources/application.properties`.
- Modify the `spring.datasource.*` properties according to your database configuration.

4. Build the project using Maven:
```mvn clean package```
5. Run the application:
```java -jar target/travel-agency-1.0.jar```

6. Access the application:
- The application will be running at `http://localhost:8282/`.

## Usage
- Use Postman or any other REST API client to interact with the application.
- Use the provided endpoints to add destinations, activities, and passengers, and retrieve itinerary and passenger details.

## Login
- **Post** request on `http://localhost:8282/user/login`.
- Requset body of Json :
`{ email : "satya@gmail.com"
password : "satya" }`
- Get the JWT token on sucessful login and Hit below end points.

## Endpoints
- **POST http://localhost:8282//travel-agency/destination**: Add a new destination.
- **POST http://localhost:8282//travel-agency/activity**: Add a new activity.
- **POST http://localhost:8282//travel-agency/passenger**: Add a new passenger.
- **GET http://localhost:8282//travel-agency/itinerary/{travelPackageId}**: Get the itinerary of a travel package.
- **GET http://localhost:8282//travel-agency/passenger-list/{travelPackageId}**: Get the passenger list of a travel package.
- **GET http://localhost:8282//travel-agency/passenger/{passengerId}**: Get details of an individual passenger.
- **GET http://localhost:8282//travel-agency/available-activities**: Get details of all available activities.

