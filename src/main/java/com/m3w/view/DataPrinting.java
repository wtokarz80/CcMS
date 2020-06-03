package com.m3w.view;

public class DataPrinting {

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
