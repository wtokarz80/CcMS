package com.m3w.models;

import com.m3w.controllers.StudentController;
import com.m3w.services.ToolsCreator;

import java.io.IOException;

public class Student extends User{


    public Student(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }


    @Override
    public void displayMenuOptions(ToolsCreator toolsCreator) throws IOException {
        StudentController studentController = new StudentController(this, toolsCreator);
        studentController.studentOptions();
    }
}
