package com.m3w.controllers;

import com.m3w.dao.EmployeeDAO;
import com.m3w.models.Employee;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.util.List;

public class EmployeeController {

    private InputProvider inputProvider = new InputProvider();
    private MenuPrinting menuPrinting = new MenuPrinting();
    private DataPrinting dataPrinting = new DataPrinting();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee employee;

    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    public void employeeOptions() {
        dataPrinting.printLogInfo(employee);
        menuPrinting.printEmployeeMenu();
        int userChoice = inputProvider.getNumberFromUser("Enter option: ");
        dataPrinting.clearScreen();

        switch (userChoice) {
            case 1:
                dataPrinting.printString("\nShow list of students\n");
                showAllStudents();
                employeeOptions();
                break;
            case 0:
                break;
            default:
                employeeOptions();
                break;
        }
    }


    private void showAllStudents() {
        List<Student> studentList;
        studentList = employeeDAO.getStudentDetail();
        for (Student student : studentList){
            dataPrinting.printUser(student);
        }
    }
}
