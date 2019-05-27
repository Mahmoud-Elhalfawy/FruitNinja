package com.example.android.trial.Fruits;

import android.graphics.Bitmap;

import java.util.Random;

public abstract class Fruits {
    Random r = new Random();
private boolean calculated=false;
    private Bitmap wholeFruit;
    private Bitmap slicedFruit;
    private Bitmap rotatedWholeFruit;
    private Bitmap rotatedSlicedFruit;
    private float dimX;
    private float dimY;
    private boolean fruitUp;
    private boolean fruitRight;
    private int slicedFlag;
    private boolean bonus=false;
    private boolean splash=false;

    public boolean isSplash() {
        return splash;
    }

    public void setSplash(boolean splash) {
        this.splash = splash;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    private int decreasedMove;

    public int getDecreasedMove() {
        return decreasedMove;
    }

    public void setDecreasedMove(int decreasedMove) {
        this.decreasedMove = decreasedMove;
    }



    public Bitmap getRotatedWholeFruit() {
        return rotatedWholeFruit;
    }

    public void setRotatedWholeFruit(Bitmap rotatedWholeFruit) {
        this.rotatedWholeFruit = rotatedWholeFruit;
    }

    public Bitmap getRotatedSlicedFruit() {
        return rotatedSlicedFruit;
    }

    public void setRotatedSlicedFruit(Bitmap rotatedSlicedFruit) {
        this.rotatedSlicedFruit = rotatedSlicedFruit;
    }


    public boolean isFruitUp() {
        return fruitUp;
    }

    public void setFruitUp(boolean fruitUp) {
        this.fruitUp = fruitUp;
    }

    public boolean isFruitRight() {
        return fruitRight;
    }

    public void setFruitRight(boolean fruitRight) {
        this.fruitRight = fruitRight;
    }

    public int getSlicedFlag() {
        return slicedFlag;
    }

    public void setSlicedFlag(int slicedFlag) {
        this.slicedFlag = slicedFlag;
    }


    public Bitmap getWholeFruit() {
        return wholeFruit;
    }

    public void setWholeFruit(Bitmap wholeFruit) {
        this.wholeFruit = wholeFruit;
    }

    public Bitmap getSlicedFruit() {
        return slicedFruit;
    }

    public void setSlicedFruit(Bitmap slicedFruit) {
        this.slicedFruit = slicedFruit;
    }

    public float getDimX() {
        return dimX;
    }

    public void setDimX(float dimX) {
        this.dimX = dimX;
    }

    public float getDimY() {
        return dimY;
    }

    public void setDimY(float dimY) {
        this.dimY = dimY;
    }


}
