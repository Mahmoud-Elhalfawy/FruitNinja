package com.example.android.trial.Gui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.android.trial.Factories.EasyFactory;
import com.example.android.trial.Fruits.Banana;
import com.example.android.trial.Fruits.Danger;
import com.example.android.trial.Fruits.Fatal;
import com.example.android.trial.Fruits.Fruits;
import com.example.android.trial.Fruits.Pineapple;
import com.example.android.trial.Fruits.SpecialCarrot;
import com.example.android.trial.Fruits.SpecialPineapple;
import com.example.android.trial.Fruits.Strawberry;
import com.example.android.trial.Fruits.WaterMelon;
import com.example.android.trial.Activities.L2Activity;
import com.example.android.trial.Activities.Main2Activity;
import com.example.android.trial.R;
import com.example.android.trial.Strategy;
import com.example.android.trial.ThreadController;
import com.example.android.trial.Timer.Timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Game extends SurfaceView implements SurfaceHolder.Callback, Strategy {
    int scoreX=0;
    int x=0;
    private Bitmap happyBg;
    private boolean happy = false;
    private Bitmap happyNinja;
    Timer changeTimer;
    Timer timer;
    EasyFactory factory;
    boolean sad = false;
    MediaPlayer applause = new MediaPlayer();
    MediaPlayer bonus = new MediaPlayer();
    MediaPlayer stumble = new MediaPlayer();
    MediaPlayer boom = new MediaPlayer();
    MediaPlayer sadTrumpet = new MediaPlayer();
    MediaPlayer level1 = new MediaPlayer();
    float swordX = -3;
    float swordY = 0;
    Bitmap sword;
    int score = 0;
    int lives = 3;
    private Bitmap sadNinja;
    private Bitmap sadBg;
    private Paint gameOver = new Paint();
    private Bitmap[] life = new Bitmap[2];
    private Paint scorePaint = new Paint();
    private Paint levelPaint = new Paint();
    private Paint win = new Paint();
    int decreaseFirstMove = 10;
    private boolean decreaseBool = false;
    private boolean f1b = true;
    private boolean f2b = true;
    private boolean f3b = true;
    private Random fr = new Random();
    //>>>>>>>>>>>>>>>>>>>>>ARRAY<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    Fruits f1 = null;
    Fruits f2 = null;
    Fruits f3 = null;
    Fruits f4 = null;
    private Bitmap specialPineapplePhoto;
    private Bitmap specialCarrotPhoto;
    private Bitmap starPhoto;
    private Bitmap dangerPhoto;
    private Bitmap fatalPhoto;
    private Bitmap explode;
    private Bitmap pineeaplePhoto;
    private Bitmap slicedPineapple;
    private Bitmap bananaPhoto;
    private Bitmap slicedBanana;
    private Fruits danger = new Danger();
    private Fruits fatal = new Fatal();
    private WaterMelon watermelonA = new WaterMelon();
    private Strawberry strawberryA = new Strawberry();
    private Banana bananaA = new Banana();
    private Pineapple pineappleA = new Pineapple();
    private Fruits specialPineapple = SpecialPineapple.getInstance();
    private Fruits specialCarrot = new SpecialCarrot();
    private List<Fruits> fruits = new ArrayList<>();
    private int outOf3 = 0;
    float degrees = 1;//rotation degree
    private ThreadController thread;
    private Bitmap bg;
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>WaterMelon<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private Bitmap watermelon;
    private Bitmap slicedWatermelon;
    int levelFlag = 0;
    WaterMelon waterMelon;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Strawberry<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    private Bitmap strawberryPhoto;
    private Bitmap slicedStrawberry;
    private Strawberry strawberry;
    private L2Activity mainActivity;


    public void setMainActivity(L2Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

//>>>>>>>>>>>>>>>>>>>>>>>>>Setters and Getters<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public boolean isSad() {
        return sad;
    }

    public void setSad(boolean sad) {
        this.sad = sad;
    }

    public MediaPlayer getStumble() {
        return stumble;
    }

    public void setStumble(MediaPlayer stumble) {
        this.stumble = stumble;
    }

    public MediaPlayer getSadTrumpet() {
        return sadTrumpet;
    }

    public void setSadTrumpet(MediaPlayer sadTrumpet) {
        this.sadTrumpet = sadTrumpet;
    }

    public float getSwordX() {
        return swordX;
    }

    public void setSwordX(float swordX) {
        this.swordX = swordX;
    }

    public float getSwordY() {
        return swordY;
    }

    public void setSwordY(float swordY) {
        this.swordY = swordY;
    }

    public Bitmap getSword() {
        return sword;
    }

    public void setSword(Bitmap sword) {
        this.sword = sword;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Bitmap getSadNinja() {
        return sadNinja;
    }

    public void setSadNinja(Bitmap sadNinja) {
        this.sadNinja = sadNinja;
    }

    public Bitmap getSadBg() {
        return sadBg;
    }

    public void setSadBg(Bitmap sadBg) {
        this.sadBg = sadBg;
    }

    public Paint getGameOver() {
        return gameOver;
    }

    public void setGameOver(Paint gameOver) {
        this.gameOver = gameOver;
    }

    public Bitmap[] getLife() {
        return life;
    }

    public void setLife(Bitmap[] life) {
        this.life = life;
    }

    public Paint getScorePaint() {
        return scorePaint;
    }

    public void setScorePaint(Paint scorePaint) {
        this.scorePaint = scorePaint;
    }

    public Paint getLevelPaint() {
        return levelPaint;
    }

    public void setLevelPaint(Paint levelPaint) {
        this.levelPaint = levelPaint;
    }

    public int getDecreaseFirstMove() {
        return decreaseFirstMove;
    }

    public void setDecreaseFirstMove(int decreaseFirstMove) {
        this.decreaseFirstMove = decreaseFirstMove;
    }

    public boolean isDecreaseBool() {
        return decreaseBool;
    }

    public void setDecreaseBool(boolean decreaseBool) {
        this.decreaseBool = decreaseBool;
    }

    public boolean isF1b() {
        return f1b;
    }

    public void setF1b(boolean f1b) {
        this.f1b = f1b;
    }

    public boolean isF2b() {
        return f2b;
    }

    public void setF2b(boolean f2b) {
        this.f2b = f2b;
    }

    public boolean isF3b() {
        return f3b;
    }

    public void setF3b(boolean f3b) {
        this.f3b = f3b;
    }

    public Random getFr() {
        return fr;
    }

    public void setFr(Random fr) {
        this.fr = fr;
    }

    public Fruits getF1() {
        return f1;
    }

    public void setF1(Fruits f1) {
        this.f1 = f1;
    }

    public Fruits getF2() {
        return f2;
    }

    public void setF2(Fruits f2) {
        this.f2 = f2;
    }

    public Fruits getF3() {
        return f3;
    }

    public void setF3(Fruits f3) {
        this.f3 = f3;
    }

    public Bitmap getPineeaplePhoto() {
        return pineeaplePhoto;
    }

    public void setPineeaplePhoto(Bitmap pineeaplePhoto) {
        this.pineeaplePhoto = pineeaplePhoto;
    }

    public Bitmap getSlicedPineapple() {
        return slicedPineapple;
    }

    public void setSlicedPineapple(Bitmap slicedPineapple) {
        this.slicedPineapple = slicedPineapple;
    }

    public Bitmap getBananaPhoto() {
        return bananaPhoto;
    }

    public void setBananaPhoto(Bitmap bananaPhoto) {
        this.bananaPhoto = bananaPhoto;
    }

    public Bitmap getSlicedBanana() {
        return slicedBanana;
    }

    public void setSlicedBanana(Bitmap slicedBanana) {
        this.slicedBanana = slicedBanana;
    }

    public WaterMelon getWatermelonA() {
        return watermelonA;
    }

    public void setWatermelonA(WaterMelon watermelonA) {
        this.watermelonA = watermelonA;
    }

    public Strawberry getStrawberryA() {
        return strawberryA;
    }

    public void setStrawberryA(Strawberry strawberryA) {
        this.strawberryA = strawberryA;
    }

    public Banana getBananaA() {
        return bananaA;
    }

    public void setBananaA(Banana bananaA) {
        this.bananaA = bananaA;
    }

    public Pineapple getPineappleA() {
        return pineappleA;
    }

    public void setPineappleA(Pineapple pineappleA) {
        this.pineappleA = pineappleA;
    }

    public List<Fruits> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruits> fruits) {
        this.fruits = fruits;
    }

    public int getOutOf3() {
        return outOf3;
    }

    public void setOutOf3(int outOf3) {
        this.outOf3 = outOf3;
    }

    public float getDegrees() {
        return degrees;
    }

    public void setDegrees(float degrees) {
        this.degrees = degrees;
    }

    public ThreadController getThread() {
        return thread;
    }

    public void setThread(ThreadController thread) {
        this.thread = thread;
    }

    public Bitmap getBg() {
        return bg;
    }

    public void setBg(Bitmap bg) {
        this.bg = bg;
    }

    public Bitmap getWatermelon() {
        return watermelon;
    }

    public void setWatermelon(Bitmap watermelon) {
        this.watermelon = watermelon;
    }

    public Bitmap getSlicedWatermelon() {
        return slicedWatermelon;
    }

    public void setSlicedWatermelon(Bitmap slicedWatermelon) {
        this.slicedWatermelon = slicedWatermelon;
    }

    public int getLevelFlag() {
        return levelFlag;
    }

    public void setLevelFlag(int levelFlag) {
        this.levelFlag = levelFlag;
    }

    public WaterMelon getWaterMelon() {
        return waterMelon;
    }

    public void setWaterMelon(WaterMelon waterMelon) {
        this.waterMelon = waterMelon;
    }

    public Bitmap getStrawberryPhoto() {
        return strawberryPhoto;
    }

    public void setStrawberryPhoto(Bitmap strawberryPhoto) {
        this.strawberryPhoto = strawberryPhoto;
    }

    public Bitmap getSlicedStrawberry() {
        return slicedStrawberry;
    }

    public void setSlicedStrawberry(Bitmap slicedStrawberry) {
        this.slicedStrawberry = slicedStrawberry;
    }

    public Strawberry getStrawberry() {
        return strawberry;
    }

    public void setStrawberry(Strawberry strawberry) {
        this.strawberry = strawberry;
    }


    public Game(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new ThreadController(getHolder(), this);
        setFocusable(true);

    }


    public void pause() {
        thread.setRunning(false);
        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void resume() {
        thread.setRunning(true);
        thread.start();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        happyBg=BitmapFactory.decodeResource(getResources(),R.drawable.celebration);
        try {
            score=mainActivity.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        applause = MediaPlayer.create(getContext(), R.raw.applause);
        happyNinja = BitmapFactory.decodeResource(getResources(), R.drawable.happyninja);
        timer = new Timer();
        changeTimer=new Timer();
        timer.change();
        bonus = MediaPlayer.create(getContext(), R.raw.bonus);
        level1 = MediaPlayer.create(getContext(), R.raw.aha);
        level1.setVolume(30, 30);
        bonus.setVolume(10, 10);
        level1.setLooping(true);

        level1.start();
        //>>>>>>>>>>>>>>>>Bombs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        fatalPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.fatal_bomb);
        dangerPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.dangerous);
        explode = BitmapFactory.decodeResource(getResources(), R.drawable.explode);
        danger.setWholeFruit(dangerPhoto);
        danger.setSlicedFruit(explode);
        fatal.setWholeFruit(fatalPhoto);
        fatal.setSlicedFruit(explode);


        //>>>>>>>>>>>>>>>Special Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        specialPineapplePhoto = BitmapFactory.decodeResource(getResources(), R.drawable.specialpin);
        specialCarrotPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.carrotwhole);
        starPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        specialPineapple.setWholeFruit(specialPineapplePhoto);
        specialPineapple.setSlicedFruit(starPhoto);
        specialCarrot.setWholeFruit(specialCarrotPhoto);
        specialCarrot.setSlicedFruit(starPhoto);


        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>Paints<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        stumble = MediaPlayer.create(getContext(), R.raw.sword);
        sadTrumpet = MediaPlayer.create(getContext(), R.raw.sadtrumpet);
        boom = MediaPlayer.create(getContext(), R.raw.boom);
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        levelPaint.setColor(Color.WHITE);
        levelPaint.setTextSize(50);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setAntiAlias(true);
        levelPaint.setTextAlign(Paint.Align.CENTER);

        gameOver.setColor(Color.RED);
        gameOver.setTextSize(100);
        gameOver.setTypeface(Typeface.DEFAULT_BOLD);
        gameOver.setAntiAlias(true);
        gameOver.setTextAlign(Paint.Align.CENTER);


        win.setColor(Color.GREEN);
        win.setTextSize(100);
        win.setTypeface(Typeface.DEFAULT_BOLD);
        win.setAntiAlias(true);
        win.setTextAlign(Paint.Align.CENTER);

        sword = BitmapFactory.decodeResource(getResources(), R.drawable.sword);

        waterMelon = new WaterMelon();
        strawberry = new Strawberry();
        thread.setRunning(true);
        thread.start();
        bg = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
        sadBg = BitmapFactory.decodeResource(getResources(), R.drawable.gameoverbg);
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>lives<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.heart);


        //>>>>>>>>>>>>>>>>>>>Game Over<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        sadNinja = BitmapFactory.decodeResource(getResources(), R.drawable.sad_ninja);


        //  >>>>>>>>>>>>>>>>>WaterMelon<<<<<<<<<<<<<<<<<<<<<
        watermelon = BitmapFactory.decodeResource(getResources(), R.drawable.watermelonwhole);
        waterMelon.setWholeFruit(watermelon);
        slicedWatermelon = BitmapFactory.decodeResource(getResources(), R.drawable.watermeloncut);
        waterMelon.setSlicedFruit(slicedWatermelon);
        waterMelon.setDecreasedMove(10);
//        >>>>>>>>>>>>>>>>>>>>>>>>>>>Strawberry<<<<<<<<<<<<<<<<<<<<<<<<<<<

        strawberryPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.strawberry1);
        slicedStrawberry = BitmapFactory.decodeResource(getResources(), R.drawable.cutstrawberry);
        strawberry.setWholeFruit(strawberryPhoto);
        strawberry.setSlicedFruit(slicedStrawberry);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>Pineapple photos<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        pineeaplePhoto = BitmapFactory.decodeResource(getResources(), R.drawable.pineapple);
        slicedPineapple = BitmapFactory.decodeResource(getResources(), R.drawable.pineapplecut);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Banana photos<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        bananaPhoto = BitmapFactory.decodeResource(getResources(), R.drawable.banana);
        slicedBanana = BitmapFactory.decodeResource(getResources(), R.drawable.bananaslices);

