package com.m3w.dao;

import com.m3w.interfaces.IMentorDAO;
import com.m3w.models.Attendance;
import com.m3w.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorDao extends ConnectionToDB implements IMentorDAO {

    public List<Student> selectAllUsers() {
        List<Student> students = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM user_details WHERE user_type = 'student';");
            while (results.next()) {
                int userDetailsID = results.getInt("user_details_id");
                String name = results.getString("name");
                String surname = results.getString("surname");
                int phone = results.getInt("phone");
                String email = results.getString("email");
                String password = results.getString("password");
                String userType = results.getString("user_type");

                Student student = new Student(userDetailsID, name, surname, phone, email, password, userType);
                students.add(student);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void createStudentDetails(String name, String surname, int phone, String email, String password, String userType) {
        connect();

        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO user_details (name, surname, phone, email, password, user_type)" +
                    String.format("VALUES ('%s', '%s', '%d', '%s', '%s', '%s')", name, surname, phone, email, password, userType));
            statement.close();
            connection.commit();


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(String email){
        connect();
        try{
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format("DELETE FROM user_details WHERE email = '%s'", email));
            statement.close();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStudentDataInt(String data, int futureData, String email) {
        connect();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format("UPDATE user_details SET %s = '%d' WHERE email = '%s'", data, futureData, email));
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentDataString(String data, String futureData, String email) {
        connect();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format("UPDATE user_details SET %s = '%s' WHERE email = '%s'", data, futureData, email));
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAssignment(String newAssignment, String description) {
        connect();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO assignment (assignment_name, description)" +
                    String.format("VALUES ('%s', '%s')", newAssignment, description));
            statement.close();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void evaluateStudent(int evaluationID, int mentorID, String status){
        connect();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format("UPDATE student_evaluation SET mentor_id = '%d', status = '%s' WHERE evaluation_id = '%s'", mentorID, status, evaluationID));
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillAttendance(int studentID, int isPresent, String date) {
        connect();
        try {
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO attendance (user_id, is_present, date)" +
                    String.format("VALUES (%d, '%d', '%s')",studentID, isPresent, date));
            statement.close();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Attendance> viewListStudentAttendance(int chosenStudentID) {
        List<Attendance> getAttendance = new ArrayList<>();
            connect();
            try {
                ResultSet result = statement.executeQuery(String.format("SELECT * FROM attendance JOIN user_details ON attendance.user_id = user_details.user_details_id WHERE user_details_id = '%d'", chosenStudentID));
                while (result.next()) {
                    String name = result.getString("name");
                    String surname = result.getString("surname");
                    int attendanceID = result.getInt("attendance_id");
                    int studentID = result.getInt("user_id");
                    int isPresent = result.getInt("is_present");
                    String date = result.getString("date");
                    Attendance attendance = new Attendance(attendanceID, studentID, name, surname, isPresent, date);
                    getAttendance.add(attendance);
                }
                result.close();
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        return getAttendance;
    }
}
