package com.m3w.view;

public class MenuPrinting {

    public void printMenu() {

        System.out.println("Main menu:\n\n"

                + "1 - log in\n"
                + "0 - EXIT\n");
    }


    public void printStudentMenu() {
        System.out.println("StudentMenu: \n"

                + "1 - View all assignments\n"
                + "2 - Submit an assignment\n"
                + "3 - View my grades\n"
                + "0 - Back to previous menu\n");
    }

    public void printMentorMenu() {
        System.out.println("MentorMenu: \n"

                + "1 - See a list of students\n"
                + "2 - Add an assignment\n"
                + "3 - Grade an assignment submitted by students\n"
                + "4 - Check attendance of students\n"
                + "5 - Add a student to a class\n"
                + "6 - Remove a student from class\n"
                + "7 - Edit student's data\n"
                + "8 - View student's attendance \n"
                + "0 - Back to previous menu\n");
    }

    public void printEmployeeMenu() {
        System.out.println("EmployeeMenu: \n"

                + "1 - See a list of students\n"
                + "0 - Back to previous menu\n");
    }

    public void printManagerMenu() {
        System.out.println("ManagerMenu: \n"

                + "1 - Add a mentor\n"
                + "2 - Remove a mentor\n"
                + "3 - Edit mentor's data\n"
                + "4 - See a list of mentors\n"
                + "5 - See a list of students\n"
                + "0 - Back to previous menu\n");
    }
}
