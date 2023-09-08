package org.example.common;

public class MyThread extends Thread{

    private Runnable runnable;

    public MyThread(Runnable target, String s) {
        super(target, s);
        this.runnable = target;
    }

    public MyThread(Thread thread1) {
        super(thread1);
    }

    public Runnable getRunnable() {
        return this.runnable;
    }
}
