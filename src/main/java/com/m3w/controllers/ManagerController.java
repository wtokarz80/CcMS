package com.m3w.controllers;

import com.m3w.dao.ManagerDao;
import com.m3w.dao.MentorDao;
import com.m3w.models.Mentor;
import com.m3w.services.InputProvider;
import com.m3w.view.MenuPrinting;
import java.lang.reflect.Method;

import java.io.IOException;
import java.util.List;


public class ManagerController {

    MenuPrinting menu = new MenuPrinting();
    InputProvider input = new InputProvider();

    public void managerMenu() throws Exception {

        boolean isRun = true;
        while (isRun) {
            menu.printManagerMenu();
            int userChoice = input.takeIntegerInput("");
            switch (userChoice) {
                case 1:
                    addMentor();
                    break;
                case 2:
                    removeMentor();
                    break;
                case 3:
                    updateMentorData();
                    break;
                case 4:
                    getListOfMentors();
                    break;
                case 5:
                    MentorController mentorController = new MentorController();
                    mentorController.getListOfStudents();
                    break;


            }
        }
    }


        private void addMentor() throws IOException {
            ManagerDao managerDao = new ManagerDao();
            String newName = input.takeStringInput("Provide name of the new student: ");
            String newSurname = input.takeStringInput("Provide surname of the new student: ");
            int newPhone = input.takeIntegerInput("Provide phone number of new student: ");
            String newEmail = input.takeStringInput("Provide e-mail address of new student: ");
            String newPassword = input.takeStringInput("Provide his password: ");

            managerDao.createMentor(newName, newSurname, newPhone, newEmail, newPassword, "mentor");
        }
    public void removeMentor() throws IOException {
        MentorDao mentorDao = new MentorDao();
        getListOfMentors();
        String email = input.takeStringInput("Which mentor do You want to delete? (provide E-mail address)");
        mentorDao.deleteStudent(email);

    }

    private void getListOfMentors() {
        ManagerDao managerDao = new ManagerDao();
        List<Mentor> mentors = managerDao.getMentorDetail();
        for (Mentor s: mentors){
            System.out.println("[" + s.getId() +"]  "+ s.getName() +" "+ s.getSurname()  + "  |Phone number: " + s.getPhone() + " |E-mail: " + s.getEmail());
        }
    }
    private void updateMentorData() throws IOException {
        ManagerDao managerDao = new ManagerDao();
        getListOfMentors();
        String email = input.takeStringInput("Which mentor do You want to change details? (provide E-mail address) ");
        System.out.println("Which data do You want to change? " +
                "\n[1] Name" +
                "\n[2] Surname" +
                "\n[3] Phone number" +
                "\n[4] E-mail address");

        boolean isRunning = true;
        while (isRunning){
            int userChoice = input.takeIntegerInput("press '0' to exit: ");
            switch(userChoice){
                case 1:
                    String newName = input.takeStringInput("Provide new name for the student: ");
                    managerDao.updateMentorDataString("name", newName, email);
                    break;
                case 2:
                    String newSurname = input.takeStringInput("Provide new surname for the student: ");
                    managerDao.updateMentorDataString("surname", newSurname, email);
                    break;
                case 3:
                    int newPhone = input.takeIntegerInput("Provide student's new phone number: ");
                    managerDao.updateMentorDataInt("phone", newPhone, email);
                    break;
                case 4:
                    String newEmail = input.takeStringInput("Provide student's new E-mail address:  ");
                    managerDao.updateMentorDataString("email", newEmail, email);
                    break;
                case 0:
                    isRunning = false;
            }

        }

    }
}
