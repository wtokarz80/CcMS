package com.m3w.models;

public class Assignment {
    private int id;
    private String name;
    private int grade;
    private boolean submission;

    public Assignment(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSubmission() {
        return submission;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubmission(boolean submission) {
        this.submission = submission;
    }
}