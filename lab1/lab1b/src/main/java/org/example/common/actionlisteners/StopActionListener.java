package org.example.common.actionlisteners;

import org.example.common.Globals;
import org.example.common.MyThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopActionListener implements ActionListener {

    private String mythreadname;

    public StopActionListener(String mythreadname) {
        this.mythreadname = mythreadname;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyThread mythread = Globals.sharedThreads.get(mythreadname);

        if(Globals.semaphore.get() == 1 && mythread.isAlive()){
            mythread.interrupt();
            Globals.semaphore.set(0);
            System.out.println("Звільняємо");
        }
        else if(Globals.semaphore.get() == 0){
            System.out.println("І так зупинено");
        }
        else{
            System.out.println("Зайнято потоком іншим потоком");
        }

    }
}
