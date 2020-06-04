package com.m3w.models;

import java.time.LocalDate;

public class StudentEvaluation {
   private int evaluationId;
   private int studentId;
   private String assignmentName;
   private String status;
   private String submission;
   private String date;
   private String mentorName;
   private String mentorSurname;

    public StudentEvaluation(int evaluationId, int studentId, String assignmentName, String status, String submission,
                             String date, String mentorName, String mentorSurname) {
        this.evaluationId = evaluationId;
        this.studentId = studentId;
        this.assignmentName = assignmentName;
        this.status = status;
        this.submission = submission;
        this.date = date;
        this.mentorName = mentorName;
        this.mentorSurname = mentorSurname;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMentorName() {
        return mentorName;
    }

    public String getMentorSurname() {
        return mentorSurname;
    }



    @Override
    public String toString() {
        return "\nevaluationId: " + evaluationId + "\n" +
                ", studentId: " + studentId +"\n" +
                ", assignmentName: " + assignmentName +"\n" +
                ", status: " + status + '\'' +"\n" +
                ", submission: " + submission + '\'' +"\n" +
                ", date of submission: " + date +"\n" +
                ", mentorName: " + mentorName +"\n" +
                ", mentorSurname: " + mentorSurname +"\n" +
                '}';
    }
}
