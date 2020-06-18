package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

public class MenuController {
    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinting menuPrinting = new MenuPrinting();
    private final DataPrinting dataPrinting = new DataPrinting();
    private User user;

    public void mainMenu() throws Exception {
        menuPrinting.printMenu();
        int userOption = inputProvider.getNumberFromUser("Enter option: ");
        dataPrinting.clearScreen();
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
        LoginDao loginDao = new LoginDao();
        boolean validUser = false;
        while (!validUser){
            String userEmail = inputProvider.takeStringInput("Enter e-mail: ");
            if (userEmail.equalsIgnoreCase("exit")){
                break;
            }
            String userPassword = inputProvider.takeStringInput("Enter password: ");
            user = loginDao.selectUser(userEmail, userPassword);
            if (user == null) {
                dataPrinting.printString("\n\nThere is no user in database, try again or EXIT (type 'exit').\n\n");
            } else {
                user.displayMenuOptions();
                validUser = true;
            }
        }
    }
}
