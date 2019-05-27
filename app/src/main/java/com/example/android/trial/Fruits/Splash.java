package com.example.android.trial.Fruits;

public class Splash extends Fruits {
    public Splash(){
        super();
        setDimX((float)(r.nextInt(50))+600);
        setDimY(735);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);
        setSplash(true);
    }
}
