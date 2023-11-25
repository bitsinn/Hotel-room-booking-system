package com.booking.system.rooms;

import java.util.List;

public class Room{
    private String roomType;
    private int roomNumber;
    private int roomCapacity;
    private double pricePerNight;
    private String status;
    private List<String> amenities;

    public Room(String roomType, int roomNumber, int roomCapacity, double pricePerNight, String status, List<String> amenities) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomType='" + roomType + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomCapacity=" + roomCapacity +
                ", pricePerNight=" + pricePerNight +
                ", status='" + status + '\'' +
                ", amenities=" + amenities +
                '}';
    }
}
