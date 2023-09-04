package org.example;

import org.example.common.MyChangeListener;
import org.example.common.MyRun;
import org.example.common.MyThread;
import org.example.ui.UI;

import javax.swing.event.ChangeListener;

public class Main {
    public static void main(String[] args) {

        UI ui = new UI();

        MyThread thread1 = new MyThread(new MyRun(1, ui));
        MyThread thread2 = new MyThread(new MyRun(-1, ui));

        ChangeListener changeListener1 = new MyChangeListener(thread1);
        ChangeListener changeListener2 = new MyChangeListener(thread2);

        ui.setjSpinner1ChangeListener(changeListener1);
        ui.setjSpinner2ChangeListener(changeListener2);

        ui.setUiVisible();

        thread1.start();
        thread2.start();


    }
}