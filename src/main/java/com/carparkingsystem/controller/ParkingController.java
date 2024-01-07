package com.carparkingsystem.controller;


import com.carparkingsystem.exceptions.CarNotFoundException;
import com.carparkingsystem.exceptions.ParkingException;
import com.carparkingsystem.model.Car;
import com.carparkingsystem.model.ParkingSpot;
import com.carparkingsystem.service.ParkingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;


    @PostMapping("/park")
    public void parkCar(@RequestBody Car car) {
        try {
            ParkingSpot availableSpot = parkingService.findAvailableSpot();
            parkingService.parkCar(car, availableSpot);
        } catch (ParkingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @GetMapping("/retrieve/{carId}")
    public Car retrieveCar(@PathVariable long carId) {
        try {
            return parkingService.retrieveCar(carId);
        } catch (CarNotFoundException e) {
            // Handle exception and return appropriate HTTP response
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/all")
    public List<Car> getAllParkedCars() {
        return parkingService.getAllParkedCars();
    }

    @PostMapping("/create/parking/spots/{numberOfSpots}")
    public void createParkingSpots(@PathVariable("numberOfSpots") int numberOfSpots){
        parkingService.initializeParkingSpots(numberOfSpots);
    }

    @GetMapping("/spots/all")
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingService.getAllParkingSpots();
    }

}
