package com.booking.system.logic;

import com.booking.system.files.Operations;
import com.booking.system.login.SignIn;
import com.booking.system.login.SignUp;
import com.booking.system.roles.Role;
import com.booking.system.rooms.SetRoom;
import com.booking.system.rooms.RoomType;

import java.util.Arrays;
import java.util.Scanner;


public class Processes {
    public static void Processing(){
        Operations operations = new Operations();
        SignIn signIn = new SignIn();
        SignUp signUp = new SignUp();
        Scanner scanner = new Scanner(System.in);
        SetRoom roomProperties = new SetRoom();
        System.out.println("Sign in | Sign up");
        String input = scanner.nextLine();

        switch (input) {
            case "Sign in" -> {
                signIn.User(Role.User);
                System.out.println("Which type of room you want to see: " + Arrays.toString(RoomType.values()));
                String roomType = scanner.nextLine();
                operations.readRoomFromFile(roomType);
                System.out.println("Please enter a room number: ");
                int roomNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Arrival date (Please enter the date in this format dd.mm.yyyy): ");
                String arrivalDate = scanner.nextLine();
                System.out.println("Leaving date (Please enter the date in this format dd.mm.yyyy): ");
                String leavingDate = scanner.nextLine();
                operations.bookedRooms(roomNumber, arrivalDate, leavingDate);
                System.out.printf("Your room is %d, and it is booked from %s to %s!", roomNumber, arrivalDate, leavingDate);
            }
            case "Sign up" ->
                signUp.User(Role.User);

            case "AdminIn" -> {
                System.out.println("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                String password = scanner.nextLine();
                operations.readAdminFromFile(username, password);
                roomProperties.setProperties();
            }

            case "AdminUp" ->
                signUp.User(Role.Admin);
        }
    }
}
