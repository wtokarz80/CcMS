package com.m3w.view;

import com.m3w.models.Attendance;
import com.m3w.models.Student;
import com.m3w.models.User;

public class DataPrinter {

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printString(String title){
        System.out.println(title);
    }

    public void printUser(User user) {
        System.out.println("[" + user.getId() +"]  "+ user.getName() +" "+ user.getSurname()  +
                "  |Phone number: " + user.getPhone() + " |E-mail: " + user.getEmail());

    }

    public void printLogInfo(User user){
        System.out.println();
        System.out.printf("Logged as: %s %s %s\n",user.getClass().getSimpleName(), user.getName(), user.getSurname());
    }

    public void printAttendance(Attendance attendance) {
        System.out.println(attendance.getAttendanceID() + " |" + attendance.getStudentName() + " " + attendance.getStudentSurname() +
                " |Present status: " + attendance.getIsPresent() + " |Date: " + attendance.getDate());

    }
}
