# Car Parking Management System

This Spring Boot project is a Car Parking Management System designed to handle the parking of cars in a parking lot. The application features web support, data persistence with Spring Data JPA, and an H2 in-memory database for development purposes. Error handling is implemented to provide meaningful messages in case of exceptions.

## Prerequisites

- Java 11 or later
- Maven 3.x

## Getting Started

Follow these steps to run the Car Parking Management System:

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/rrahulm/car-parking-system
    cd car-parking-management-system
    ```

2. **Build the Project:**

    ```bash
    mvn clean install
    ```

3. **Run the Application:**

    ```bash
    mvn spring-boot:run
    ```

4. **Access the Endpoints:**

    - The application exposes the following endpoints:
      - `POST /api/parking/create/parking/spots/{numberOfSpots}`: To initializing numbers of parking spots.
      - `POST /api/parking/park`: To park a car.
      - `GET /api/parking/retrieve/{carId}`: To retrieve details of a parked car by its ID.
      - `GET /api/parking/all`: To retrieve a list of all parked cars.
      - `GET /api/parking/spots/all`: To retrieve all parking spots.

## Notes

- Adjust the database configuration in `src/main/resources/application.properties` if necessary.
- Customize the project according to your specific requirements and extend the functionalities as needed.

## Author

Rahul Malik