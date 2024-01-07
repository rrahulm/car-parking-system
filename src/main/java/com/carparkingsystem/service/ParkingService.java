package com.carparkingsystem.service;

import com.carparkingsystem.model.Car;
import com.carparkingsystem.model.ParkingSpot;

import java.util.List;

public interface ParkingService {
    void parkCar(Car car, ParkingSpot spot);

    Car retrieveCar(long carId);

    ParkingSpot findAvailableSpot();

    List<Car> getAllParkedCars();

    void initializeParkingSpots(int numberOfParkingSpots);

    List<ParkingSpot> getAllParkingSpots();
}
