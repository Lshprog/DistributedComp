package org.example.common;

import org.example.ui.UI;

import javax.swing.*;

public class MyRun implements Runnable{

    private int changeval;

    public MyRun(int changeval) {
        this.changeval = changeval;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            Globals.ui.updateSliderValue(changeval);
        }
    }

}
