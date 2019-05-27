package com.example.android.trial.Fruits;

public class Banana extends Fruits {
    public Banana(){
        super();
        setDimX((float)r.nextInt(150));
        setDimY(740);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);

    }

}
