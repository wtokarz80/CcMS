package com.m3w.models;

public abstract class User {

    private int id;
    private int phone;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String userType;

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
    public String usertype(){
        return userType;
    }

}
