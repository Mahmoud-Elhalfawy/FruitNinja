package com.example.android.trial.Fruits;

public class SpecialCarrot extends Fruits {

public SpecialCarrot(){
    super();
    setDimX((float) r.nextInt(325)+500);
    setDimY(740);
    setFruitRight(false);
    setSlicedFlag(0);
    setFruitUp(true);
    setCalculated(false);
    setBonus(true);
}

}
