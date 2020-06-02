package com.m3w.models;

public enum UserType {
    STUDENT("student"), MANAGER("manager"), EMPLOYEE("employee"), MENTOR("mentor");

    private final String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
