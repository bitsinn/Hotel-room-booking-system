package com.booking.system.login;

import com.booking.system.files.Operations;
import com.booking.system.roles.Role;
import com.booking.system.roles.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignUp {
    public void User(Role role){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter you last name: ");
        String lastName = scanner.nextLine();
        if (role.equals(Role.Admin)){
            System.out.println("Enter you username: ");
        } else if (role.equals(Role.User)) {
            System.out.println("Enter you email: ");
        }
        String email = scanner.nextLine();
        System.out.println("Enter you password: ");
        String password = scanner.nextLine();
        List<User> users = new ArrayList<>();
        users.add(new User(firstName, lastName, email, password));
        Validation.writingValidator(role, email, password);

        if (Validation.getMsg().equals("Success")){
            Operations operations = new Operations();
            operations.writeUserToFile(users, role);
            System.out.println("You have been registered!");
        }else {
            System.out.println("Bad credentials!");
        }
    }
}
