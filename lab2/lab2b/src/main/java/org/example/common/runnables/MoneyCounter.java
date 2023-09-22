package org.example.common.runnables;

import org.example.common.Globals;

public class MoneyCounter implements Runnable{

    @Override
    public void run() {

        while (true){

            double moneyToAdd = 0.0;

            try {

                moneyToAdd = 20 * Globals.moneyToCalculate.take();

                if(moneyToAdd < 0){
                    return;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Calculating money!");
            Globals.totalMoney += moneyToAdd;


        }

    }

}
