package com.m3w.services;

import com.m3w.view.DataPrinter;
import com.m3w.view.MenuPrinter;

public class ToolsCreator {
    private InputProvider inputProvider = new InputProvider();
    private DataPrinter dataPrinter = new DataPrinter();
    private MenuPrinter menuPrinter = new MenuPrinter();

    public InputProvider getInputProvider() {
        return inputProvider;
    }

    public DataPrinter getDataPrinter() {
        return dataPrinter;
    }

    public MenuPrinter getMenuPrinter() {
        return menuPrinter;
    }
}
