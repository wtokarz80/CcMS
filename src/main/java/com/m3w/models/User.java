package com.m3w.models;

public abstract class User {

    private int id;
    private int phone;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String usertype;

    public User(int id, int phone, String email, String password, String name, String surname, String usertype) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.usertype = usertype;
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
        return usertype;
    }

}
