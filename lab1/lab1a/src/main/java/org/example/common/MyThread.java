package org.example.common;

public class MyThread extends Thread{
    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(Runnable target, String s) {
        super(target, s);
    }

}
