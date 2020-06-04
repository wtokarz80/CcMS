package com.m3w.controllers;

import com.m3w.dao.MentorDao;
import com.m3w.models.Attendance;
import com.m3w.models.Mentor;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MentorController {

    MenuPrinting menu = new MenuPrinting();
    InputProvider input = new InputProvider();
    private final Mentor mentor;
    MentorDao mentorDao = new MentorDao();

    public MentorController(Mentor mentor) {
        this.mentor = mentor;
    }


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
                case 8:
                    viewAttendance();
                    break;
                case 0:
                    isRun = false;

            }
        }
    }

    public void getListOfStudents() {
        MentorDao mentorDao = new MentorDao();
        List<Student> students = mentorDao.getStudentsDetail();
        for (Student s: students){
            System.out.println("[" + s.getId() +"]  "+ s.getName() +" "+ s.getSurname()  + "  |Phone number: " + s.getPhone() + " |E-mail: " + s.getEmail());
        }
    }

    private void addAssignment() throws IOException {
        MentorDao mentorDao = new MentorDao();
        String newAssignment = input.takeStringInput("Provide new assignment's name: ");
        String description = input.takeStringInput("Describe task for students: ");
        mentorDao.createAssignment(newAssignment, description);
    }

    private void gradeAssignment() throws IOException {
        MentorDao mentorDao = new MentorDao();
        int mentorID = mentor.getId();
        int evaluationID = input.takeIntegerInput("Which evaluation do You want to grade? (via evaluation's ID) ");
        String pass = input.takeStringInput("Does student's assignment deserves passing? (y/n)");
        switch(pass) {
            case "y":
                mentorDao.evaluateStudent(evaluationID, mentorID, "Passed");
                break;
            case "n":
                mentorDao.evaluateStudent(evaluationID, mentorID, "Rejected");
                break;
        }
    }

    private void checkAttendance() throws IOException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringDate = date.format(formatter);
        List<Student> students = mentorDao.getStudentsDetail();
        for (Student s: students){
            System.out.println(" |" +s.getName() + " |" + s.getSurname() +" |"+ s.getEmail());
            String isPresent = input.takeStringInput("Is this student present? ");
            switch(isPresent){
                case "y":
                    mentorDao.fillAttendance(s.getId(), 1, stringDate);
                    break;
                case "n":
                    mentorDao.fillAttendance(s.getId(), 0, stringDate);
                    break;

            }
        }

    }

    public void viewAttendance() throws IOException {
        getListOfStudents();
        int studentID = input.takeIntegerInput("Which student do You want see attendance? ");
        List<Attendance> attendances = mentorDao.viewListStudentAttendance(studentID);
        for (Attendance a: attendances){
            System.out.println(a.getAttendanceID() + " |" + a.getStudentName() + " " + a.getStudentSurname() + " |Present status: " + a.getIsPresent() + " |Date: " + a.getDate());
        }
    }

    private void addStudent() throws IOException {
            MentorDao mentorDao = new MentorDao();
            String newName = input.takeStringInput("Provide name of the new student: ");
            String newSurname = input.takeStringInput("Provide surname of the new student: ");
            int newPhone = input.takeIntegerInput("Provide phone number of new student: ");
            String newEmail = input.takeStringInput("Provide e-mail address of new student: ");
            String newPassword = input.takeStringInput("Provide his password: ");

            mentorDao.createStudentDetails(newName, newSurname, newPhone, newEmail, newPassword, "student");
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
