package com.example.android.trial.Fruits;

public class SpecialPineapple extends Fruits {

    private static SpecialPineapple singleInstance=null;

    private  SpecialPineapple (){
        super();
        setDimX((float) r.nextInt(325)+700);
        setDimY(740);
        setFruitRight(false);
        setSlicedFlag(0);
        setFruitUp(true);
        setCalculated(false);
        setBonus(true);
    }

    public static SpecialPineapple getInstance(){
        if(singleInstance==null)
            singleInstance=new SpecialPineapple();

            return singleInstance;
    }
}
