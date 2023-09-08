package org.example;

import org.example.common.Globals;
import org.example.common.actionlisteners.StartActionListener;
import org.example.common.actionlisteners.StopActionListener;
import org.example.common.MyRun;
import org.example.common.MyThread;
import org.example.ui.UI;

import java.awt.event.ActionListener;

public class Main {

    private static final UI ui = new UI();

    public static void main(String[] args) {

        MyThread thread1 = new MyThread(new MyRun(10, ui), "Thread 1");
        MyThread thread2 = new MyThread(new MyRun(90, ui), "Thread 2");
        Globals.sharedThreads.put(thread1.getName(), thread1);
        Globals.sharedThreads.put(thread2.getName(), thread2);

        ui.setUiVisible();

        ActionListener actionListener1start = new StartActionListener(thread1.getName(), 1);
        ActionListener actionListener2start = new StartActionListener(thread2.getName(), 10);
        ActionListener actionListener1stop = new StopActionListener(thread1.getName());
        ActionListener actionListener2stop = new StopActionListener(thread2.getName());

        ui.setStartActionListenerStart1(actionListener1start);
        ui.setStartActionListenerStart2(actionListener2start);
        ui.setStartActionListenerStop1(actionListener1stop);
        ui.setStartActionListenerStop2(actionListener2stop);

    }
}