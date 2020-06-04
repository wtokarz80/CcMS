package com.m3w.controllers;

import com.m3w.models.Mentor;

public class Application {

    public static void main(String[] args) throws Exception {
//        MenuController menuController = new MenuController();
//        menuController.mainMenu();
        Mentor mentor = new Mentor(1,"Dominik", "Starzyk",1221131, "domi@sta.pl", "asdf", "mentor");
        MentorController mentorControl = new MentorController(mentor);
        mentorControl.mentorMenu();
    }
}
