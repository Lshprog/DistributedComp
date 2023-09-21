package org.example;

import org.example.common.Globals;
import org.example.common.Task;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Globals.woods[5][0] = 1;

        for (int i = 0; i < 8; i += 2) {
            for (int j = 0; j < 8; j += 2) {
                Integer[] smallArea = new Integer[]{i, i + 1, j, j + 1};
                Globals.area_queue.add(smallArea);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Lock readLock = Globals.lock.readLock();

        while (true) {
            Future<Boolean> future;
            try {
                readLock.lock();
                if (!Globals.bear_found.get() && !Globals.area_queue.isEmpty()) {
                    Integer[] intTask = Globals.getFirst();
                    if (intTask != null) {
                        future = executor.submit(new Task(intTask));
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } finally {
                readLock.unlock();
            }

            try {
                future.get(); // Wait for the task to complete
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace(); // Handle exceptions if needed
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        if (Globals.bear_found.get()) {
            System.out.println("Bear found!");
        } else {
            System.out.println("Bear not found.");
        }
    }
}
