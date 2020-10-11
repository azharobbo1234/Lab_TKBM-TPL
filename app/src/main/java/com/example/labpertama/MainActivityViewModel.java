package com.example.labpertama;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int selectedConsole = 0;
    private Console[] consoleArr = new Console[3];
    public MainActivityViewModel() {
        consoleArr[0] = new Console("Playstation 5", "Brand new Playstation 5", "Rp 2.000");
        consoleArr[1] = new Console("Xbox Series X", "Brand new Xbox Series X", "Rp 3.000");
        consoleArr[2] = new Console("Nintendo Switch", "Brand new Nintendo Switch", "Rp.4000");
    }
    public Console getSelectedConsole() {
        return consoleArr[this.selectedConsole];
    }
    public void setConsole(int index) {
        this.selectedConsole = index;
    }
}
