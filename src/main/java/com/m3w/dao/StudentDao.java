package com.m3w.dao;

import com.m3w.interfaces.selectAll;
import com.m3w.models.Assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends ConnectionToDB implements selectAll {

    private  Assignment assignment;

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
}
