package com.m3w.models;

import com.m3w.controllers.ManagerController;


public class Manager extends User{
    public Manager(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }

    @Override
    public void displayMenuOptions() throws Exception {
        ManagerController managerController = new ManagerController(this);
        managerController.managerMenu();
    }
}
