package com.m3w.controllers;

import com.m3w.dao.EmployeeDAO;
import com.m3w.models.Employee;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.util.ArrayList;
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

    public void employeeOptions() throws IOException {
        menuPrinting.printEmployeeMenu();
        int userChoice = inputProvider.getNumberFromUser("Enter option: ");

        switch (userChoice) {
            case 1:
                System.out.println("\nShow list of students\n");
                showAllStudents();
                employeeOptions();
                break;
            case 0:
                System.out.println("Back to previous menu");
                break;
            default:
                employeeOptions();
                break;
        }
    }


    private void showAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList = employeeDAO.getStudentDetail();
        for (Student student : studentList){
            System.out.println("[" + student.getId() +"]  "+ student.getName() +" "+ student.getSurname()  + "  |Phone number: " + student.getPhone() + " |E-mail: " + student.getEmail());
        }
    }
}
