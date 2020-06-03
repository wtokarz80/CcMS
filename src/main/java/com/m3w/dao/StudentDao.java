package com.m3w.dao;

import com.m3w.interfaces.SelectAll;
import com.m3w.interfaces.SubmitAssignment;
import com.m3w.models.Assignment;
import com.m3w.models.StudentEvaluation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends ConnectionToDB implements SelectAll, SubmitAssignment {

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
}