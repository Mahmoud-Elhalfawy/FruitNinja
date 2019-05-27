package com.example.android.trial.Factories;

import android.util.Log;

import com.example.android.trial.Fruits.Fruits;
import com.example.android.trial.Gui.Level3;
import com.example.android.trial.Gui.level2;

public class HardFactory {
    Level3 game3;
    int decreaseFirstMove;
    boolean decreaseBool;

    public HardFactory(Level3 game3){
        this.game3=game3;
        decreaseFirstMove=game3.getDecreaseFirstMove();
        decreaseBool=game3.isDecreaseBool();

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
                decreaseFirstMove=decreaseFirstMove- 2;
                //else
                //  decreaseFirstMove = -10;
            }else
                Log.d("wsalt", "sliceUpdate: ");
        }
        f.setDecreasedMove(decreaseFirstMove);

    }






    public void updateFirstFruit(){
        if (game3.isF1b()) {
            if (game3.getF1().getSlicedFlag() == 1 && game3.getF1().isFruitUp())
                sliceUpdate(game3.getF1(), 15, 25);
            else {
                if (game3.getF1().isFruitRight())
                    game3.getF1().setDimX(game3.getF1().getDimX() + 25);
                else
                    game3.getF1().setDimX(game3.getF1().getDimX() - 25);

                if (game3.getF1().isFruitUp())
                    game3.getF1().setDimY(game3.getF1().getDimY() - 15);
                else {
                    game3.getF1().setDimY(game3.getF1().getDimY() + 15);
                }
            }
        }
    }



    public void updateSecondFruit(){
        if (game3.isF2b()) {
            if (game3.getF2().getSlicedFlag() == 1 && game3.getF2().isFruitUp())
                sliceUpdate(game3.getF2(), 17, 20);
            else {
                if (game3.getF2().isFruitRight())
                    game3.getF2().setDimX(game3.getF2().getDimX() + 20);
                else
                    game3.getF2().setDimX(game3.getF2().getDimX() - 20);

                if (game3.getF2().isFruitUp())
                    game3.getF2().setDimY(game3.getF2().getDimY() - 17);
                else {
                    game3.getF2().setDimY(game3.getF2().getDimY() + 17);
                }
            }
        }
    }


    public void updateThirdFruit(){
        if (game3.isF3b()) {
            if (game3.getF3().getSlicedFlag() == 1 && game3.getF3().isFruitUp())
                sliceUpdate(game3.getF3(), 20, 20);

            else {

                if (game3.getF3().isFruitRight())
                    game3.getF3().setDimX(game3.getF3().getDimX() + 20);
                else
                    game3.getF3().setDimX(game3.getF3().getDimX() - 20);

                if (game3.getF3().isFruitUp())
                    game3.getF3().setDimY(game3.getF3().getDimY() - 20);
                else {
                    game3.getF3().setDimY(game3.getF3().getDimY() + 20);
                }
            }
        }
    }






    public void updateFourthFruit(){
        if (game3.isF4b()) {
            if (game3.getF4().getSlicedFlag() == 1 && game3.getF4().isFruitUp())
                sliceUpdate(game3.getF4(), 20, 16);

            else {

                if (game3.getF4().isFruitRight())
                    game3.getF4().setDimX(game3.getF4().getDimX() + 16);
                else
                    game3.getF4().setDimX(game3.getF4().getDimX() - 16);

                if (game3.getF4().isFruitUp())
                    game3.getF4().setDimY(game3.getF4().getDimY() - 20);
                else {
                    game3.getF4().setDimY(game3.getF4().getDimY() + 20);
                }
            }
        }
    }
}
