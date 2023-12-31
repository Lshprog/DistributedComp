package org.example.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Globals {
    public static AtomicBoolean bear_found = new AtomicBoolean(false);
    public static Semaphore semaphore = new Semaphore(3, true);

    public static Integer[][] woods = new Integer[16][16];

    static {
        for (Integer[] wood : woods) {
            Arrays.fill(wood, 0);
        }
    }

    public static ArrayList<Integer[]> area_queue = new ArrayList<>(64);

    public static Integer[] getFirst() {
        if (!area_queue.isEmpty()) {
            Integer[] arrToReturn = area_queue.get(0);
            area_queue.remove(0);
            return arrToReturn;
        }
        return null;
    }

    public static ReadWriteLock lock = new ReentrantReadWriteLock();


}
