package com.example.android.trial.Fruits;

public class Fatal extends Fruits {

    public Fatal(){
        super();
        setDimX((float) r.nextInt(325)+100);
        setDimY(735);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);
    }
}
