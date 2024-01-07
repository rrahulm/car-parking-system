package com.carparkingsystem.exceptions;

public class CarNotFoundException extends ParkingException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
