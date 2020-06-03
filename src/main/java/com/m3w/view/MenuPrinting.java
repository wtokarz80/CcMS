package com.m3w.view;

public class MenuPrinting {

    public void printMenu() {

        System.out.println("Main menu:\n\n"

                + "1 - log in\n"
                + "2 - registration\n"
                + "0 - EXIT\n");

    }

    public void printStudentMenu() {
        System.out.println("StudetMenu: \n"

                + "1 - Submit an assignment\n"
                + "2 - view my grades\n"
                + "0 - Back to previous menu\n");
    }

    public void printMentorMenu() {
        System.out.println("MentorMenu: \n"

                + "1 - See a list of students\n"
                + "2 - view my grades\n"
                + "0 - Back to previous menu\n");
    }


}
