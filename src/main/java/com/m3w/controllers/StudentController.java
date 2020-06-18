package com.m3w.controllers;

import com.m3w.dao.StudentDAO;
import com.m3w.interfaces.IStudentDAO;
import com.m3w.models.Assignment;
import com.m3w.models.Student;
import com.m3w.models.StudentEvaluation;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentController {

    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinter menuPrinter = new MenuPrinter();
    private final DataPrinter dataPrinter = new DataPrinter();
    private final IStudentDAO studentDao = new StudentDAO();
    private final Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    public void studentOptions() throws IOException {
        dataPrinter.printLogInfo(student);
        menuPrinter.printSpecificWindow(menuPrinter.printStudentMenu(), "                            ");
        boolean isRunning  = true;
        while (isRunning) {
            int userChoice = inputProvider.getNumberFromUser("What do you want to do right now?\n");
            dataPrinter.clearScreen();
            switch (userChoice) {
                case 1:
                    dataPrinter.printString("\nAll assignments\n");
                    viewAllAssignments();
                    break;
                case 2:
                    dataPrinter.printString("Submit an assignment");
                    submitAssignment();
                    break;
                case 3:
                    dataPrinter.printString("View my grades");
                    viewGrades();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void viewGrades() {
        List<StudentEvaluation> studentsEvaluations = studentDao.viewById(student.getId());
        menuPrinter.printSpecificWindow(menuPrinter.printStudentMenu(), dataPrinter.viewGrades(studentsEvaluations));
    }

    private void viewAllAssignments() {
        List<Assignment> assignments = studentDao.selectAllObjects();
        menuPrinter.printSpecificWindow(menuPrinter.printStudentMenu(), dataPrinter.printAssigments(assignments));
    }

        private void submitAssignment () throws IOException {
            viewAllAssignments();
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String stringDate = date.format(formatter);
            int studentId = student.getId();
            int assignmentId = inputProvider.getNumberFromUser("Enter Id of assignment you want to submit: ");
            String submission = inputProvider.takeStringInput("Enter submission: ");
            studentDao.submitAssignment(studentId, assignmentId, submission, stringDate);

        }

    }
