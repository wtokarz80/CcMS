package com.m3w.controllers;

import com.m3w.dao.MentorDao;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.util.List;

public class MentorController {

    MenuPrinting menu = new MenuPrinting();
    InputProvider input = new InputProvider();

    public void mentorMenu() throws IOException {
        boolean isRun = true;
        while (isRun) {
            menu.printMentorMenu();
            int userChoice = input.takeIntegerInput("");
            switch (userChoice) {
                case 1:
                    getListOfStudents();
                    break;
                case 2:
                    addAssignment();
                    break;
                case 3:
                    gradeAssignment();
                    break;
                case 4:
                    checkAttendance();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    removeStudent();
                    break;
                case 7:
                    updateStudentData();
                    break;
                case 0:
                    isRun = false;

            }
        }
    }

    private void getListOfStudents() {
        MentorDao mentorDao = new MentorDao();
        List<Student> students = mentorDao.getStudentsDetail();
        for (Student s: students){
            System.out.println("[" + s.getId() +"]  "+ s.getName() +" "+ s.getSurname()  + "  |Phone number: " + s.getPhone() + " |E-mail: " + s.getEmail());
        }
    }

    private void addAssignment() throws IOException {
        MentorDao mentorDao = new MentorDao();
        String newAssignment = input.takeStringInput("Provide new assignment's name: ");
        mentorDao.createAssignment(newAssignment);
    }

    private void gradeAssignment() {

    }

    private void checkAttendance() {
    }

    private void addStudent() throws IOException {
            MentorDao mentorDao = new MentorDao();
            String newName = input.takeStringInput("Provide name of the new student: ");
            String newSurname = input.takeStringInput("Provide surname of the new student: ");
            int newPhone = input.takeIntegerInput("Provide phone number of new student: ");
            String newEmail = input.takeStringInput("Provide e-mail address of new student: ");
            String newPassword = input.takeStringInput("Provide his password: ");

            mentorDao.createStudent(newName, newSurname, newPhone, newEmail, newPassword, "student");
    }

   public void removeStudent() throws IOException {
        MentorDao mentorDao = new MentorDao();
        getListOfStudents();
        String email = input.takeStringInput("Which student do You want to delete? (provide E-mail address)");
        mentorDao.deleteStudent(email);

    }

    private void updateStudentData() throws IOException {
        MentorDao mentorDao = new MentorDao();
        getListOfStudents();
        String email = input.takeStringInput("Which student do You want to change details? (provide E-mail address) ");
        System.out.println("Which data do You want to change? " +
                "\n[1] Name" +
                "\n[2] Surname" +
                "\n[3] Phone number" +
                "\n[4] E-mail address");

        boolean isRunning = true;
        while (isRunning){
        int userChoice = input.takeIntegerInput("press '0' to exit: ");
        switch(userChoice){
            case 1:
                String newName = input.takeStringInput("Provide new name for the student: ");
                mentorDao.updateStudentDataString("name", newName, email);
                break;
            case 2:
                String newSurname = input.takeStringInput("Provide new surname for the student: ");
                mentorDao.updateStudentDataString("surname", newSurname, email);
                break;
            case 3:
                int newPhone = input.takeIntegerInput("Provide student's new phone number: ");
                mentorDao.updateStudentDataInt("phone", newPhone, email);
                break;
            case 4:
                String newEmail = input.takeStringInput("Provide student's new E-mail address:  ");
                mentorDao.updateStudentDataString("email", newEmail, email);
                break;
            case 0:
                isRunning = false;
           }

        }

    }

}
