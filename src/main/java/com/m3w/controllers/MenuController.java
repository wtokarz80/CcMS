package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.io.Console;


public class MenuController {
    Console console = System.console();
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
            case 0:
                break;
            default:
                mainMenu();
        }
    }

    private void loginToSystem() throws Exception {
        String userPasswordString;
        LoginDao loginDao = new LoginDao();
        boolean validUser = false;
        while (!validUser){
            String userEmail = inputProvider.takeStringInput("Enter e-mail: ");
            if (userEmail.equalsIgnoreCase("exit")){
                break;
            }
            char[] userPassword = inputProvider.takeCharInput(console.readPassword("Password: "));
            userPasswordString = String.valueOf(userPassword);
            //System.out.println(userPassword);
            user = loginDao.selectUser(userEmail, userPasswordString);
            if (user == null) {
                dataPrinting.printString("\n\nThere is no user in database, try again or EXIT (type 'exit').\n\n");
            } else {
                user.displayMenuOptions();
                validUser = true;
            }
        }
    }
}
