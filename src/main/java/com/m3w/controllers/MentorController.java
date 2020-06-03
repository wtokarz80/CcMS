package com.m3w.controllers;

import com.m3w.dao.MentorDao;
import com.m3w.models.Student;

import java.util.List;
import java.util.Scanner;

public class MentorController {


    Scanner input = new Scanner(System.in);

    public void mentorMenu() {
        boolean isRun = true;
        while (isRun) {
            // view.printMentorMenu
            int userChoice = input.nextInt();
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

    private void addAssignment() {
    }

    private void gradeAssignment() {
    }

    private void checkAttendance() {
    }

    private void addStudent() {
            MentorDao mentorDao = new MentorDao();
            System.out.println("Provide name of the new student: ");
            String newName = input.next();
            System.out.println("Provide surname of the new student: ");
            String newSurname = input.next();
            System.out.println("Provide phone number of new student: ");
            int newPhone = input.nextInt();
            System.out.println("Provide e-mail adress of new student: ");
            String newEmail = input.next();
            System.out.println("Provide his password: ");
            String newPassword = input.next();

            mentorDao.createStudent(newName, newSurname, newPhone, newEmail, newPassword, "student");
    }

   public void removeStudent() {
        MentorDao mentorDao = new MentorDao();
        getListOfStudents();
        System.out.println("Which student do You want to delete? (via E-mail) ");
        String email = input.next();
        mentorDao.deleteStudent(email);

    }

    private void updateStudentData() {
        MentorDao mentorDao = new MentorDao();
        getListOfStudents();
        System.out.println("Which student do You want to change details? ");
        String email = input.next();
        System.out.println("Which data do You want to change? " +
                "\n[1] Name" +
                "\n[2] Surname" +
                "\n[3] Phone number" +
                "\n[4] E-mail adress");

        boolean isRunning = true;
        while (isRunning){
        int userChoice = input.nextInt();
        switch(userChoice){
            case 1:
                System.out.println("Provide new name for the student: ");
                String newName = input.next();
                mentorDao.updateStudentDataString("name", newName, email);
                break;
            case 2:
                System.out.println("Provide new surname for the student: ");
                String newSurname = input.next();
                mentorDao.updateStudentDataString("surname", newSurname, email);
                break;
            case 3:
                System.out.println("Provide student's new phone number: ");
                int newPhone = input.nextInt();
                mentorDao.updateStudentDataInt("phone", newPhone, email);
                break;
            case 4:
                System.out.println("Provide student's new E-mail adress:  ");
                String newEmail = input.next();
                mentorDao.updateStudentDataString("email", newEmail, email);
                break;
            case 0:
                isRunning = false;
           }

        }

    }

}
