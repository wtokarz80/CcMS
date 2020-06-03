package com.m3w.models;

import java.time.LocalDate;

public class StudentEvaluation {
   private int evaluationId;
   private int studentId;
   private int assignmentId;
   private String status;
   private String submission;
   private LocalDate date;
   private int mentorId;

    public StudentEvaluation(int evaluationId, int studentId, int assignmentId, String status, String submission, LocalDate date, int mentorId) {
        this.evaluationId = evaluationId;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.status = status;
        this.submission = submission;
        this.date = date;
        this.mentorId = mentorId;
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

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "studentEvaluation{" +
                "evaluationId=" + evaluationId +
                ", studentId=" + studentId +
                ", assignmentId=" + assignmentId +
                ", status='" + status + '\'' +
                ", submission='" + submission + '\'' +
                ", date=" + date +
                ", mentorId=" + mentorId +
                '}';
    }
}
