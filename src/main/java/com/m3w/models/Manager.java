package com.m3w.models;

import com.m3w.controllers.ManagerController;

import java.io.IOException;

public class Manager extends User{
    public Manager(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }

    @Override
    public void displayMenuOptions() throws IOException {
        ManagerController managerController = new ManagerController();
        managerController.managerMenu();
    }
}
