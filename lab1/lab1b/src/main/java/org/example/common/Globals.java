package org.example.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Globals {

    public static final AtomicInteger semaphore = new AtomicInteger(0);

    public static Map<String, MyThread> sharedThreads = new HashMap<>();

}
