package com.m3w.models;

import com.m3w.controllers.MentorController;

import java.io.IOException;

public class Mentor extends User{
    public Mentor(int id, String name, String surname, int phone, String email, String password, String userType) {
        super(id, name, surname, phone, email, password, userType);
    }

    @Override
    public void displayMenuOptions() throws IOException {
        MentorController mentorController = new MentorController(this);
        mentorController.mentorMenu();
    }
}
