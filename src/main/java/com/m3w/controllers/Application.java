package com.m3w.controllers;


import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {



        // ONLY FOR TESTING
//
//        LoginDao loginDao = new LoginDao();
//        System.out.print("Enter email: ");
//        userEmail = scanner.nextLine();
//        System.out.println();
//        System.out.print("Enter password: ");
//        userPassword = scanner.nextLine();
//        User user = loginDao.selectUser(userEmail, userPassword);
//        if (user == null) {
//            System.out.println("\nYou have to register first, or invalid input!\n");
//        } else {
//            System.out.println();
//            System.out.println(user.toString());
//        }



        MenuController menuController = new MenuController();
        menuController.mainMenu();
    }
}
