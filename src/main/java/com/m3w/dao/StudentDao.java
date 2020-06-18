package com.m3w.dao;

import com.m3w.interfaces.IStudentDAO;
import com.m3w.models.Assignment;
import com.m3w.models.StudentEvaluation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends ConnectionToDB implements IStudentDAO {

    private Assignment assignment;
    private StudentEvaluation studentEvaluation;

    @Override
    public List<Assignment> selectAllObjects() {

        List<Assignment> assignments = new ArrayList<>();
        connect();
        try{
            ResultSet rs = statement.executeQuery( "SELECT * FROM assignment;" );
            while ( rs.next() ) {
                int id = rs.getInt("assignment_id");
                String  name = rs.getString("assignment_name");
                String description = rs.getString("description");
                assignment = new Assignment(id, name, description);
                assignments.add(assignment);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }


    @Override
    public void submitAssignment(int studentId, int assignmentId, String submission, String date) {
        try {
            connect();
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO student_evaluation (student_id, assignment_id, submission, date)" +
                    String.format("VALUES ('%d', '%d', '%s', '%s')", studentId, assignmentId, submission, date));
            statement.close();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<StudentEvaluation> viewStudentGrades(int studentDetailId) {
        List<StudentEvaluation> studentEvaluations = new ArrayList<>();
        connect();
        try{
            ResultSet rs = statement.executeQuery( String.format("SELECT student_evaluation.evaluation_id, student_evaluation.student_id," +
                    " assignment.assignment_name, student_evaluation.status, student_evaluation.submission, student_evaluation.date," +
                    " user_details.name, user_details.surname\n" +
                    "FROM student_evaluation\n" +
                    "INNER JOIN assignment ON student_evaluation.assignment_id = assignment.assignment_id\n" +
                    "INNER JOIN user_details ON student_evaluation.mentor_id = user_details.user_details_id\n" +
                    "WHERE student_evaluation.student_id = %d;", studentDetailId) );
            while ( rs.next() ) {
                int evaluation_id = rs.getInt("evaluation_id");
                int studentId = rs.getInt("student_id");
                String assignmentName = rs.getString("assignment_name");
                String status = rs.getString("status");
                String submission = rs.getString("submission");
                String date = rs.getString("date");
                String mentorName = rs.getString("name");
                String mentorSurname = rs.getString("surname");
                studentEvaluation = new StudentEvaluation(evaluation_id, studentId, assignmentName, status, submission, date, mentorName, mentorSurname);
                studentEvaluations.add(studentEvaluation);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentEvaluations;
    }
}