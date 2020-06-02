package com.m3w.controllers;

import com.m3w.dao.LoginDao;
import com.m3w.models.User;

import java.io.IOException;

public class Application {



    public static void main(String[] args) throws IOException {



        LoginDao loginDao = new LoginDao();
        User user = loginDao.selectUser("wt@wt.pl", "dupa");
        System.out.println(user.toString());

    }
}
