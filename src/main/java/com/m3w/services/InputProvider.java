package com.m3w.services;

public class InputProvider {

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
