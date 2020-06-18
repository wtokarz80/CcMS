package com.m3w.controllers;

import com.m3w.dao.LoginDAO;
import com.m3w.models.*;
import com.m3w.services.InputProvider;
import com.m3w.services.ToolsCreator;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

public class MenuController {
    final ToolsCreator toolsCreator = new ToolsCreator();
    private User user;

    public void mainMenu() throws Exception {
        toolsCreator.getMenuPrinter().printMenu();
        int userOption = toolsCreator.getInputProvider().getNumberFromUser("Enter option: ");
        toolsCreator.getDataPrinter().clearScreen();
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
            String userEmail = toolsCreator.getInputProvider().takeStringInput("Enter e-mail: ");
            if (userEmail.equalsIgnoreCase("exit")){
                break;
            }
            String userPassword = toolsCreator.getInputProvider().takeStringInput("Enter password: ");
            user = loginDao.selectUser(userEmail, userPassword);
            if (user == null) {
                toolsCreator.getDataPrinter().printString("\n\nThere is no user in database, try again or EXIT (type 'exit').\n\n");
            } else {
                user.displayMenuOptions(toolsCreator);
                validUser = true;
            }
        }
    }
}
