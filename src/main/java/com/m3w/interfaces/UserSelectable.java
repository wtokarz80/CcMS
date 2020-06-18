package com.m3w.interfaces;

import com.m3w.models.User;

import java.io.IOException;

public interface UserSelectable {

    User selectUser(String userEmail, String userPassword) throws IOException;

}
