package com.booking.system.rooms;

import com.booking.system.files.Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetRoom {
    public void setProperties(){

        //TODO: admin can set rooms; Change room status in file when they are booked; Every room in different file?

        List<Room> roomList = new ArrayList<>();
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        String type;
        do {
            System.out.println("Enter type of room: ");
            type = scanner.nextLine();
            System.out.println("Enter room number: ");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter room capacity: ");
            int roomCapacity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter price per night: ");
            double pricePerNight = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter room status: ");
            String status = scanner.nextLine();
            System.out.println("Enter room amenities (separated by ',': ");
            String roomAmenities = scanner.nextLine();
            String[] amenities = roomAmenities.trim().split(",");
            Room room = new Room(type, roomNumber, roomCapacity, pricePerNight, status, List.of(amenities));
            roomList.add(room);
        }while (type.equals("stop"));

        operations.writeRoomToFile(roomList);
    }
}
