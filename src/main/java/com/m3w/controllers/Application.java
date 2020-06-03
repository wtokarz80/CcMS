package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.User;

import java.io.IOException;
import java.util.Scanner;

public class Application {




    public static void main(String[] args) throws IOException {

        MenuController menuController = new MenuController();

        menuController.mainMenu();
    }
}
