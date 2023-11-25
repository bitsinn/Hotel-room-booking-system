package com.booking.system.login;

import com.booking.system.roles.Role;

import java.util.regex.Pattern;

public class Validation {
    private static final Pattern EMAIL = Pattern.compile(".+");
    private static final Pattern PASSWORD = Pattern.compile(".+");
    private static final Pattern USERNAME = Pattern.compile(".+");
    static Validation validation = new Validation();
    private static String msg;

    public static String getMsg() {
        return msg;
    }

    private void setMsg() {
        Validation.msg = "Success";
    }

    protected static void writingValidator(Role role, String username, String password) {

        switch (role) {
            case Admin -> {
                if (USERNAME.matcher(username).matches()) {
                    if (PASSWORD.matcher(password).matches()) {
                        validation.setMsg();
                    } else {
                        System.out.println("Bad password!");
                    }
                } else {
                    System.out.println("Bad username!");
                }
            }

            case User -> {
                if (EMAIL.matcher(username).matches()) {
                    if (PASSWORD.matcher(password).matches()) {
                        validation.setMsg();
                    } else {
                        System.out.println("Bad password!");
                    }
                } else {
                    System.out.println("Bad username!");

                }
            }
        }
    }

    public void readingValidator(String line, String email, String password){
        String[] elements = line.split("\\s+|\\||\\|\\s+");
        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j < elements.length; j++) {
                if (elements[i].contains(email) && elements[j].contains(password)){
                    validation.setMsg();
                    break;
                }
            }
        }
    }

    //TODO: public void freeRoomValidator(RoomType, dayOfArrival, dayOfLeaving)
}