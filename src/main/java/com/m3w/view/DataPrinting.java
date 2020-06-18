package com.m3w.view;

import com.m3w.models.Student;
import com.m3w.models.User;

public class DataPrinting {

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printString(String title){
        System.out.println(title);
    }

    public void printUser(User user) {
        System.out.println("[" + user.getId() +"]  "+ user.getName() +" "+ user.getSurname()  +
                "  |Phone number: " + user.getPhone() + " |E-mail: " + user.getEmail());

    }

    public void printUserName(User user){
        System.out.println();
        System.out.printf("Logged as: %s %s %s\n",user.getClass().getSimpleName(), user.getName(), user.getSurname());
    }
}
