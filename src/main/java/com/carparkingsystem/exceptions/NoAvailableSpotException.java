package com.carparkingsystem.exceptions;

public class NoAvailableSpotException extends ParkingException {
    public NoAvailableSpotException(String message) {
        super(message);
    }
}
