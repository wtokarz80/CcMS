package com.m3w.interfaces;

import com.m3w.models.User;

import java.io.IOException;

public interface Selectable {

    User selectUser(String userEmail, String userPassword) throws IOException;

}
