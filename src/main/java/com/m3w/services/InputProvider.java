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


    private String readNextLine(BufferedReader in) throws IOException{
        return in.readLine();
    }

    private int convertStringToInt(String valueString) throws NumberFormatException {
        return Integer.parseInt(valueString);
    }
    public int getNumberFromUser(String title) {
        while (true) { // we end the loop by a return, not by a condition.
            System.out.println(title);
            try {
                String valueString = readNextLine(reader);
                // return leaves the method and therefor the loop too.
                return convertStringToInt(valueString);
                // this method will not return
                // and the loop will not end if convertStringToInt() throws an
                // exception!
            } catch (IOException ex) {
                System.err.println("could not acquire next line from system input: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                System.err.println("could not convert input string: " + ex.getMessage());
            }
        }
    }

}
