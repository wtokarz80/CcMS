package com.m3w.controllers;

import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {


    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinting menuPrinting = new MenuPrinting();
    private final DataPrinting dataPrinting = new DataPrinting();

    public void studentOptions() throws IOException {

        boolean isRunning  = true;
        while (isRunning) {
            menuPrinting.printStudentMenu();
            int userChoice = inputProvider.takeIntegerInput("What do you want to do right now?\n");
            if(userChoice == 0) {
                isRunning = false;
            }
            switch (userChoice) {
                case 1:
                    System.out.println("Submit an assignment");
                    submitAssignment();
                    break;
                case 2:
                    System.out.println("View my grades");
                    break;
                case 0:
                    System.out.println("Back to previous menu");
                    break;
                default: {
                    studentOptions();
                    break;
                }
            }
        }
    }

    private void submitAssignment() {

    }

}
