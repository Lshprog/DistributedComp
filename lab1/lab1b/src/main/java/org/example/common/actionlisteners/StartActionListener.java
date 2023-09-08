package org.example.common.actionlisteners;

import org.example.common.Globals;
import org.example.common.MyThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartActionListener implements ActionListener {

    private String mythreadname;

    private int priority;

    public StartActionListener(String mythreadname, int priority) {
        this.mythreadname = mythreadname;
        this.priority = priority;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(Globals.semaphore.get() == 0){

            MyThread myThread = Globals.sharedThreads.get(mythreadname);
            myThread = new MyThread(myThread.getRunnable(), myThread.getName());
            Globals.sharedThreads.put(myThread.getName(), myThread);
            myThread.start();
            myThread.setPriority(this.priority);

            Globals.semaphore.set(1);
            System.out.println("Займаємо");
        }
        else{
            System.out.println("Зайнято потоком");
        }

    }

}
