package com.m3w.controllers;

import com.m3w.dao.StudentDao;
import com.m3w.models.Assignment;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentController {


    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinting menuPrinting = new MenuPrinting();
    private final DataPrinting dataPrinting = new DataPrinting();
    private StudentDao studentDao = new StudentDao();

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
                    System.out.println("View all assignments\n");
                    viewAllAssignments();
                    break;
                case 2:
                    System.out.println("View my grades");
                    break;
                case 0:
                    System.out.println("Back to previous menu");
                    break;
                default:
                    studentOptions();
                    break;
            }
        }
    }

    private void viewAllAssignments() {
        List<Assignment> assignments;
        assignments = studentDao.selectAllObjects();
        System.out.println(assignments.toString());

    }

    private void submitAssignment() {

    }

}
