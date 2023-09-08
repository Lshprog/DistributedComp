package org.example.common;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener {

    private final Thread thread;

    public MyChangeListener(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int priority = (int) ((JSpinner)e.getSource()).getValue();
        this.thread.setPriority(priority);
        System.out.println("Set priority " + priority + " to thread: " + thread.getName());

    }
}
