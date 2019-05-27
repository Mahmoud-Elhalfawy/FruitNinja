package com.example.android.trial.Factories;

import android.util.Log;

import com.example.android.trial.Fruits.Fruits;
import com.example.android.trial.Gui.Game;

public class EasyFactory {
    Game game;
    int decreaseFirstMove;
    boolean decreaseBool;
   //Fruits f;
   private static EasyFactory singleEasy = null;


    public  EasyFactory(Game game){

        this.game=game;
        decreaseFirstMove=game.getDecreaseFirstMove();
        decreaseBool=game.isDecreaseBool();
      //  f=game.getWaterMelon();
    }
    public void sliceUpdate(Fruits f, int move, int x){

        decreaseFirstMove=f.getDecreasedMove();
        if (f.isFruitUp()) {
            if (decreaseFirstMove < -move)
               decreaseFirstMove=-move;
            f.setDimY(f.getDimY() - decreaseFirstMove);

            if (f.isFruitRight()) {
                f.setDimX(f.getDimX() + x);
            } else {
                f.setDimX(f.getDimX() - x);
            }

            if (decreaseFirstMove == 0)
               decreaseBool=false;

            if (decreaseBool)
               decreaseBool=false;
            else
                decreaseBool=true;
            if (decreaseBool) {
                //  if (decreaseFirstMove < -10)
                decreaseFirstMove=decreaseFirstMove- 1;
                //else
                //  decreaseFirstMove = -10;
            }else
                Log.d("wsalt", "sliceUpdate: ");
        }
        f.setDecreasedMove(decreaseFirstMove);

    }

public void updateFirstMove(){

    if (game.getWaterMelon().getSlicedFlag() == 1 && game.getWaterMelon().isFruitUp()) {
        sliceUpdate(game.getWaterMelon(), 10, 10);
    } else {
        if (game.getWaterMelon().isFruitRight())
            game.getWaterMelon().setDimX(game.getWaterMelon().getDimX() + 10);
        else
            game.getWaterMelon().setDimX(game.getWaterMelon().getDimX() - 10);

        if (game.getWaterMelon().isFruitUp())
            game.getWaterMelon().setDimY(game.getWaterMelon().getDimY() - 10);
        else {
            game.getWaterMelon().setDimY(game.getWaterMelon().getDimY() + 10);
        }

    }


}


public void updateSecondMove(){
    if (game.getStrawberry().getSlicedFlag() == 1 && game.getStrawberry().isFruitUp())
        sliceUpdate(game.getStrawberry(), 10, 10);
    else {
        if (game.getStrawberry().isFruitRight())
            game.getStrawberry().setDimX(game.getStrawberry().getDimX() + 10);
        else
            game.getStrawberry().setDimX(game.getStrawberry().getDimX() - 10);

        if (game.getStrawberry().isFruitUp())
            game.getStrawberry().setDimY(game.getStrawberry().getDimY() - 10);
        else {
            game.getStrawberry().setDimY(game.getStrawberry().getDimY() + 10);
        }
    }
}



public void updateFirstFruit(){
    if (game.isF1b()) {
        if (game.getF1().getSlicedFlag() == 1 && game.getF1().isFruitUp())
            sliceUpdate(game.getF1(), 7, 11);
        else {
            if (game.getF1().isFruitRight())
                game.getF1().setDimX(game.getF1().getDimX() + 11);
            else
                game.getF1().setDimX(game.getF1().getDimX() - 11);

            if (game.getF1().isFruitUp())
                game.getF1().setDimY(game.getF1().getDimY() - 7);
            else {
                game.getF1().setDimY(game.getF1().getDimY() + 7);
            }
        }
    }
}



public void updateSecondFruit(){

    if (game.isF2b()) {
        if (game.getF2().getSlicedFlag() == 1 && game.getF2().isFruitUp())
            sliceUpdate(game.getF2(), 10, 11);
        else {
            if (game.getF2().isFruitRight())
                game.getF2().setDimX(game.getF2().getDimX() + 11);
            else
                game.getF2().setDimX(game.getF2().getDimX() - 11);

            if (game.getF2().isFruitUp())
                game.getF2().setDimY(game.getF2().getDimY() - 10);
            else {
                game.getF2().setDimY(game.getF2().getDimY() + 10);
            }
        }
    }
}


public void updateThirdFruit(){
    if (game.isF3b()) {
        if (game.getF3().getSlicedFlag() == 1 && game.getF3().isFruitUp())
            sliceUpdate(game.getF3(), 13, 11);

        else {

            if (game.getF3().isFruitRight())
                game.getF3().setDimX(game.getF3().getDimX() + 11);
            else
                game.getF3().setDimX(game.getF3().getDimX() - 11);

            if (game.getF3().isFruitUp())
                game.getF3().setDimY(game.getF3().getDimY() - 13);
            else {
                game.getF3().setDimY(game.getF3().getDimY() + 13);
            }
        }
    }
}


}