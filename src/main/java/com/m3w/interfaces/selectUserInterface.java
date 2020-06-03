package com.m3w.interfaces;

import com.m3w.models.User;

import java.io.IOException;

public interface selectUserInterface {

    public User selectUser(String userEmail, String userPassword) throws IOException;


}
