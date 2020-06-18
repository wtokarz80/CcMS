package com.m3w.controllers;

import com.m3w.dao.EmployeeDAO;
import com.m3w.interfaces.IEmployeeDAO;
import com.m3w.models.Employee;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.services.ToolsCreator;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

import java.util.List;

public class EmployeeController {

    private InputProvider inputProvider;
    private MenuPrinter menuPrinter;
    private DataPrinter dataPrinter;
    private IEmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee employee;

    public EmployeeController(Employee employee, ToolsCreator toolsCreator) {
        this.employee = employee;
        this.inputProvider = toolsCreator.getInputProvider();
        this.menuPrinter = toolsCreator.getMenuPrinter();
        this.dataPrinter = toolsCreator.getDataPrinter();
    }

    public void employeeOptions() {
        dataPrinter.printLogInfo(employee);
        menuPrinter.printSpecificWindow(menuPrinter.printEmployeeMenu(), "                           ");
        int userChoice = inputProvider.getNumberFromUser("Enter option: ");
        dataPrinter.clearScreen();

        switch (userChoice) {
            case 1:
                dataPrinter.printString("\nShow list of students\n");
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

        List<Student> studentList =  employeeDAO.selectAllObjects();
        String listOfStudents = dataPrinter.printUsers(studentList);
        menuPrinter.printSpecificWindow(menuPrinter.printEmployeeMenu(), listOfStudents);

        }

}

