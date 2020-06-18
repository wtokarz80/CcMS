package com.m3w.controllers;

import com.m3w.dao.MentorDAO;
import com.m3w.interfaces.IMentorDAO;
import com.m3w.models.Attendance;
import com.m3w.models.Mentor;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.services.ToolsCreator;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MentorController {

    private final MenuPrinter menuPrinter;
    private final InputProvider inputProvider;
    private final DataPrinter dataPrinter;
    private final Mentor mentor;
    private final IMentorDAO mentorDao = new MentorDAO();

    public MentorController(Mentor mentor, ToolsCreator toolsCreator) {
        this.mentor = mentor;
        this.menuPrinter = toolsCreator.getMenuPrinter();
        this.inputProvider = toolsCreator.getInputProvider();
        this.dataPrinter = toolsCreator.getDataPrinter();
    }


    public void mentorMenu() throws IOException {
        String mentorMenu = menuPrinter.printMentorMenu();
        menuPrinter.printSpecificWindow(mentorMenu, "                                                           ");
        boolean isRun = true;
        while (isRun) {
            dataPrinter.printLogInfo(mentor);
            int userChoice = inputProvider.getNumberFromUser("Enter option: ");
            dataPrinter.clearScreen();
            switch (userChoice) {
                case 1:
                    getListOfStudents(mentorMenu);
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
                    removeStudent(mentorMenu);
                    break;
                case 7:
                    updateStudentData(mentorMenu);
                    break;
                case 8:
                    viewAttendance(mentorMenu);
                    break;
                case 0:
                    isRun = false;
                default:
                    break;
            }
        }
    }

    public void getListOfStudents(String mentorMenu) {
        List<Student> students = mentorDao.selectAllObjects();
        String listOfStudents = dataPrinter.printUsers(students);
        menuPrinter.printSpecificWindow(mentorMenu, listOfStudents);

    }


    private void addAssignment() throws IOException {
        String newAssignment = inputProvider.takeStringInput("Provide new assignment's name: ");
        String description = inputProvider.takeStringInput("Describe task for students: ");
        mentorDao.createAssignment(newAssignment, description);
    }


    private void gradeAssignment() throws IOException {
        int mentorID = mentor.getId();
        int evaluationID = inputProvider.getNumberFromUser("Which evaluation do You want to grade? (via evaluation's ID) ");

        String pass = inputProvider.takeStringInput("Does student's assignment deserves passing? (y/n)").toLowerCase();
        switch (pass) {
            case "y":
                mentorDao.evaluateStudent(evaluationID, mentorID, "Passed");
                break;
            case "n":
                mentorDao.evaluateStudent(evaluationID, mentorID, "Rejected");
                break;
            default:
                break;
        }
    }

    private void checkAttendance() throws IOException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringDate = date.format(formatter);
        List<Student> students = mentorDao.selectAllObjects();
        for (Student s : students) {
            System.out.println(" |" + s.getName() + " |" + s.getSurname() + " |" + s.getEmail());
            String isPresent = inputProvider.takeStringInput("Is this student present? (y/n)").toLowerCase();
            switch (isPresent) {
                case "y":
                    mentorDao.fillAttendance(s.getId(), 1, stringDate);
                    break;
                case "n":
                    mentorDao.fillAttendance(s.getId(), 0, stringDate);
                    break;
                default:
                    break;
            }
        }

    }

    public void viewAttendance(String mentorMenu) {
        getListOfStudents(mentorMenu);
        int studentID = inputProvider.getNumberFromUser("Which student do You want see attendance? (enter id): ");

        List<Attendance> attendances = mentorDao.viewById(studentID);
        String listOfAttendances = dataPrinter.printAllAttendance(attendances);
        menuPrinter.printSpecificWindow(mentorMenu, listOfAttendances);
    }

    private void addStudent() throws IOException {
        String newName = inputProvider.takeStringInput("Provide name of the new student: ");
        String newSurname = inputProvider.takeStringInput("Provide surname of the new student: ");
        int newPhone = inputProvider.getNumberFromUser("Provide phone number of new student: ");
        String newEmail = inputProvider.takeStringInput("Provide e-mail address of new student: ");
        String newPassword = inputProvider.takeStringInput("Provide his password: ");
        mentorDao.createUserDetails(newName, newSurname, newPhone, newEmail, newPassword, "student");
    }

    public void removeStudent(String mentorMenu) throws IOException {
        getListOfStudents(mentorMenu);
        String email = inputProvider.takeStringInput("Which student do You want to delete? (provide E-mail address): ");
        mentorDao.removeUser(email);

    }

    private void updateStudentData(String mentorMenu) throws IOException {
        getListOfStudents(mentorMenu);
        String email = inputProvider.takeStringInput("Which student details you want to change? (provide E-mail address): ");
        menuPrinter.printSpecificWindow(mentorMenu, menuPrinter.printUpdateUser());
        boolean isRunning = true;
        while (isRunning) {
            int userChoice = inputProvider.getNumberFromUser("Choose option: ");
            switch (userChoice) {
                case 1:
                    String newName = inputProvider.takeStringInput("Provide new name for the student: ");
                    mentorDao.updateUserDataString("name", newName, email);
                    break;
                case 2:
                    String newSurname = inputProvider.takeStringInput("Provide new surname for the student: ");
                    mentorDao.updateUserDataString("surname", newSurname, email);
                    break;
                case 3:
                    int newPhone = inputProvider.getNumberFromUser("Provide student's new phone number: ");
                    mentorDao.updateUserDataInt("phone", newPhone, email);
                    break;
                case 4:
                    String newEmail = inputProvider.takeStringInput("Provide student's new E-mail address:  ");
                    mentorDao.updateUserDataString("email", newEmail, email);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
