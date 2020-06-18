package com.m3w.dao;

import com.m3w.interfaces.IEmployeeDAO;
import com.m3w.models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends ConnectionToDB implements IEmployeeDAO {


    @Override
    public List<Student> selectAllObjects() {
        connect();
        List<Student> students = new ArrayList<>();
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
}

