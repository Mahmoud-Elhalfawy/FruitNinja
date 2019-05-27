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

import com.example.android.trial.Activities.Last;
import com.example.android.trial.Activities.Main2Activity;
import com.example.android.trial.Factories.HardFactory;
import com.example.android.trial.Fruits.Danger;
import com.example.android.trial.Fruits.Fatal;
import com.example.android.trial.Fruits.Fruits;
import com.example.android.trial.Fruits.Pineapple;
import com.example.android.trial.Fruits.SpecialCarrot;
import com.example.android.trial.Fruits.SpecialPineapple;
import com.example.android.trial.Fruits.Splash;
import com.example.android.trial.Fruits.Strawberry;
import com.example.android.trial.Fruits.WaterMelon;
import com.example.android.trial.Activities.Main3Activity;
import com.example.android.trial.R;
import com.example.android.trial.Strategy;
import com.example.android.trial.ThreadController;
import com.example.android.trial.Timer.Timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Level3 extends SurfaceView implements SurfaceHolder.Callback, Strategy {
    int scoreX=0;
    MediaPlayer applause=new MediaPlayer();
    Main3Activity activity;
    boolean happy=false;
int x=0;
    public Main3Activity getActivity() {
        return activity;
    }

    public void setActivity(Main3Activity activity) {
        this.activity = activity;
    }

    Boolean music=false;
    Bitmap happyNinja;
    Bitmap happyBg;
    MediaPlayer level3=new MediaPlayer();
    private HardFactory factory;
    float degrees = 1;
    private int outOf4=0;
    private Timer timer;
    ThreadController thread;
    ArrayList<Fruits> fruits=new ArrayList<>();
    Bitmap bg;
    Bitmap wholeWaterMelon;
    Bitmap slicedWaterMelon;
    Bitmap specialBanana;
    Bitmap star;
    Bitmap specialCherry;
    Bitmap wholeStrawberry;
    Bitmap slicedStrawberry;
    Bitmap wholePoneapple;
    Bitmap slicedPineapple;
    Bitmap dangerous;
    Bitmap explode;
    Bitmap fatal;
    Bitmap splashPhoto;
    Bitmap sword;
    boolean sad = false;
    MediaPlayer bonus=new MediaPlayer();
    MediaPlayer stumble = new MediaPlayer();
    MediaPlayer boom=new MediaPlayer();
    MediaPlayer sadTrumpet = new MediaPlayer();
    float swordX = -3;
    float swordY = 0;
    int score = 0;
    int lives = 3;
    private Bitmap sadNinja;
    private Bitmap sadBg;
    private Paint gameOver = new Paint();
    private Bitmap[] life = new Bitmap[2];
    private Paint scorePaint = new Paint();
    private Paint levelPaint = new Paint();
    int decreaseFirstMove = 10;
    private boolean decreaseBool = false;
    private  boolean f1b = true;
    private boolean f2b = true;
    private boolean f3b = true;
    private boolean f4b=true;
    private Random fr = new Random();
    private Fruits f1,f2,f3,f4;
    Fruits waterMelon1=new WaterMelon();
    Fruits waterMelon2=new WaterMelon();
    Fruits SpecialBanana=SpecialPineapple.getInstance();
    Fruits SpecialCarrot=new SpecialCarrot();
    Fruits strawberry=new Strawberry();
    Fruits pineapple=new Pineapple();
    Fruits dangerBomb=new Danger();
    Fruits fatalBomb=new Fatal();
    Fruits dangerBomb2=new Danger();
    Fruits splash=new Splash();
    Fruits strawberry2=new Strawberry();
    Fruits fatalBomb2=new Fatal();
    Fruits SpecialCarrot2=new SpecialCarrot();






    public ArrayList<Fruits> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruits> fruits)
    {
        this.fruits = fruits;
    }


    public boolean isF1b() {
        return f1b;
    }


    public boolean isF2b() {
        return f2b;
    }


    public boolean isF3b() {
        return f3b;
    }


    public boolean isF4b() {
        return f4b;
    }




    public Fruits getF1() {
        return f1;
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


    public Fruits getF4() {
        return f4;
    }





    public Level3(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new ThreadController(getHolder(), this);
        setFocusable(true);
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




    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            score=activity.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        happyBg=BitmapFactory.decodeResource(getResources(),R.drawable.celebration);
        happyNinja=BitmapFactory.decodeResource(getResources(),R.drawable.happyninja);
        applause=MediaPlayer.create(getContext(),R.raw.applause);
        sadBg = BitmapFactory.decodeResource(getResources(), R.drawable.gameoverbg);
        sadNinja = BitmapFactory.decodeResource(getResources(), R.drawable.sad_ninja);

        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        timer = new Timer();
        timer.change();
        bg=BitmapFactory.decodeResource(getResources(),R.drawable.background2);



        //>>>>>>>>>>>>>>>>>>>>>>>>Paints and Audio<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        stumble = MediaPlayer.create(getContext(), R.raw.sword);
        sadTrumpet = MediaPlayer.create(getContext(), R.raw.sadtrumpet);
        boom=MediaPlayer.create(getContext(),R.raw.boom);
        bonus=MediaPlayer.create(getContext(),R.raw.bonus);

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



        //>>>>>>>>>>>>>>>>>>>>>>>>Sword<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        sword=BitmapFactory.decodeResource(getResources(),R.drawable.sword);


        //>>>>>>>>>>>>>>>>>>>>>Bombs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        dangerous=BitmapFactory.decodeResource(getResources(),R.drawable.dangerous);
        explode=BitmapFactory.decodeResource(getResources(),R.drawable.explode);
        fatal=BitmapFactory.decodeResource(getResources(),R.drawable.fatal_bomb);
        dangerBomb.setWholeFruit(dangerous);
        dangerBomb.setSlicedFruit(explode);
        dangerBomb2.setWholeFruit(dangerous);
        dangerBomb2.setSlicedFruit(explode);
        fatalBomb.setWholeFruit(fatal);
        fatalBomb.setSlicedFruit(explode);
        fatalBomb2.setWholeFruit(fatal);
        fatalBomb2.setSlicedFruit(explode);
        fruits.add(fatalBomb2);
        fruits.add(dangerBomb);
        fruits.add(fatalBomb);
        fruits.add(dangerBomb2);



        // >>>>>>>>>>>WaterMelons<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        wholeWaterMelon= BitmapFactory.decodeResource(getResources(), R.drawable.watermelonwhole);
        slicedWaterMelon=BitmapFactory.decodeResource(getResources(),R.drawable.watermeloncut);
        waterMelon1.setWholeFruit(wholeWaterMelon);
        waterMelon1.setSlicedFruit(slicedWaterMelon);
        waterMelon2.setWholeFruit(wholeWaterMelon);
        waterMelon2.setSlicedFruit(slicedWaterMelon);
        fruits.add(waterMelon1);
        fruits.add(waterMelon2);

        //>>>>>>>>>>>>>>>>>>>>>>Strawberry<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        wholeStrawberry=BitmapFactory.decodeResource(getResources(),R.drawable.strawberry1);
        slicedStrawberry=BitmapFactory.decodeResource(getResources(),R.drawable.cutstrawberry);
        strawberry.setWholeFruit(wholeStrawberry);
        strawberry.setSlicedFruit(slicedStrawberry);
        strawberry2.setWholeFruit(wholeStrawberry);
        strawberry2.setSlicedFruit(slicedStrawberry);
        fruits.add(strawberry);
        fruits.add(strawberry2);

//>>>>>>>>>>>>>>>>>>>>>>>Pineapple<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        wholePoneapple=BitmapFactory.decodeResource(getResources(),R.drawable.pineapple);
        slicedPineapple=BitmapFactory.decodeResource(getResources(),R.drawable.pineapplecut);
        pineapple.setWholeFruit(wholePoneapple);
        pineapple.setSlicedFruit(slicedPineapple);
        fruits.add(pineapple);

        //>>>>>>>>>>>>>>>>>>>>>>>>Splash Fruit<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        //>>>>>>>>>>>>>>>>>>>>Special Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        specialBanana=BitmapFactory.decodeResource(getResources(),R.drawable.specialpin);
        star=BitmapFactory.decodeResource(getResources(),R.drawable.star);
        SpecialBanana.setWholeFruit(specialBanana);
        SpecialBanana.setSlicedFruit(star);
        fruits.add(SpecialBanana);

        specialCherry=BitmapFactory.decodeResource(getResources(),R.drawable.carrotwhole);
        SpecialCarrot.setWholeFruit(specialCherry);
        SpecialCarrot.setSlicedFruit(star);
        SpecialCarrot2.setWholeFruit(specialCherry);
        SpecialCarrot2.setSlicedFruit(star);
        fruits.add(SpecialCarrot);
        fruits.add(SpecialCarrot2);

        factory=new HardFactory(this);
        Collections.shuffle(fruits);
        initialize();
        thread.setRunning(true);
        thread.start();
        level3=MediaPlayer.create(getContext(),R.raw.dizzy);

        level3.setVolume(20,20);
        level3.setLooping(true);
        level3.start();
        bonus.setVolume(10,10);


    }



    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }


    public void initialize() {
        f1 = fruits.get(0);
        f2 = fruits.get(1);
        f3 = fruits.get(2);
        f4=fruits.get(3);
        f1.setDecreasedMove(15);
        f2.setDecreasedMove(17);
        f3.setDecreasedMove(20);
        f4.setDecreasedMove(20);
        f1b = true;
        f2b = true;
        f3b = true;
        f4b=true;
        f1.setSlicedFlag(0);
        f2.setSlicedFlag(0);
        f3.setSlicedFlag(0);
        f4.setSlicedFlag(0);
    }




    public void sadNinja(Canvas canvas) {
        if (!sad) {
            x=timer.getSeconds();
            try {
                activity.save(Math.max(score,scoreX));
            } catch (IOException e) {
                e.printStackTrace();
            }
           // timer.change();
            sadTrumpet.start();
            sad = true;
        }
        if(timer.getSeconds()>=x+6)
            activity.returnIntent();
        canvas.drawBitmap(sadBg, 0, 0, null);
        canvas.drawText("Score:", 5, 55, scorePaint);
        canvas.drawText(Integer.toString(Math.max(score,scoreX)), 165, 55, scorePaint);
        canvas.drawText("level 3", canvas.getWidth() / 2, 55, levelPaint);
        canvas.drawBitmap(sadNinja, canvas.getWidth() / 2 - (sadNinja.getWidth() / 2), canvas.getHeight() / 2 - (sadNinja.getHeight() / 2) + 150, null);
        canvas.drawText("GAME OVER !", canvas.getWidth() / 2, (canvas.getHeight() / 4), gameOver);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        level3.stop();
        level3.release();
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
    public void drawLevel(Canvas canvas)  {
        super.draw(canvas);
        canvas.drawBitmap(bg,0,0,null);
        if (lives <= 0) {
            level3.stop();
           // timer.setTimerState(new StopState());
            sadNinja(canvas);

        } else if(timer.getSeconds()>=36) {
            try {
                happyNinja(canvas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


            else{

            canvas.drawBitmap(bg, 0, 0, null);
            canvas.drawText("BEST:", 5, 55, scorePaint);
            canvas.drawText("Score:",5,120,scorePaint);
            canvas.drawText(Integer.toString(score), 165, 55, scorePaint);
            canvas.drawText(Integer.toString(scoreX), 165, 120, scorePaint);
            canvas.drawText(String.valueOf(timer.getSeconds()), canvas.getWidth() / 2, 55, levelPaint);
            canvas.drawBitmap(sword, swordX, swordY, null);

            for (int i = 0; i < lives; i++)
                canvas.drawBitmap(life[0], canvas.getWidth() - ((i + 1) * 70), 5, null);
            if(timer.getSeconds()>=3) {
                Move(canvas);



            }
        }


    }

    @Override
    public void update() {
        if(timer.getSeconds()>=3) {
            factory.updateFirstFruit();
            factory.updateSecondFruit();
            factory.updateThirdFruit();
            factory.updateFourthFruit();
        }
    }





    //>>>>>>>>>>>>>>>Moving  Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    public void Move(Canvas canvas){


        if (outOf4 < 4) {
            firstFruit(canvas);
            secondFruit(canvas);
            thirdFruit(canvas);
            FourthFruit(canvas);

        } else {
            Log.d("Wsal=4", "Move: ");
            Collections.shuffle(fruits);
            initialize();
            outOf4 = 0;
            degrees = 1;

        }


        degrees += 1;
    }





    //  >>>>>>>>>>>>>>>>>>>>>>>Drawing of Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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
                    if(f1 instanceof Danger && scoreX>=4)
                        scoreX-=4;
                    else if(f1.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                    if(f1.getSlicedFlag()==1 && f1 instanceof Danger )
                        lives--;
                    if (f1.getSlicedFlag()==1 && f1 instanceof Fatal)
                        lives=0;
                }
                f1.setRotatedSlicedFruit(Bitmap.createBitmap(f1.getSlicedFruit(), 0, 0, f1.getSlicedFruit().getWidth(), f1.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f1.getRotatedSlicedFruit(), f1.getDimX(), f1.getDimY(), null);
                if(!(f1 instanceof Danger || f1 instanceof Fatal) && !f1.isBonus())
                    canvas.drawBitmap(f1.getRotatedSlicedFruit(), f1.getDimX() + (f1.getSlicedFruit().getWidth()), f1.getDimY(), null);

            }
            if (f1.getSlicedFlag() == 0) {
                if (f1.getDimX() > canvas.getWidth() - f1.getWholeFruit().getWidth() - 25)
                    f1.setFruitRight(false);
            } else if(!(f1 instanceof Danger || f1 instanceof Fatal) && !f1.isBonus()){
                if (f1.getDimX() > canvas.getWidth() - (2 * f1.getSlicedFruit().getWidth()) - 25)
                    f1.setFruitRight(false);
            }else{
                if (f1.getDimX() > canvas.getWidth() - f1.getSlicedFruit().getWidth() - 25)
                    f1.setFruitRight(false);
            }
            if (f1.getDimX() < 0)
                f1.setFruitRight(true);
            if (f1.getDimY() < 0)
                f1.setFruitUp(false);

            if (f1.getDimY() > canvas.getHeight() + 9) {
                if (lives > 0 && f1.getSlicedFlag() == 0 && !((f1 instanceof Fatal) ||(f1 instanceof Danger) ))
                    lives--;
                f1.setDimY(canvas.getHeight()+7);
                f1.setFruitUp(true);
                f1.setFruitRight(true);
                f1.setDimX(f1.getR().nextInt(f1.getR().nextInt(900)));
                f1b = false;
                f1.setCalculated(false);
                outOf4++;
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

                    if(f2 instanceof Danger && scoreX>=4)
                        scoreX-=4;
                    else if(f2.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;
                    if(f2.getSlicedFlag()==1 && f2 instanceof Danger )
                        lives--;
                    if (f2.getSlicedFlag()==1 && f2 instanceof Fatal)
                        lives=0;

                }
                f2.setRotatedSlicedFruit(Bitmap.createBitmap(f2.getSlicedFruit(), 0, 0, f2.getSlicedFruit().getWidth(), f2.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f2.getRotatedSlicedFruit(), f2.getDimX(), f2.getDimY(), null);
                if(!(f2 instanceof Danger || f2 instanceof Fatal) && !f2.isBonus())

                    canvas.drawBitmap(f2.getRotatedSlicedFruit(), f2.getDimX() + (f2.getSlicedFruit().getWidth()), f2.getDimY(), null);

            }
            if (f2.getSlicedFlag() == 0 ) {
                if (f2.getDimX() > canvas.getWidth() - f2.getWholeFruit().getWidth() - 20)
                    f2.setFruitRight(false);
            } else if( !(f2 instanceof Danger || f2 instanceof Fatal) && !f2.isBonus()){
                if (f2.getDimX() > canvas.getWidth() - (2 * f2.getSlicedFruit().getWidth()) - 20)
                    f2.setFruitRight(false);
            }else{
                if (f2.getDimX() > canvas.getWidth() - f2.getSlicedFruit().getWidth() - 20)
                    f2.setFruitRight(false);
            }
            if (f2.getDimX() < 0)
                f2.setFruitRight(true);
            if (f2.getDimY() < 0)
                f2.setFruitUp(false);

            if (f2.getDimY() > canvas.getHeight() + 9) {
                if (f2.getSlicedFlag() == 0 && lives > 0 && !((f2 instanceof Fatal) ||(f2 instanceof Danger) ))
                    lives--;
                f2.setDimY(canvas.getHeight()+7);
                f2.setFruitUp(true);
                f2.setFruitRight(true);
                f2.setDimX(f2.getR().nextInt(200));
                f2b = false;
                f2.setCalculated(false);
                outOf4++;
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
                    if(f3 instanceof Danger && scoreX>=4)
                        scoreX-=4;
                    else if(f3.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;
                    if(f3.getSlicedFlag()==1 && f3 instanceof Danger )
                        lives--;
                    if (f3.getSlicedFlag()==1 && f3 instanceof Fatal)
                        lives=0;
                }
                f3.setRotatedSlicedFruit(Bitmap.createBitmap(f3.getSlicedFruit(), 0, 0, f3.getSlicedFruit().getWidth(), f3.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f3.getRotatedSlicedFruit(), f3.getDimX(), f3.getDimY(), null);
                if( !(f3 instanceof Danger || f3 instanceof Fatal) && !f3.isBonus())
                    canvas.drawBitmap(f3.getRotatedSlicedFruit(), f3.getDimX() + (f3.getSlicedFruit().getWidth()), f3.getDimY(), null);
            }
            if (f3.getSlicedFlag() == 0) {
                if (f3.getDimX() > canvas.getWidth() - f3.getWholeFruit().getWidth() - 20)
                    f3.setFruitRight(false);
            } else if( !(f3 instanceof Danger || f3 instanceof Fatal) && !f3.isBonus()) {
                if (f3.getDimX() > canvas.getWidth() - (2 * f3.getSlicedFruit().getWidth()) - 20)
                    f3.setFruitRight(false);
            }else{
                if (f3.getDimX() > canvas.getWidth() - f3.getSlicedFruit().getWidth() - 20)
                    f3.setFruitRight(false);
            }
            if (f3.getDimX() < 0)
                f3.setFruitRight(true);
            if (f3.getDimY() < 0)
                f3.setFruitUp(false);

            if (f3.getDimY() > canvas.getHeight() + 9) {
                if (f3.getSlicedFlag() == 0 && lives > 0 &&   !((f3 instanceof Fatal) ||(f3 instanceof Danger) ))
                    lives--;
                f3.setDimY(canvas.getHeight()+7);
                f3.setFruitUp(true);
                f3.setFruitRight(true);
                f3.setDimX(f3.getR().nextInt(600)+600);
                outOf4++;
                f3.setCalculated(false);
                f3b = false;

            }
        }
    }





    public void FourthFruit(Canvas canvas) {
        if (f4b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, f4.getWholeFruit().getWidth() / 2, f4.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (f4.getSlicedFlag() == 0) {
                f4.setRotatedWholeFruit(Bitmap.createBitmap(f4.getWholeFruit(), 0, 0, f4.getWholeFruit().getWidth(), f4.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f4.getRotatedWholeFruit(), f4.getDimX(), f4.getDimY(), null);
            } else {

                if (!f4.isCalculated()) {
                    f4.setCalculated(true);
                    if(f4 instanceof Danger && scoreX>=4)
                        scoreX-=4;
                    else if(f4.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;
                    if(f4.getSlicedFlag()==1 && f4 instanceof Danger )
                        lives--;
                    if (f4.getSlicedFlag()==1 && f4 instanceof Fatal)
                        lives=0;
                }
                f4.setRotatedSlicedFruit(Bitmap.createBitmap(f4.getSlicedFruit(), 0, 0, f4.getSlicedFruit().getWidth(), f4.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f4.getRotatedSlicedFruit(), f4.getDimX(), f4.getDimY(), null);
                if( !(f4 instanceof Danger || f4 instanceof Fatal) && !f4.isBonus())
                    canvas.drawBitmap(f4.getRotatedSlicedFruit(), f4.getDimX() + (f4.getSlicedFruit().getWidth()), f4.getDimY(), null);
            }
            if (f4.getSlicedFlag() == 0) {
                if (f4.getDimX() > canvas.getWidth() - f4.getWholeFruit().getWidth() - 16)
                    f4.setFruitRight(false);
            } else if( !(f4 instanceof Danger || f4 instanceof Fatal) && !f4.isBonus()) {
                if (f4.getDimX() > canvas.getWidth() - (2 * f4.getSlicedFruit().getWidth()) - 16)
                    f4.setFruitRight(false);
            }else{
                if (f4.getDimX() > canvas.getWidth() - f4.getSlicedFruit().getWidth() - 16)
                    f4.setFruitRight(false);
            }
            if (f4.getDimX() < 0)
                f4.setFruitRight(true);
            if (f4.getDimY() < 0)
                f4.setFruitUp(false);

            if (f4.getDimY() > canvas.getHeight() + 9) {
                if (f4.getSlicedFlag() == 0 && lives > 0 &&   !((f4 instanceof Fatal) ||(f4 instanceof Danger) ))
                    lives--;
                f4.setDimY(canvas.getHeight()+7);
                f4.setFruitUp(true);
                f4.setFruitRight(true);
                f4.setDimX(f4.getR().nextInt(600)+600);
                outOf4++;
                f4.setCalculated(false);
                f4b = false;

            }
        }
    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();
            swordX = x;
            swordY = y;


            //          >>>>>>>>First fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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


            //>>>>>>>>>>>>>>>>>>>>>>>Fourth fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            if (x > f4.getDimX() && x < f4.getDimX() + f4.getWholeFruit().getWidth() + 4 &&
                    y > f4.getDimY() && y < f4.getDimY() + f4.getWholeFruit().getHeight() + 4) {
                f4.setSlicedFlag(1);
                if (f4 instanceof Danger)
                    boom.start();
                else if (f4.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }


        }
        return true;
    }




    public void happyNinja(Canvas canvas) throws IOException {

        SpecialBanana.setDimX((float) SpecialBanana.getR().nextInt(325)+700);
        SpecialBanana.setDimY(740);
        SpecialBanana.setFruitRight(false);
        SpecialBanana.setSlicedFlag(0);
        SpecialBanana.setFruitUp(true);
        SpecialBanana.setCalculated(false);
        SpecialBanana.setBonus(true);
        if (!happy) {

            activity.save(score);
            level3.stop();
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
            Intent intent=new Intent(getContext(), Last.class);
            activity.startIntent(intent);
        }

        //


        canvas.drawBitmap(happyBg, 0, 0, null);
        canvas.drawText("Score:", 5, 55, scorePaint);
        canvas.drawText(Integer.toString(Math.max(score,scoreX)), 165, 55, scorePaint);
        canvas.drawText("level 3", canvas.getWidth() / 2, 55, levelPaint);
        canvas.drawBitmap(happyNinja, canvas.getWidth() / 2 - (happyNinja.getWidth() / 2), canvas.getHeight() / 2 - (happyNinja.getHeight() / 2) + 150, null);
        // canvas.drawText("YOU WIN !", canvas.getWidth() / 2, (canvas.getHeight() / 4), win);
    }

}
