package com.m3w.controllers;

import com.m3w.dao.ManagerDAO;
import com.m3w.dao.MentorDAO;
import com.m3w.interfaces.IManagerDAO;
import com.m3w.interfaces.IMentorDAO;
import com.m3w.models.Manager;
import com.m3w.models.Mentor;
import com.m3w.models.Student;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

import java.io.IOException;
import java.util.List;


public class ManagerController {

    private MenuPrinter menu = new MenuPrinter();
    private InputProvider input = new InputProvider();
    private IManagerDAO managerDao = new ManagerDAO();
    private IMentorDAO mentorDao = new MentorDAO();
    private DataPrinter dataPrinter = new DataPrinter();
    private final Manager manager;
    private final String managerMenu = menu.printMentorMenu();

    public ManagerController(Manager manager) {
        this.manager = manager;
    }

    public void managerMenu() throws Exception {
        menu.printSpecificWindow(menu.printManagerMenu(), "                  ");
        boolean isRun = true;
        while (isRun) {
            dataPrinter.printLogInfo(manager);

            int userChoice = input.getNumberFromUser("Enter option: ");
            dataPrinter.clearScreen();
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
                    getListOfStudents();
                    break;
                case 0:
                    isRun = false;
                    break;
                default:
                    break;
            }
        }
    }


    public void getListOfStudents() {
        List<Student> students = mentorDao.selectAllObjects();
        String listOfStudents = dataPrinter.printUsers(students);
        menu.printSpecificWindow(managerMenu, listOfStudents);

    }
        private void addMentor () throws IOException {
            String newName = input.takeStringInput("Provide name of the new mentor: ");
            String newSurname = input.takeStringInput("Provide surname of the new mentor: ");
            int newPhone = input.getNumberFromUser("Provide phone number of new mentor: ");
            String newEmail = input.takeStringInput("Provide e-mail address of new mentor: ");
            String newPassword = input.takeStringInput("Provide his password: ");
            managerDao.createUserDetails(newName, newSurname, newPhone, newEmail, newPassword, "mentor");
        }


        public void removeMentor () throws IOException {
            getListOfMentors();
            String email = input.takeStringInput("Which mentor do You want to delete? (provide E-mail address): ");
            mentorDao.removeUser(email);

        }

        private void getListOfMentors () {
            List<Mentor> mentors = managerDao.selectAllObjects();
            for (Mentor s : mentors) {
                dataPrinter.printUser(s);
            }
        }
        private void updateMentorData () throws IOException {
            getListOfMentors();
            String email = input.takeStringInput("Which mentor do You want to change details? (provide E-mail address): ");
            menu.printSpecificWindow(managerMenu, menu.printUpdateUser());
            boolean isRunning = true;
            while (isRunning) {
                int userChoice = input.getNumberFromUser("Choose option:  ");
                switch (userChoice) {
                    case 1:
                        String newName = input.takeStringInput("Provide new name for the mentor: ");
                        managerDao.updateUserDataString("name", newName, email);
                        break;
                    case 2:
                        String newSurname = input.takeStringInput("Provide new surname for the mentor: ");
                        managerDao.updateUserDataString("surname", newSurname, email);
                        break;
                    case 3:
                        int newPhone = input.getNumberFromUser("Provide mentor's new phone number: ");
                        managerDao.updateUserDataInt("phone", newPhone, email);
                        break;
                    case 4:
                        String newEmail = input.takeStringInput("Provide mentor's new E-mail address:  ");
                        managerDao.updateUserDataString("email", newEmail, email);
                        break;
                    case 0:
                        isRunning = false;
                    default:
                        break;
                }

            }

        }
    }
