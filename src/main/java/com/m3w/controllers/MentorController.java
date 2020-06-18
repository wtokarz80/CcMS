package com.m3w.controllers;

import com.m3w.dao.MentorDao;
import com.m3w.models.Attendance;
import com.m3w.models.Mentor;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MentorController {

    private final MenuPrinter menu = new MenuPrinter();
    private final InputProvider input = new InputProvider();
    private final Mentor mentor;
    private final MentorDao mentorDao = new MentorDao();
    private final DataPrinter dataPrinter = new DataPrinter();

    public MentorController(Mentor mentor) {
        this.mentor = mentor;
    }


    public void mentorMenu() throws IOException {
        boolean isRun = true;
        while (isRun) {
            dataPrinter.printLogInfo(mentor);
            menu.printMentorMenu();
            int userChoice = input.getNumberFromUser("Enter option: ");
            dataPrinter.clearScreen();
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
                case 8:
                    viewAttendance();
                    break;
                case 0:
                    isRun = false;
                default:
                    break;
            }
        }
    }

    public void getListOfStudents() {
        List<Student> students = mentorDao.getStudentsDetail();
        for (Student s : students) {
            dataPrinter.printUser(s);
        }
    }

    private void addAssignment() throws IOException {
        String newAssignment = input.takeStringInput("Provide new assignment's name: ");
        String description = input.takeStringInput("Describe task for students: ");
        mentorDao.createAssignment(newAssignment, description);
    }


    private void gradeAssignment() throws IOException {
        int mentorID = mentor.getId();
        int evaluationID = input.getNumberFromUser("Which evaluation do You want to grade? (via evaluation's ID) ");

        String pass = input.takeStringInput("Does student's assignment deserves passing? (y/n)").toLowerCase();
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
        List<Student> students = mentorDao.getStudentsDetail();
        for (Student s : students) {
            System.out.println(" |" + s.getName() + " |" + s.getSurname() + " |" + s.getEmail());
            String isPresent = input.takeStringInput("Is this student present? (y/n) ").toLowerCase();
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

    public void viewAttendance() throws IOException {
        getListOfStudents();
        int studentID = input.getNumberFromUser("Which student do You want see attendance? (enter id): ");
        List<Attendance> attendances = mentorDao.viewListStudentAttendance(studentID);
        for (Attendance a : attendances) {
            dataPrinter.printAttendance(a);
        }
    }

    private void addStudent() throws IOException {
        String newName = input.takeStringInput("Provide name of the new student: ");
        String newSurname = input.takeStringInput("Provide surname of the new student: ");
        int newPhone = input.getNumberFromUser("Provide phone number of new student: ");
        String newEmail = input.takeStringInput("Provide e-mail address of new student: ");
        String newPassword = input.takeStringInput("Provide his password: ");
        mentorDao.createStudentDetails(newName, newSurname, newPhone, newEmail, newPassword, "student");
    }

    public void removeStudent() throws IOException {
        getListOfStudents();
        String email = input.takeStringInput("Which student do You want to delete? (provide E-mail address): ");
        mentorDao.deleteStudent(email);

    }

    private void updateStudentData() throws IOException {
        getListOfStudents();
        String email = input.takeStringInput("Which student details you want to change? (provide E-mail address): ");
        menu.printStudentMenu();
        boolean isRunning = true;
        while (isRunning) {
            int userChoice = input.getNumberFromUser("press '0' to exit: ");
            switch (userChoice) {
                case 1:
                    String newName = input.takeStringInput("Provide new name for the student: ");
                    mentorDao.updateStudentDataString("name", newName, email);
                    break;
                case 2:
                    String newSurname = input.takeStringInput("Provide new surname for the student: ");
                    mentorDao.updateStudentDataString("surname", newSurname, email);
                    break;
                case 3:
                    int newPhone = input.getNumberFromUser("Provide student's new phone number: ");
                    mentorDao.updateStudentDataInt("phone", newPhone, email);
                    break;
                case 4:
                    String newEmail = input.takeStringInput("Provide student's new E-mail address:  ");
                    mentorDao.updateStudentDataString("email", newEmail, email);
                    break;
                case 0:
                    isRunning = false;
                default:
                    break;
            }
        }
    }
}
