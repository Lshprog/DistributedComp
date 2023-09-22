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
        for (Integer i = area_to_check[0]; i <= area_to_check[1]; i++) {
            for (Integer j = area_to_check[2]; j <= area_to_check[3]; j++) {
                System.out.println(Thread.currentThread().getName() + " checking square: " + i + " " + j);
//                System.out.println(Globals.bear_found.get());
                if (Globals.woods[i][j] == 1) {
                    Lock writeLock = Globals.lock.writeLock();
                    try {
                        writeLock.lock();
                        Globals.bear_found.set(true);
                    } finally {
                        writeLock.unlock();
                    }
                    Globals.availableThreadCount.incrementAndGet();
                    return;
                }
            }
        }

        Globals.availableThreadCount.incrementAndGet();

    }
}
