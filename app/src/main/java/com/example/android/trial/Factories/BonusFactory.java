package com.example.android.trial.Factories;

import android.util.Log;

import com.example.android.trial.Fruits.Fruits;
import com.example.android.trial.Gui.Bonus;

public class BonusFactory {
    Bonus bonus;
    int decreaseFirstMove;
    boolean decreaseBool;

    public BonusFactory(Bonus bonus) {
        this.bonus = bonus;
        decreaseBool = bonus.isDecreaseBool();
        decreaseFirstMove=bonus.getDecreaseFirstMove();
    }




    public void sliceUpdate(Fruits f, int move, int x){


    }






    public void updateFirstFruit(){
        if (bonus.isF1b()) {

                if (bonus.getF1().isFruitRight())
                    bonus.getF1().setDimX(bonus.getF1().getDimX() + 35);
                else
                    bonus.getF1().setDimX(bonus.getF1().getDimX() - 35);

            }

    }



    public void updateSecondFruit(){
        if (bonus.isF2b()) {

                if (bonus.getF2().isFruitRight())
                    bonus.getF2().setDimX(bonus.getF2().getDimX() + 35);
                else
                    bonus.getF2().setDimX(bonus.getF2().getDimX() - 35);

            }

    }


    public void updateThirdFruit(){
        if (bonus.isF3b()) {


                if (bonus.getF3().isFruitRight())
                    bonus.getF3().setDimX(bonus.getF3().getDimX() + 35);
                else
                    bonus.getF3().setDimX(bonus.getF3().getDimX() - 35);



        }
    }






    public void updateFourthFruit(){
        if (bonus.isF4b()) {


                if (bonus.getF4().isFruitRight())
                    bonus.getF4().setDimX(bonus.getF4().getDimX() + 35);
                else
                    bonus.getF4().setDimX(bonus.getF4().getDimX() - 35);



        }
    }



    public void updateFifthFruit(){
        if (bonus.isF5b()) {




                if (bonus.getF5().isFruitRight())
                    bonus.getF5().setDimX(bonus.getF5().getDimX() + 35);
                else
                    bonus.getF5().setDimX(bonus.getF5().getDimX() - 35);



        }
    }












    public void updateV1Fruit(){
        if (bonus.isV1b()) {

                if (bonus.getV1().isFruitUp())
                    bonus.getV1().setDimY(bonus.getV1().getDimY() - 45);
                else {
                    bonus.getV1().setDimY(bonus.getV1().getDimY() + 45);
                }
            }

    }



    public void updateV2Fruit(){
        if (bonus.isV2b()) {

            if (bonus.getV2().isFruitUp())
                bonus.getV2().setDimY(bonus.getV2().getDimY() - 45);
            else {
                bonus.getV2().setDimY(bonus.getV2().getDimY() + 45);
            }
        }

    }



    public void updateV3Fruit(){
        if (bonus.isV3b()) {

            if (bonus.getV3().isFruitUp())
                bonus.getV3().setDimY(bonus.getV3().getDimY() - 45);
            else {
                bonus.getV3().setDimY(bonus.getV3().getDimY() + 45);
            }
        }

    }


    public void updateV4Fruit(){
        if (bonus.isV4b()) {

            if (bonus.getV4().isFruitUp())
                bonus.getV4().setDimY(bonus.getV4().getDimY() - 45);
            else {
                bonus.getV4().setDimY(bonus.getV4().getDimY() + 45);
            }
        }

    }



    public void updateV5Fruit(){
        if (bonus.isV5b()) {

            if (bonus.getV5().isFruitUp())
                bonus.getV5().setDimY(bonus.getV5().getDimY() - 45);
            else {
                bonus.getV5().setDimY(bonus.getV5().getDimY() + 45);
            }
        }

    }


}
