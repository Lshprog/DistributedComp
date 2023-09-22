package org.example;

import org.example.common.Globals;
import org.example.common.runnables.MoneyCarrier;
import org.example.common.runnables.MoneyCounter;
import org.example.common.runnables.MoneyLoader;

public class Main {
    public static void main(String[] args) {

        Thread moneyCarrier = new Thread(new MoneyCarrier());
        Thread moneyLoader = new Thread(new MoneyLoader());
        Thread moneyCounter = new Thread(new MoneyCounter());

        moneyCounter.start();
        moneyLoader.start();
        moneyCarrier.start();


    }
}