package org.example.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private Thread trhead1;

    private Thread trhead2;

    private char command;

    public MyActionListener(Thread trhead1, Thread trhead2, char command) {
        this.trhead1 = trhead1;
        this.trhead2 = trhead2;
        this.command = command;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(Character.compare(command, '+') == 0 && !this.trhead1.isAlive()){
            this.trhead1.start();
            this.trhead2.start();
        }

    }
}
