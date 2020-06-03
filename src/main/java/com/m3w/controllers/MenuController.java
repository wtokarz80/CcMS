package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.view.MenuPrinting;

import java.io.IOException;

public class MenuController {
    private InputProvider inputProvider = new InputProvider();
    private MenuPrinting menuPrinting = new MenuPrinting();

    public void mainMenu() throws IOException {
        menuPrinting.printMenu();
        int useOption = inputProvider.takeIntegerInput("Enter option: ");
        switch (useOption){
            case 1:
                loginToSystem();
                mainMenu();
            case 0:
                break;
            default:
                mainMenu();
        }

    }


    private void loginToSystem() throws IOException {
        LoginDao loginDao = new LoginDao();
        String userEmail = inputProvider.takeStringInput("Enter e-mail: ");
        String userPassword = inputProvider.takeStringInput("Enter password: ");
        User user = loginDao.selectUser(userEmail, userPassword);

        if (user instanceof Student) {
            //StudentController studentController = new StudentController();
        } else if (user instanceof Employee) {
            //EmployeeController employeeController = new StudentController();
        } else if (user instanceof Mentor) {
            MentorController mentorController = new MentorController();
            mentorController.mentorMenu();
        } else if (user instanceof Manager) {
            //ManagerController managerController = new ManagerController();
        }
    }
}
