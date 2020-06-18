package com.m3w.dao;

import com.m3w.interfaces.IManagerDAO;
import com.m3w.models.Mentor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO extends ConnectionToDB implements IManagerDAO {

    @Override
    public List<Mentor> selectAllObjects() {

        List<Mentor> mentors = new ArrayList<>();

        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM user_details WHERE user_type = 'mentor';");
            while (results.next()) {
                int userDetailsID = results.getInt("user_details_id");
                String name = results.getString("name");
                String surname = results.getString("surname");
                int phone = results.getInt("phone");
                String email = results.getString("email");
                String password = results.getString("password");
                String userType = results.getString("user_type");

                Mentor mentor = new Mentor(userDetailsID, name, surname, phone, email, password, userType);
                mentors.add(mentor);
            }
            results.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    @Override
    public void createUserDetails(String name, String surname, int phone, String email, String password, String userType) {

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

    @Override
    public void updateUserDataInt(String data, int futureData, String email) {
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

    @Override
    public void updateUserDataString(String data, String futureData, String email) {
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
}
