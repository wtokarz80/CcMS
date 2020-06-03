package com.m3w.controllers;

import com.m3w.dao.StudentDao;
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

            }
        }
    }

    private void getListOfStudents() {
        StudentDao studentdao = new StudentDao();
        List<Student> students = studentdao.getStudentsDetail();
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
             StudentDao studentdao = new StudentDao();
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

            studentdao.createStudent(newName, newSurname, newPhone, newEmail, newPassword, "student");
    }


    private void removeStudent() {
    }

    private void updateStudentData() {
    }


}
