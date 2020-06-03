package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.User;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    // ONLY FOR TESTING

    public static Scanner scanner = new Scanner(System.in);
    public static String userEmail;
    public static String userPassword;

    // ..............


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


        MentorController mentorController = new MentorController();
        mentorController.mentorMenu();
    }
}
