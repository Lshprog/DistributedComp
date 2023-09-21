package org.example;

import org.example.common.Globals;
import org.example.common.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) throws InterruptedException {

        Globals.woods[1][2] = 1;

        Integer[] area1 = new Integer[]{0, 1, 0, 1};
        Integer[] area2 = new Integer[]{2, 3, 0, 1};
        Integer[] area3 = new Integer[]{0, 1, 2, 3};
        Integer[] area4 = new Integer[]{2, 3, 2, 3};

        try {
            Globals.area_queue.put(area1);
            Globals.area_queue.put(area2);
            Globals.area_queue.put(area3);
            Globals.area_queue.put(area4);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
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