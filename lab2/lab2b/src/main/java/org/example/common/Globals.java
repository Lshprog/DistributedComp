package org.example.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Globals {

    public static Double totalMoneyToBring = 2000.0;

    public static Double totalMoney = 0.0;

    public static BlockingQueue<Double> moneyToLoad = new ArrayBlockingQueue<>(40);

    public static BlockingQueue<Double> moneyToCalculate = new ArrayBlockingQueue<>(40);

}
