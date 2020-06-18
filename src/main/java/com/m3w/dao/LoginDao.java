package com.m3w.dao;

import com.m3w.models.User;
import com.m3w.models.UserFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.m3w.interfaces.*;


public class LoginDao extends ConnectionToDB implements UserSelectable {

    private final UserFactory userFactory = new UserFactory();

    @Override
    public User selectUser(String userEmail, String userPassword) {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( String.format("SELECT * FROM user_details WHERE email='%s'AND password='%s' ;", userEmail, userPassword) );
            while ( rs.next() ) {
                int id = rs.getInt("user_details_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String userType = rs.getString("user_type");

                if(email != null & password != null){
                    return userFactory.createUser(id, name, surname, phone, email, password, userType);
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
