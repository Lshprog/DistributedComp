package org.example.common.runnables;

import org.example.common.Globals;

public class MoneyLoader implements Runnable{

    @Override
    public void run() {

        while (true){

            double moneyToLoad = 0.0;

            try {
                moneyToLoad = Globals.moneyToLoad.take();
                if(moneyToLoad < 0){
                    Globals.moneyToCalculate.put(-1.0);
                    return;
                }

                System.out.println("Loading money!");
                Globals.moneyToCalculate.put(moneyToLoad);


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

}