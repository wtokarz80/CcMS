package com.m3w.models;

public class Attendance {
    private final int attendanceID;
    private final int studentID;
    private final int isPresent;
    private final String date;
    private final String studentName;
    private final String studentSurname;

    public int getAttendanceID() {
        return attendanceID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getIsPresent() {
        return isPresent;
    }

    public String getDate() {
        return date;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }


    public Attendance(int attendanceID, int studentID, String studentName, String studentSurname, int isPresent, String date){
        this.attendanceID = attendanceID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.isPresent = isPresent;
        this.date = date;
    }
}
