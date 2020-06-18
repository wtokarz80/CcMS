package com.m3w.controllers;

import com.m3w.dao.StudentDao;
import com.m3w.models.Assignment;
import com.m3w.models.Student;
import com.m3w.models.StudentEvaluation;
import com.m3w.services.InputProvider;
import com.m3w.view.DataPrinting;
import com.m3w.view.MenuPrinting;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentController {

    private final InputProvider inputProvider = new InputProvider();
    private final MenuPrinting menuPrinting = new MenuPrinting();
    private final DataPrinting dataPrinting = new DataPrinting();
    private final StudentDao studentDao = new StudentDao();
    private final Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    public void studentOptions() throws IOException {
        boolean isRunning  = true;
        while (isRunning) {
            dataPrinting.printLogInfo(student);
            menuPrinting.printStudentMenu();
            int userChoice = inputProvider.getNumberFromUser("What do you want to do right now?\n");
            dataPrinting.clearScreen();
            switch (userChoice) {
                case 1:
                    dataPrinting.printString("\nAll assignments\n");
                    viewAllAssignments();
                    break;
                case 2:
                    dataPrinting.printString("Submit an assignment");
                    submitAssignment();
                    break;
                case 3:
                    dataPrinting.printString("View my grades");
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
        List<StudentEvaluation> studentsEvaluations;
        studentsEvaluations = studentDao.viewStudentGrades(student.getId());
        dataPrinting.printString(studentsEvaluations.toString());
    }

    private void viewAllAssignments() {
        List<Assignment> assignments;
        assignments = studentDao.selectAllObjects();
        dataPrinting.printString(assignments.toString());
    }

    private void submitAssignment() throws IOException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringDate = date.format(formatter);
        int studentId = student.getId();
        int assignmentId = inputProvider.getNumberFromUser("Enter Id of assignment you want to submit: ");
        String submission = inputProvider.takeStringInput("Enter submission: ");
        studentDao.submitAssignment(studentId, assignmentId, submission, stringDate);
    }
}
