package org.example;

import org.example.common.Globals;
import org.example.common.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) throws InterruptedException {

        Globals.woods[1][2] = 1;

        for (int i = 0; i < 8; i += 2) {
            for (int j = 0; j < 8; j += 2) {
                Integer[] smallArea = new Integer[]{i, i + 1, j, j + 1};
                Globals.area_queue.add(smallArea);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (!Globals.bear_found.get() && !Globals.area_queue.isEmpty()) {
            executor.execute(new Task());
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