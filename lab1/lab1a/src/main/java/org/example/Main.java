package org.example;

import org.example.common.MyActionListener;
import org.example.common.MyChangeListener;
import org.example.common.MyRun;
import org.example.common.MyThread;
import org.example.ui.UI;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class Main {

    private static UI ui = new UI();

    public static void main(String[] args) {

        MyThread thread1 = new MyThread(new MyRun(1, ui), "Thread 1");
        MyThread thread2 = new MyThread(new MyRun(-1, ui), "Thread 2");

        ChangeListener changeListener1 = new MyChangeListener(thread1);
        ChangeListener changeListener2 = new MyChangeListener(thread2);

        ui.setjSpinner1ChangeListener(changeListener1);
        ui.setjSpinner2ChangeListener(changeListener2);

        ui.setUiVisible();

        ActionListener actionListener1 = new MyActionListener(thread1, thread2, '+');
        //ActionListener actionListener2 = new MyActionListener(thread1, thread2, '-');

        ui.setStartActionListener(actionListener1);

//        thread1.start();
//        thread2.start();


    }
}