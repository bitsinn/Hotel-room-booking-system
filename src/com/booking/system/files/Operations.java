package com.booking.system.files;

import com.booking.system.login.Validation;
import com.booking.system.roles.Role;
import com.booking.system.roles.User;
import com.booking.system.rooms.Room;

import java.io.*;
import java.util.List;

public class Operations {

    private final File clients = new File("clients.txt");
    private final File staff = new File("admin.txt");
    private final File booked = new File("bookedRooms.txt");
    private final File rooms = new File("rooms.txt");
    private void readPeople(File file, String email, String password){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            Validation validation = new Validation();
            while (line != null){
                validation.readingValidator(line, email, password);
                if (Validation.getMsg() != null){
                    System.out.println("Welcome back!");
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <E> void write(List<E> list, File file){
        try (FileWriter writer = new FileWriter(file)){
            for (var element: list) {
                writer.write(String.valueOf(element));
                writer.write(10);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void read(File file, String element){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null){
                if (line.contains(element)){
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void bookedRooms(int roomNumber, String arrivalDate, String leavingDate){
        try (FileWriter writer = new FileWriter(booked);
             BufferedReader reader = new BufferedReader(new FileReader(rooms))){
            String line = reader.readLine();
            while (line != null){
                if (line.contains(String.valueOf(roomNumber))){
                    String format = "Room number: " + roomNumber + " | " + " Arrival date: " + arrivalDate + " | " + "Leaving date: " + leavingDate;
                    writer.write(format);
                    writer.write(10);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAdminFromFile(String username, String password){
        readPeople(staff, username, password);
    }

    public void readUserFromFile(String email, String password, Role role){
        if (role.equals(Role.User)){
            readPeople(clients, email, password);
        } else if (role.equals(Role.Admin)) {
            readPeople(staff, email, password);
        }
    }

    public void writeUserToFile(List<User> users, Role role){
        if (role.equals(Role.User)){
            write(users, clients);
        } else if (role.equals(Role.Admin)) {
            write(users, staff);
        }

    }

    public void writeRoomToFile(List<Room> room){
        write(room, rooms);
    }

    public void readRoomFromFile(String roomType){
       read(rooms, roomType);
    }
}
