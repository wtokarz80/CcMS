package com.m3w.controllers;

import com.m3w.dao.LoginDAO;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

public class MenuController {
    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinter menuPrinter = new MenuPrinter();
    private final DataPrinter dataPrinter = new DataPrinter();
    private User user;

    public void mainMenu() throws Exception {
        menuPrinter.printMenu();
        int userOption = inputProvider.getNumberFromUser("Enter option: ");
        dataPrinter.clearScreen();
        switch (userOption){
            case 1:
                loginToSystem();
                mainMenu();
                break;
            case 0:
                break;
            default:
                mainMenu();
                break;
        }
    }

    private void loginToSystem() throws Exception {
        LoginDAO loginDao = new LoginDAO();
        boolean validUser = false;
        while (!validUser){
            String userEmail = inputProvider.takeStringInput("Enter e-mail: ");
            if (userEmail.equalsIgnoreCase("exit")){
                break;
            }
            String userPassword = inputProvider.takeStringInput("Enter password: ");
            user = loginDao.selectUser(userEmail, userPassword);
            if (user == null) {
                dataPrinter.printString("\n\nThere is no user in database, try again or EXIT (type 'exit').\n\n");
            } else {
                user.displayMenuOptions();
                validUser = true;
            }
        }
    }
}
