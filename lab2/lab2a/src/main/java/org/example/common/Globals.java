package org.example.common;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Globals {

    public static AtomicBoolean bear_found = new AtomicBoolean(false);

    public static Integer[][] woods = new Integer[4][4];

    static {
        for (Integer[] wood : woods) {
            Arrays.fill(wood, 0);
        }
    }

    public static BlockingQueue<Integer[]> area_queue = new ArrayBlockingQueue<>(4);

}
