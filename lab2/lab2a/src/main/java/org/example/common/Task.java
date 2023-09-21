package org.example.common;

public class Task implements Runnable {

    @Override
    public void run() {
        if (Globals.bear_found.get() || Globals.area_queue.isEmpty()) {
            return; // Stop immediately
        }

        Integer[] area_to_check;
        try {
            area_to_check = Globals.area_queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted. Exiting.");
            return;
        }

        for (Integer i = area_to_check[0]; i <= area_to_check[1]; i++) {
            for (Integer j = area_to_check[2]; j <= area_to_check[3]; j++) {
                System.out.println(Thread.currentThread().getName() + " checking square: " + i + " " + j);
                if (Globals.woods[i][j] == 1) {
                    Globals.bear_found.set(true);
                    return;
                }
            }
        }
    }
}
