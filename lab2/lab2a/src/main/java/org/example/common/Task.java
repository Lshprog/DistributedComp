package org.example.common;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {

    private final Integer[] area_to_check;

    public Task(Integer[] area_to_check) {
        this.area_to_check = area_to_check;
    }

    @Override
    public void run() {
        try {
            for (Integer i = area_to_check[0]; i <= area_to_check[1]; i++) {
                for (Integer j = area_to_check[2]; j <= area_to_check[3]; j++) {
                    System.out.println(Thread.currentThread().getName() + " checking square: " + i + " " + j);

                    if (Globals.woods[i][j] == 1) {
                        Lock writeLock = Globals.lock.writeLock();
                        try {
                            writeLock.lock();
                            System.out.println("Before true");
                            Globals.bear_found.set(true);
                            System.out.println("Found bear!" + Thread.currentThread().getName());
                        } finally {
                            writeLock.unlock();
                        }
                        return;
                    }
                }
            }
        } finally {
            Globals.semaphore.release();
        }
    }
}