//       >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Array of Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        watermelonA.setWholeFruit(watermelon);
        watermelonA.setSlicedFruit(slicedWatermelon);
        strawberryA.setWholeFruit(strawberryPhoto);
        strawberryA.setSlicedFruit(slicedStrawberry);
        bananaA.setWholeFruit(bananaPhoto);
        bananaA.setSlicedFruit(slicedBanana);
        pineappleA.setWholeFruit(pineeaplePhoto);
        pineappleA.setSlicedFruit(slicedPineapple);
        fruits.add(watermelonA);
        fruits.add(strawberryA);
        fruits.add(pineappleA);
        fruits.add(bananaA);
        fruits.add(danger);
        fruits.add(fatal);
        fruits.add(specialPineapple);
        fruits.add(specialCarrot);
        factory = new EasyFactory(this);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        level1.stop();
        level1.release();
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
            } catch (Exception e) {

            }
            retry = false;
        }

    }


    @Override
    public void drawLevel(Canvas canvas) {


        super.draw(canvas);
        Log.d("width", String.valueOf(canvas.getWidth()));

        if (timer.getSeconds() >= 36) {
          //  timer.setTimerState(new StopState());

            try {
                happyNinja(canvas);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (lives <= 0) {
           // timer.setTimerState(new StopState());
            level1.stop();
//resume();
            sadNinja(canvas);
            //lives=3;
        } else {
            canvas.drawBitmap(bg, 0, 0, null);
            canvas.drawText("BEST:", 5, 55, scorePaint);
            canvas.drawText("Score:",5,120,scorePaint);
            canvas.drawText(Integer.toString(score), 165, 55, scorePaint);
            canvas.drawText(Integer.toString(scoreX), 165, 120, scorePaint);

            canvas.drawText(String.valueOf(timer.getSeconds()), canvas.getWidth() / 2, 55, levelPaint);
            canvas.drawBitmap(sword, swordX, swordY, null);
            for (int i = 0; i < lives; i++)
                canvas.drawBitmap(life[0], canvas.getWidth() - ((i + 1) * 70), 5, null);
            if (levelFlag == 0) {
                // secondMove(canvas);
                firstMove(canvas);
                //  updateFirstMove();
            } else if (levelFlag == 1) {
                secondMove(canvas);
                //updateSecondMove();
            } else
                thirdMove(canvas);
        }
    }


    public void sadNinja(Canvas canvas) {
        if (!sad) {
            x=timer.getSeconds();
           // timer.change();
            level1.stop();
            sadTrumpet.start();
            try {
                mainActivity.save(Math.max(score,scoreX));
            } catch (IOException e) {
                e.printStackTrace();
            }
            sad = true;
        }
        if(timer.getSeconds()>= x+6)
            mainActivity.returnIntent();

        canvas.drawBitmap(sadBg, 0, 0, null);
        canvas.drawText("Score:", 5, 55, scorePaint);
        canvas.drawText(Integer.toString(Math.max(score,scoreX)), 165, 55, scorePaint);
        canvas.drawText("level 1", canvas.getWidth() / 2, 55, levelPaint);
        canvas.drawBitmap(sadNinja, canvas.getWidth() / 2 - (sadNinja.getWidth() / 2), canvas.getHeight() / 2 - (sadNinja.getHeight() / 2) + 150, null);
        canvas.drawText("GAME OVER !", canvas.getWidth() / 2, (canvas.getHeight() / 4), gameOver);

    }


    public void happyNinja(Canvas canvas) throws IOException {

        specialPineapple.setDimX((float) specialPineapple.getR().nextInt(325)+700);
        specialPineapple.setDimY(740);
        specialPineapple.setFruitRight(false);
        specialPineapple.setSlicedFlag(0);
        specialPineapple.setFruitUp(true);
        specialPineapple.setCalculated(false);
        specialPineapple.setBonus(true);
    if (!happy) {

            mainActivity.save(Math.max(score,scoreX));
            level1.stop();
            applause.start();
            happy = true;

    }
    if(timer.getSeconds()>=41){
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
            } catch (Exception e) {

            }
            retry = false;
        }
        Intent intent=new Intent(getContext(), Main2Activity.class);
         mainActivity.startIntent(intent);
    }

          //


        canvas.drawBitmap(happyBg, 0, 0, null);
        canvas.drawText("Score:", 5, 55, scorePaint);
        canvas.drawText(Integer.toString(Math.max(score,scoreX)), 165, 55, scorePaint);
        canvas.drawText("level 1", canvas.getWidth() / 2, 55, levelPaint);
        canvas.drawBitmap(happyNinja, canvas.getWidth() / 2 - (happyNinja.getWidth() / 2), canvas.getHeight() / 2 - (happyNinja.getHeight() / 2) + 150, null);
       // canvas.drawText("YOU WIN !", canvas.getWidth() / 2, (canvas.getHeight() / 4), win);
    }

    public void update() {
        if (levelFlag == 0)
            //updateSecondMove();
            factory.updateFirstMove();
        else if (levelFlag == 1)
            updateSecondMove();
        else if(levelFlag==2){
            factory.updateFirstFruit();
            factory.updateSecondFruit();
            factory.updateThirdFruit();
        }
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        //if (levelFlag == 0) {
        // secondMove(canvas);
        //   firstMove(canvas);
        //  updateFirstMove();
        //} else if (levelFlag == 1) {
        //  secondMove(canvas);
        //updateSecondMove();
        //}else
        //    thirdMove(canvas);
    }


    ///  >>>>>>>>>>>>>>>>>>>>>>>>First Move<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public void firstMove(Canvas canvas) {

        // degrees=1;
        Matrix matrix = new Matrix();
        // matrix.setRotate(degrees);
        matrix.postRotate(degrees, waterMelon.getWholeFruit().getWidth() / 2, waterMelon.getWholeFruit().getHeight() / 2);
        Log.d("width", Float.toString(canvas.getWidth()));
        Log.d("height", Float.toString(canvas.getHeight()));
        if (waterMelon.getSlicedFlag() == 0) {
            waterMelon.setRotatedWholeFruit(Bitmap.createBitmap(waterMelon.getWholeFruit(), 0, 0, waterMelon.getWholeFruit().getWidth(), waterMelon.getWholeFruit().getHeight(), matrix, true));
            canvas.drawBitmap(waterMelon.getRotatedWholeFruit(), waterMelon.getDimX(), waterMelon.getDimY(), null);
        } else {
            if (!waterMelon.isCalculated()) {
                waterMelon.setCalculated(true);
                scoreX += 4;
            }
            waterMelon.setRotatedSlicedFruit(Bitmap.createBitmap(waterMelon.getSlicedFruit(), 0, 0, waterMelon.getSlicedFruit().getWidth(), waterMelon.getSlicedFruit().getHeight(), matrix, true));
            canvas.drawBitmap(waterMelon.getRotatedSlicedFruit(), waterMelon.getDimX(), waterMelon.getDimY(), null);
            canvas.drawBitmap(waterMelon.getRotatedSlicedFruit(), waterMelon.getDimX() + (watermelon.getWidth()), waterMelon.getDimY(), null);
        }
        if (waterMelon.getSlicedFlag() == 0) {
            if (waterMelon.getDimX() > canvas.getWidth() - waterMelon.getWholeFruit().getWidth() - 10)
                waterMelon.setFruitRight(false);
        }
        if (waterMelon.getSlicedFlag() == 1) {
            if (waterMelon.getDimX() > canvas.getWidth() - (2 * waterMelon.getSlicedFruit().getWidth()) - 10)
                waterMelon.setFruitRight(false);
        }
        if (waterMelon.getDimX() < 0)
            waterMelon.setFruitRight(true);
        if (waterMelon.getDimY() < 0)
            waterMelon.setFruitUp(false);

        if (waterMelon.getDimY() > canvas.getHeight() + 9) {
            if (waterMelon.getSlicedFlag() == 0)
                lives--;
            degrees = 1;
            levelFlag = 1;
            waterMelon.setCalculated(false);
            waterMelon.setSlicedFlag(0);
            //   thread.sleep(2000);
            waterMelon.setDimY(canvas.getHeight());
            waterMelon.setFruitUp(true);
            waterMelon.setFruitRight(true);
            waterMelon.setDimX(waterMelon.getR().nextInt(500));
            // levelFlag = 1;

        }

        degrees += 1;
    }

    // >>>>>>>>>>>>>>>>>>End of First Move<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //  >>>>>>>>>>>>>>>>>>>>>>>>>>>>Start of Second Move<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public void secondMove(Canvas canvas) {

        // degrees=1;
        Matrix matrix = new Matrix();
        // matrix.setRotate(degrees);
        matrix.postRotate(degrees, strawberry.getWholeFruit().getWidth() / 2, strawberry.getWholeFruit().getHeight() / 2);
        if (strawberry.getSlicedFlag() == 0) {
            strawberry.setRotatedWholeFruit(Bitmap.createBitmap(strawberry.getWholeFruit(), 0, 0, strawberry.getWholeFruit().getWidth(), strawberry.getWholeFruit().getHeight(), matrix, true));
            canvas.drawBitmap(strawberry.getRotatedWholeFruit(), strawberry.getDimX(), strawberry.getDimY(), null);
        } else {
            if (!strawberry.isCalculated()) {
                scoreX += 4;
                strawberry.setCalculated(true);
            }
            strawberry.setRotatedSlicedFruit(Bitmap.createBitmap(strawberry.getSlicedFruit(), 0, 0, strawberry.getSlicedFruit().getWidth(), strawberry.getSlicedFruit().getHeight(), matrix, true));

            canvas.drawBitmap(strawberry.getRotatedSlicedFruit(), strawberry.getDimX(), strawberry.getDimY(), null);
            canvas.drawBitmap(strawberry.getRotatedSlicedFruit(), strawberry.getDimX() + (strawberry.getSlicedFruit().getWidth()), strawberry.getDimY(), null);
        }
        if (strawberry.getSlicedFlag() == 0) {
            if (strawberry.getDimX() > canvas.getWidth() - strawberry.getWholeFruit().getWidth() - 10)
                strawberry.setFruitRight(false);
        } else {
            if (strawberry.getDimX() > canvas.getWidth() - (2 * strawberry.getSlicedFruit().getWidth()) - 10)
                strawberry.setFruitRight(false);
        }
        if (strawberry.getDimX() < 0)
            strawberry.setFruitRight(true);
        if (strawberry.getDimY() < 0)
            strawberry.setFruitUp(false);

        if (strawberry.getDimY() > canvas.getHeight() + 9) {
            if (strawberry.getSlicedFlag() == 0 && lives > 0)
                lives--;
            initialize();
            degrees = 1;
            levelFlag = 2;
            strawberry.setCalculated(false);
            //  thread.sleep(2000);
            strawberry.setDimY(canvas.getHeight());
            strawberry.setFruitUp(true);
            strawberry.setFruitRight(true);
            strawberry.setDimX(strawberry.getR().nextInt(500));
        }

        degrees += 1;

    }


    public void updateSecondMove() {
        factory.updateSecondMove();
    }


    // >>>>>>>>>>>>>>>>>>>>>>>>End of Second Move<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    // >>>>>>>>>>>>>>>>>>>>>>>>>>Start of Third Move<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public void initialize() {
        f1 = fruits.get(0);
        f2 = fruits.get(1);
        f3 = fruits.get(2);
        f1.setDecreasedMove(7);
        f2.setDecreasedMove(10);
        f3.setDecreasedMove(13);

        f1b = true;
        f2b = true;
        f3b = true;
        f1.setSlicedFlag(0);
        f2.setSlicedFlag(0);
        f3.setSlicedFlag(0);

    }

    public void firstFruit(Canvas canvas) {
        if (f1b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, f1.getWholeFruit().getWidth() / 2, f1.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (f1.getSlicedFlag() == 0) {
                f1.setRotatedWholeFruit(Bitmap.createBitmap(f1.getWholeFruit(), 0, 0, f1.getWholeFruit().getWidth(), f1.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f1.getRotatedWholeFruit(), f1.getDimX(), f1.getDimY(), null);
            } else {
                if (!f1.isCalculated()) {
                    f1.setCalculated(true);
                    if (f1 instanceof Danger && scoreX >= 4)
                        scoreX -= 4;
                    else if (f1.isBonus())
                        scoreX += 8;
                    else
                        scoreX += 4;


                    if (f1.getSlicedFlag() == 1 && f1 instanceof Danger)
                        lives--;
                    if (f1.getSlicedFlag() == 1 && f1 instanceof Fatal)
                        lives = 0;
                }
                f1.setRotatedSlicedFruit(Bitmap.createBitmap(f1.getSlicedFruit(), 0, 0, f1.getSlicedFruit().getWidth(), f1.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f1.getRotatedSlicedFruit(), f1.getDimX(), f1.getDimY(), null);
                if (!(f1 instanceof Danger || f1 instanceof Fatal) && !f1.isBonus())
                    canvas.drawBitmap(f1.getRotatedSlicedFruit(), f1.getDimX() + (f1.getSlicedFruit().getWidth()), f1.getDimY(), null);

            }
            if (f1.getSlicedFlag() == 0) {
                if (f1.getDimX() > canvas.getWidth() - f1.getWholeFruit().getWidth() - 11)
                    f1.setFruitRight(false);
            } else if (!(f1 instanceof Danger || f1 instanceof Fatal) && !f1.isBonus()) {
                if (f1.getDimX() > canvas.getWidth() - (2 * f1.getSlicedFruit().getWidth()) - 11)
                    f1.setFruitRight(false);
            } else {
                if (f1.getDimX() > canvas.getWidth() - f1.getSlicedFruit().getWidth() - 11)
                    f1.setFruitRight(false);
            }
            if (f1.getDimX() < 0)
                f1.setFruitRight(true);
            if (f1.getDimY() < 0)
                f1.setFruitUp(false);

            if (f1.getDimY() > canvas.getHeight() + 9) {
                if (lives > 0 && f1.getSlicedFlag() == 0 && !((f1 instanceof Fatal) || (f1 instanceof Danger)))
                    lives--;
                f1.setDimY(canvas.getHeight());
                f1.setFruitUp(true);
                f1.setFruitRight(true);
                f1.setDimX(f1.getR().nextInt(f1.getR().nextInt(900)));
                f1b = false;
                f1.setCalculated(false);
                outOf3++;
            }
        }
    }

    public void secondFruit(Canvas canvas) {
        if (f2b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, f2.getWholeFruit().getWidth() / 2, f2.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (f2.getSlicedFlag() == 0) {
                f2.setRotatedWholeFruit(Bitmap.createBitmap(f2.getWholeFruit(), 0, 0, f2.getWholeFruit().getWidth(), f2.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f2.getRotatedWholeFruit(), f2.getDimX(), f2.getDimY(), null);
            } else {
                if (!f2.isCalculated()) {
                    f2.setCalculated(true);

                    if (f2 instanceof Danger && scoreX >= 4)
                        scoreX -= 4;
                    else if (f2.isBonus())
                        scoreX += 8;
                    else
                        scoreX += 4;
                    if (f2.getSlicedFlag() == 1 && f2 instanceof Danger)
                        lives--;
                    if (f2.getSlicedFlag() == 1 && f2 instanceof Fatal)
                        lives = 0;

                }
                f2.setRotatedSlicedFruit(Bitmap.createBitmap(f2.getSlicedFruit(), 0, 0, f2.getSlicedFruit().getWidth(), f2.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f2.getRotatedSlicedFruit(), f2.getDimX(), f2.getDimY(), null);
                if (!(f2 instanceof Danger || f2 instanceof Fatal) && !f2.isBonus())

                    canvas.drawBitmap(f2.getRotatedSlicedFruit(), f2.getDimX() + (f2.getSlicedFruit().getWidth()), f2.getDimY(), null);

            }
            if (f2.getSlicedFlag() == 0) {
                if (f2.getDimX() > canvas.getWidth() - f2.getWholeFruit().getWidth() - 11)
                    f2.setFruitRight(false);
            } else if (!(f2 instanceof Danger || f2 instanceof Fatal) && !f2.isBonus()) {
                if (f2.getDimX() > canvas.getWidth() - (2 * f2.getSlicedFruit().getWidth()) - 11)
                    f2.setFruitRight(false);
            } else {
                if (f2.getDimX() > canvas.getWidth() - f2.getSlicedFruit().getWidth() - 11)
                    f2.setFruitRight(false);
            }
            if (f2.getDimX() < 0)
                f2.setFruitRight(true);
            if (f2.getDimY() < 0)
                f2.setFruitUp(false);

            if (f2.getDimY() > canvas.getHeight() + 9) {
                if (f2.getSlicedFlag() == 0 && lives > 0 && !((f2 instanceof Fatal) || (f2 instanceof Danger)))
                    lives--;
                f2.setDimY(canvas.getHeight());
                f2.setFruitUp(true);
                f2.setFruitRight(true);
                f2.setDimX(f2.getR().nextInt(200));
                f2b = false;
                f2.setCalculated(false);
                outOf3++;
            }
        }
    }


    public void thirdFruit(Canvas canvas) {
        if (f3b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, f3.getWholeFruit().getWidth() / 2, f3.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (f3.getSlicedFlag() == 0) {
                f3.setRotatedWholeFruit(Bitmap.createBitmap(f3.getWholeFruit(), 0, 0, f3.getWholeFruit().getWidth(), f3.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f3.getRotatedWholeFruit(), f3.getDimX(), f3.getDimY(), null);
            } else {

                if (!f3.isCalculated()) {
                    f3.setCalculated(true);
                    if (f3 instanceof Danger && scoreX >= 4)
                        scoreX -= 4;
                    else if (f3.isBonus())
                        scoreX += 8;
                    else
                        scoreX += 4;
                    if (f3.getSlicedFlag() == 1 && f3 instanceof Danger)
                        lives--;
                    if (f3.getSlicedFlag() == 1 && f3 instanceof Fatal)
                        lives = 0;
                }
                f3.setRotatedSlicedFruit(Bitmap.createBitmap(f3.getSlicedFruit(), 0, 0, f3.getSlicedFruit().getWidth(), f3.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f3.getRotatedSlicedFruit(), f3.getDimX(), f3.getDimY(), null);
                if (!(f3 instanceof Danger || f3 instanceof Fatal) && !f3.isBonus())
                    canvas.drawBitmap(f3.getRotatedSlicedFruit(), f3.getDimX() + (f3.getSlicedFruit().getWidth()), f3.getDimY(), null);
            }
            if (f3.getSlicedFlag() == 0) {
                if (f3.getDimX() > canvas.getWidth() - f3.getWholeFruit().getWidth() - 11)
                    f3.setFruitRight(false);
            } else if (!(f2 instanceof Danger || f2 instanceof Fatal) && !f3.isBonus()) {
                if (f3.getDimX() > canvas.getWidth() - (2 * f3.getSlicedFruit().getWidth()) - 11)
                    f3.setFruitRight(false);
            } else {
                if (f3.getDimX() > canvas.getWidth() - f3.getSlicedFruit().getWidth() - 11)
                    f3.setFruitRight(false);
            }
            if (f3.getDimX() < 0)
                f3.setFruitRight(true);
            if (f3.getDimY() < 0)
                f3.setFruitUp(false);

            if (f3.getDimY() > canvas.getHeight() + 9) {
                if (f3.getSlicedFlag() == 0 && lives > 0 && !((f3 instanceof Fatal) || (f3 instanceof Danger)))
                    lives--;
                f3.setDimY(canvas.getHeight());
                f3.setFruitUp(true);
                f3.setFruitRight(true);
                f3.setDimX(f3.getR().nextInt(600) + 600);
                outOf3++;
                f3.setCalculated(false);
                f3b = false;

            }
        }
    }


    public void thirdMove(Canvas canvas) {

        //firstFruit(canvas);
//if(outOf3==0)
        //      initialize();
        if (outOf3 < 3) {
            firstFruit(canvas);
            secondFruit(canvas);
            thirdFruit(canvas);

        } else {
            // thread.sleep(500);
            Collections.shuffle(fruits);
            initialize();
            outOf3 = 0;
            degrees = 1;

        }


        degrees += 1;
    }


    public void updateFirstFruit() {
        factory.updateFirstFruit();

    }

    public void updateSecondFruit() {
        factory.updateSecondFruit();
    }

    public void updateThirdFruit() {
        factory.updateThirdFruit();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();
            swordX = x;
            swordY = y;
            if (levelFlag == 0) {
                if (x > waterMelon.getDimX() && x < waterMelon.getDimX() + waterMelon.getWholeFruit().getWidth() + 4 &&
                        y > waterMelon.getDimY() && y < waterMelon.getDimY() + waterMelon.getWholeFruit().getHeight() + 4) {
                    stumble.start();
                    waterMelon.setSlicedFlag(1);
                    // waterMelon.setFruitUp(false);
                }
            } else if (levelFlag == 1) {
                if (x > strawberry.getDimX() && x < strawberry.getDimX() + strawberry.getWholeFruit().getWidth() + 4 &&
                        y > strawberry.getDimY() && y < strawberry.getDimY() + strawberry.getWholeFruit().getHeight() + 4) {
                    stumble.start();

                    strawberry.setSlicedFlag(1);

                }
            } else if (levelFlag == 2) {

                //              >>>>>>>>First fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                if (x > f1.getDimX() && x < f1.getDimX() + f1.getWholeFruit().getWidth() + 4 &&
                        y > f1.getDimY() && y < f1.getDimY() + f1.getWholeFruit().getHeight() + 4) {
                    f1.setSlicedFlag(1);
                    if (f1 instanceof Danger)
                        boom.start();
                    else if (f1.isBonus())
                        bonus.start();
                    else
                        stumble.start();


                }

                ////   >>>>>>>>>>>>>>>>>>Second fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                if (x > f2.getDimX() && x < f2.getDimX() + f2.getWholeFruit().getWidth() + 4 &&
                        y > f2.getDimY() && y < f2.getDimY() + f2.getWholeFruit().getHeight() + 4) {
                    f2.setSlicedFlag(1);
                    if (f2 instanceof Danger)
                        boom.start();
                    else if (f2.isBonus())
                        bonus.start();
                    else
                        stumble.start();

                }

                // >>>>>>>>>>>>>>>>>>>>>>>>>Third fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                if (x > f3.getDimX() && x < f3.getDimX() + f3.getWholeFruit().getWidth() + 4 &&
                        y > f3.getDimY() && y < f3.getDimY() + f3.getWholeFruit().getHeight() + 4) {
                    f3.setSlicedFlag(1);
                    if (f3 instanceof Danger)
                        boom.start();
                    else if (f3.isBonus())
                        bonus.start();
                    else
                        stumble.start();


                }


            }
        }
        return true;
    }

}


