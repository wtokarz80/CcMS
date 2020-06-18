package com.m3w.view;

import com.jakewharton.fliptables.FlipTable;

public class MenuPrinting {

    public void printMenu() {
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "log in" },
                { "0", "EXIT" },
        };
        System.out.println(FlipTable.of(headers, data));
    }


    public void printStudentMenu() {
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "View all assignments" },
                { "2", "Submit an assignment" },
                { "3", "View my grades" },
                { "0", "Back to previous menu" },
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void printMentorMenu() {
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "See a list of students" },
                { "2", "Add an assignment" },
                { "3", "Grade an assignment submitted by students" },
                { "4", "Check attendance of students" },
                { "5", "Add a student to a class" },
                { "6", "Remove a student from class" },
                { "7", "Edit student's data" },
                { "8", "View student's attendance" },
                { "0", "Back to previous menu" },
        };
        System.out.println(FlipTable.of(headers, data));

    }

    public void printEmployeeMenu() {
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "See a list of students" },
                { "0", "Back to previous menu" },
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void printManagerMenu() {
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "Add a mentor" },
                { "2", "Remove a mentor" },
                { "3", "Edit mentor's data" },
                { "4", "See a list of mentors" },
                { "5", "See a list of students" },
                { "0", "Back to previous menu" },
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void printUpdateMentor(){
        String[] headers = { "Number", "Option" };
        String[][] data = {
                { "1", "Name" },
                { "2", "Surname" },
                { "3", "Phone number" },
                { "4", "E-mail address" },
        };
        System.out.println(FlipTable.of(headers, data));
    }
}