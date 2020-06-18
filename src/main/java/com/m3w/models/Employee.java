package com.m3w.models;

import com.m3w.controllers.EmployeeController;
import com.m3w.services.ToolsCreator;


public class Employee extends User{
    public Employee(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }

    @Override
    public void displayMenuOptions(ToolsCreator toolsCreator) {
        EmployeeController employeeController = new EmployeeController(this, toolsCreator);
        employeeController.employeeOptions();
    }
}
