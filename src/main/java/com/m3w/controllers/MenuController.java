package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;



public class MenuController {
    private InputProvider inputProvider = new InputProvider();
    private MenuPrinting menuPrinting = new MenuPrinting();
    private DataPrinting dataPrinting;
    User user;

    public void mainMenu() throws Exception {
        menuPrinting.printMenu();
//        int useOption = inputProvider.takeIntegerInput("Enter option: ");
        int userOption = inputProvider.getNumberFromUser("Enter option: ");
        switch (userOption){
            case 1:
                loginToSystem();
                mainMenu();
            case 0:
                break;
            default:
                mainMenu();
        }
    }

    private void loginToSystem() throws Exception {
        LoginDao loginDao = new LoginDao();
        String userEmail = inputProvider.takeStringInput("Enter e-mail: ");
        String userPassword = inputProvider.takeStringInput("Enter password: ");
        user = loginDao.selectUser(userEmail, userPassword);
        if (user == null) {
            dataPrinting.printString("\n\nThere is no user in database\n\n");
        }
        user.displayMenuOptions();
    }
}
