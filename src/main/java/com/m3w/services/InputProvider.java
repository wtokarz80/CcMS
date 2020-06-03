package com.m3w.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProvider {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int takeIntegerInput(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        return Integer.parseInt(reader.readLine());
    }

    public String takeStringInput(String messageForUser) throws IOException {
        System.out.print(messageForUser);
        return reader.readLine();
    }

}
