package com.m3w.models;

import com.m3w.controllers.EmployeeController;

import java.io.IOException;

public class Employee extends User{
    public Employee(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }

    @Override
    public void displayMenuOptions() throws IOException {
        EmployeeController employeeController = new EmployeeController(this);
        employeeController.employeeOptions();
    }
}
