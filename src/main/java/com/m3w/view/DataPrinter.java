package com.m3w.view;

import com.jakewharton.fliptables.FlipTableConverters;
import com.m3w.models.*;

import java.util.List;

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

    public String printUsers(List<Student> students) {
        StringBuilder ids = new StringBuilder();
        StringBuilder names = new StringBuilder();
        StringBuilder phoneNums = new StringBuilder();
        StringBuilder emails = new StringBuilder();

        for (Student s: students){
            ids.append(s.getId() + "\n");
            names.append(s.getName() + " " + s.getSurname() + "\n");
            phoneNums.append(s.getPhone()+"\n");
            emails.append(s.getEmail() + "\n");

        }

        String[] headers = { "ID", "Name", "Phone Number", "Email" };
        Object[][] data = {
                { ids, names, phoneNums, emails },
        };
        return FlipTableConverters.fromObjects(headers, data);
    }

    public String printAllAttendance(List<Attendance> attendances) {
        StringBuilder ids = new StringBuilder();
        StringBuilder names = new StringBuilder();
        StringBuilder attendance = new StringBuilder();
        StringBuilder dates = new StringBuilder();
         for (Attendance a: attendances){
             ids.append(a.getAttendanceID() + "\n");
             names.append(a.getStudentName() + " " + a.getStudentSurname() + "\n");
             attendance.append(a.getIsPresent() + "\n");
             dates.append(a.getDate() + "\n");
         }
        String[] headers = { "ID", "Name", "Attendance Status", "Date" };
        Object[][] data = {
                { ids, names, attendance, dates },
        };
        return FlipTableConverters.fromObjects(headers, data);
    }

    public String printAssigments(List<Assignment> assignments){
        StringBuilder ids = new StringBuilder();
        StringBuilder names = new StringBuilder();
        StringBuilder decriptions = new StringBuilder();
        for (Assignment a: assignments){
            ids.append(a.getId() + "\n");
            names.append(a.getName() + "\n");
            decriptions.append(a.getDescription() + "\n");
        }
        String[] headers = { "ID", "Name", "Description"};
        Object[][] data = {
                { ids, names, decriptions},
        };
        return FlipTableConverters.fromObjects(headers, data);
    }

    public String viewGrades(List<StudentEvaluation> grades){
        StringBuilder evalID = new StringBuilder();
        StringBuilder studID = new StringBuilder();
        StringBuilder subission = new StringBuilder();
        StringBuilder status = new StringBuilder();
        StringBuilder date = new StringBuilder();
        StringBuilder mentorName = new StringBuilder();
        for (StudentEvaluation e: grades){
            evalID.append(e.getEvaluationId() + "\n");
            studID.append(e.getStudentId() + "\n");
            subission.append(e.getSubmission() + "\n");
            status.append(e.getStatus() + "\n");
            date.append(e.getDate() + "\n");
            mentorName.append(e.getMentorName() + " " + e.getMentorSurname() + "\n");

        }
        String[] headers = { "ID", "Student ID", "Description", "Status", "Date", "Mentor"};
        Object[][] data = {
                { evalID, studID, subission, status, date, mentorName},
        };
        return FlipTableConverters.fromObjects(headers, data);
    }
}
