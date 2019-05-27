package com.example.android.trial.Fruits;

public class WaterMelon extends Fruits {
    public WaterMelon(){
        super();
        setDimX((float)r.nextInt(800));
        setDimY(740);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);

    }
}
