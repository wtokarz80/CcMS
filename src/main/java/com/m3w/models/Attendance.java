package com.m3w.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
//    private Map<LocalDate, Boolean> calendar = new HashMap<>();
//
//    public void addDailyAttendance(LocalDate date, boolean isPresent){
//        this.calendar.put(date, isPresent);
//    }
//
//    public Map<LocalDate, Boolean> getCalendar() {
//        return calendar;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Attendance:\n");
//        for (LocalDate key : calendar.keySet()){
//            builder.append(key.toString() + ": " + calendar.get(key).toString() + "\n");
//        }
//
//        return builder.toString();
//    }

    public Attendance(int attendanceID, int studentID, String studentName, String studentSurname, int isPresent, String date){
        this.attendanceID = attendanceID;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.isPresent = isPresent;
        this.date = date;
    }
}
