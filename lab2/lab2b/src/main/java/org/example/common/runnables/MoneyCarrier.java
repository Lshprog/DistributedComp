package org.example.common.runnables;

import org.example.common.Globals;

public class MoneyCarrier implements Runnable{

    @Override
    public void run() {

        Double oneTimeBring = 8.0;

        while (Globals.totalMoneyToBring > 0.0){

            if(Globals.totalMoneyToBring >= 8.0){
                Globals.totalMoneyToBring -= oneTimeBring;
            }
            else {
                oneTimeBring = Globals.totalMoneyToBring;
                Globals.totalMoneyToBring = 0.0;
            }

            System.out.println("Carrying some money to load station!");

            try {
                Globals.moneyToLoad.put(oneTimeBring);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            Globals.moneyToLoad.put(-1.0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}