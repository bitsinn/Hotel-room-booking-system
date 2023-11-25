package com.booking.system.login;


import com.booking.system.files.Operations;
import com.booking.system.roles.Role;

import java.util.Scanner;

public class SignIn {
    public void User(Role role){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email: ");
        String email = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();

        Operations operations = new Operations();
        operations.readUserFromFile(email, password, role);
    }
}
