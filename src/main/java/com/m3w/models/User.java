package com.m3w.models;

import java.io.IOException;

public abstract class User {

    private final int id;
    private final int phone;
    private final String email;
    private final String password;
    private final String name;
    private final String surname;
    private final String userType;

    public User(int id, String name, String surname, int phone, String email, String password, String userType) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.userType = userType;
    }
    public int getId() {
        return id;
    }
    public int getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getSurname() {
        return surname;
    }
    public String getUserType(){
        return userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
    public abstract void displayMenuOptions() throws Exception;
}
