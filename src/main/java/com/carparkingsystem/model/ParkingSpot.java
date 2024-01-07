package com.carparkingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int spotNumber;
    private boolean occupied;
    private String type;

    // Constructors, getters, setters...

    // Default constructor for JPA
    public ParkingSpot() {
    }

    // Parameterized constructor
    public ParkingSpot(int spotNumber, boolean occupied, String type) {
        this.spotNumber = spotNumber;
        this.occupied = occupied;
        this.type = type;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // toString() method for easy debugging
    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", spotNumber=" + spotNumber +
                ", occupied=" + occupied +
                ", type='" + type + '\'' +
                '}';
    }
}