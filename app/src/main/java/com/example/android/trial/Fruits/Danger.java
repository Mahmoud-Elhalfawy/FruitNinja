package com.example.android.trial.Fruits;

public class Danger extends Fruits {
    public Danger() {
        super();
        setDimX((float) r.nextInt(325)+200);
        setDimY(740);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);
    }

}
