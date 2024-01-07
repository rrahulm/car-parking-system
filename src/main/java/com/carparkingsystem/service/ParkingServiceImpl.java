package com.carparkingsystem.service;

import com.carparkingsystem.exceptions.CarNotFoundException;
import com.carparkingsystem.exceptions.NoAvailableSpotException;
import com.carparkingsystem.exceptions.ParkingSpotOccupiedException;
import com.carparkingsystem.model.Car;
import com.carparkingsystem.model.ParkingSpot;
import com.carparkingsystem.repository.CarRepository;
import com.carparkingsystem.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Override
    public void parkCar(Car car, ParkingSpot spot) {
        if (!spot.isOccupied()) {
            spot.setOccupied(true);
            carRepository.save(car);
            System.out.println("Car parked successfully!");
        } else {
            throw new ParkingSpotOccupiedException("Parking spot is already occupied!");
        }
    }

    @Override
    public Car retrieveCar(long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + carId));
    }

    @Override
    public ParkingSpot findAvailableSpot() {
        return parkingSpotRepository.findByOccupiedFalse()
                .orElseThrow(() -> new NoAvailableSpotException("No available parking spots!"));
    }

    @Override
    public List<Car> getAllParkedCars() {
        return carRepository.findAll();
    }

    @Override
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

    @Override
    public void initializeParkingSpots(int numberOfParkingSpots) {
        if (parkingSpotRepository.count() == 0) {
            //initializing paking spots
            for (int i = 1; i <= numberOfParkingSpots; i++) {
                ParkingSpot spot = new ParkingSpot();
                spot.setSpotNumber(i);
                spot.setOccupied(false);
                spot.setType("Standard");
                parkingSpotRepository.save(spot);
            }
            System.out.println("Parking spots initialized successfully!");
        } else {
            System.out.println("Parking spots already exist in the database.");
        }
    }
}
