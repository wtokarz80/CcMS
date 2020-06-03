package com.m3w.controllers;

import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.mainMenu();
    }
}
