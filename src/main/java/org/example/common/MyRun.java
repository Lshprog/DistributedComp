package org.example.common;

import org.example.ui.UI;

import javax.swing.*;

public class MyRun implements Runnable{

    private int changeval;

    private final UI ui;

    public MyRun(int changeval, UI ui) {
        this.changeval = changeval;
        this.ui = ui;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){

            this.ui.setSliderValue(this.ui.getSliderValue() + changeval);

//           System.out.println("Working on " + Thread.currentThread().getName());
//
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
