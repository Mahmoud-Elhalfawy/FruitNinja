package com.example.android.trial.Gui;

import android.content.Context;
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
import com.example.android.trial.Factories.BonusFactory;
import com.example.android.trial.Factories.HardFactory;
import com.example.android.trial.Factories.MediumFactory;
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

public class Bonus extends SurfaceView implements Strategy, SurfaceHolder.Callback {
    int scoreX=0;
    MediaPlayer applause=new MediaPlayer();
    Last activity;
    boolean happy=false;
    int x=0;
    public Last getActivity() {
        return activity;
    }

    public void setActivity(Last activity) {
        this.activity = activity;
    }
int outOf5v=0;
    Boolean music=false;
    Bitmap happyNinja;
    Bitmap happyBg;
    MediaPlayer level3=new MediaPlayer();
    private BonusFactory factory;
    float degrees = 1;
    private int outOf5=0;
    private Timer timer;
    ThreadController thread;
    ArrayList<Fruits> fruitsH=new ArrayList<>();
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
    private boolean f5b=true;

    public boolean isV1b() {
        return v1b;
    }

    public void setV1b(boolean v1b) {
        this.v1b = v1b;
    }

    public boolean isV2b() {
        return v2b;
    }

    public void setV2b(boolean v2b) {
        this.v2b = v2b;
    }

    public boolean isV3b() {
        return v3b;
    }

    public void setV3b(boolean v3b) {
        this.v3b = v3b;
    }

    public boolean isV4b() {
        return v4b;
    }

    public void setV4b(boolean v4b) {
        this.v4b = v4b;
    }

    public boolean isV5b() {
        return v5b;
    }

    public void setV5b(boolean v5b) {
        this.v5b = v5b;
    }

    public Fruits getV1() {
        return v1;
    }

    public void setV1(Fruits v1) {
        this.v1 = v1;
    }

    public Fruits getV2() {
        return v2;
    }

    public void setV2(Fruits v2) {
        this.v2 = v2;
    }

    public Fruits getV3() {
        return v3;
    }

    public void setV3(Fruits v3) {
        this.v3 = v3;
    }

    public Fruits getV4() {
        return v4;
    }

    public void setV4(Fruits v4) {
        this.v4 = v4;
    }

    public Fruits getV5() {
        return v5;
    }

    public void setV5(Fruits v5) {
        this.v5 = v5;
    }

    private  boolean v1b = true;
    private boolean v2b = true;
    private boolean v3b = true;
    private boolean v4b=true;
    private boolean v5b=true;



    private Random fr = new Random();
    private Fruits f1,f2,f3,f4,f5,v1,v2,v3,v4,v5;
    Fruits waterMelon1=new WaterMelon();
    Fruits waterMelon2=new WaterMelon();
    Fruits SpecialBanana= SpecialPineapple.getInstance();
    Fruits SpecialCarrot=new SpecialCarrot();
    Fruits strawberry=new Strawberry();
    Fruits pineapple=new Pineapple();
   Fruits specialCarrot3=new SpecialCarrot();
   Fruits strawberry3=new Strawberry();
    Fruits strawberry2=new Strawberry();
    Fruits specialCarrot4=new SpecialCarrot();
    Fruits SpecialCarrot2=new SpecialCarrot();
    Fruits pineapple2=new Pineapple();

//>>>>>>>>>>>>>>>>>Vertical List<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    Fruits waterMelon1v=new WaterMelon();
    Fruits waterMelon2v=new WaterMelon();
    Fruits SpecialBananav= SpecialPineapple.getInstance();
    Fruits SpecialCarrotv=new SpecialCarrot();
    Fruits strawberryv=new Strawberry();
    Fruits pineapplev=new Pineapple();
    Fruits specialCarrot3v=new SpecialCarrot();
    Fruits strawberry3v=new Strawberry();
    Fruits strawberry2v=new Strawberry();
    Fruits specialCarrot4v=new SpecialCarrot();
    Fruits SpecialCarrot2v=new SpecialCarrot();
    Fruits pineapple2v=new Pineapple();
    ArrayList<Fruits> fruitsV=new ArrayList<>();


    public ArrayList<Fruits> getFruits() {
        return fruitsH;
    }

    public void setFruits(ArrayList<Fruits> fruitsH)
    {
        this.fruitsH = fruitsH;
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





    public Bonus(Context context) {
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


    public boolean isF5b() {
        return f5b;
    }

    public void setF5b(boolean f5b) {
        this.f5b = f5b;
    }

    public Fruits getF5() {
        return f5;
    }

    public void setF5(Fruits f5) {
        this.f5 = f5;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            score=activity.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        happyBg= BitmapFactory.decodeResource(getResources(), R.drawable.celebration);
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



        // >>>>>>>>>>>WaterMelons<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        wholeWaterMelon= BitmapFactory.decodeResource(getResources(), R.drawable.watermelonwhole);
        slicedWaterMelon=BitmapFactory.decodeResource(getResources(),R.drawable.watermeloncut);
        waterMelon1.setWholeFruit(wholeWaterMelon);
        waterMelon1.setSlicedFruit(slicedWaterMelon);
        waterMelon2.setWholeFruit(wholeWaterMelon);
        waterMelon2.setSlicedFruit(slicedWaterMelon);

        waterMelon1v.setWholeFruit(wholeWaterMelon);
        waterMelon1v.setSlicedFruit(slicedWaterMelon);
        waterMelon2v.setWholeFruit(wholeWaterMelon);
        waterMelon2v.setSlicedFruit(slicedWaterMelon);

        fruitsH.add(waterMelon1);
        fruitsH.add(waterMelon2);

        fruitsV.add(waterMelon1v);
        fruitsV.add(waterMelon2v);
        //>>>>>>>>>>>>>>>>>>>>>>Strawberry<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        wholeStrawberry=BitmapFactory.decodeResource(getResources(),R.drawable.strawberry1);
        slicedStrawberry=BitmapFactory.decodeResource(getResources(),R.drawable.cutstrawberry);
        strawberry.setWholeFruit(wholeStrawberry);
        strawberry.setSlicedFruit(slicedStrawberry);
        strawberry2.setWholeFruit(wholeStrawberry);
        strawberry2.setSlicedFruit(slicedStrawberry);
        strawberry3.setWholeFruit(wholeStrawberry);
        strawberry3.setSlicedFruit(slicedStrawberry);
        fruitsH.add(strawberry);
        fruitsH.add(strawberry2);
        fruitsH.add(strawberry3);





        strawberryv.setWholeFruit(wholeStrawberry);
        strawberryv.setSlicedFruit(slicedStrawberry);
        strawberry2v.setWholeFruit(wholeStrawberry);
        strawberry2v.setSlicedFruit(slicedStrawberry);
        strawberry3v.setWholeFruit(wholeStrawberry);
        strawberry3v.setSlicedFruit(slicedStrawberry);
        fruitsV.add(strawberryv);
        fruitsV.add(strawberry2v);
        fruitsV.add(strawberry3v);


//>>>>>>>>>>>>>>>>>>>>>>>Pineapple<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        wholePoneapple=BitmapFactory.decodeResource(getResources(),R.drawable.pineapple);
        slicedPineapple=BitmapFactory.decodeResource(getResources(),R.drawable.pineapplecut);
        pineapple.setWholeFruit(wholePoneapple);
        pineapple.setSlicedFruit(slicedPineapple);
        fruitsH.add(pineapple);

        pineapple2.setWholeFruit(wholePoneapple);
        pineapple2.setSlicedFruit(slicedPineapple);
        fruitsH.add(pineapple2);




        pineapplev.setWholeFruit(wholePoneapple);
        pineapplev.setSlicedFruit(slicedPineapple);
        fruitsV.add(pineapplev);

        pineapple2v.setWholeFruit(wholePoneapple);
        pineapple2v.setSlicedFruit(slicedPineapple);
        fruitsV.add(pineapple2v);

        //>>>>>>>>>>>>>>>>>>>>>>>>Splash Fruit<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        //>>>>>>>>>>>>>>>>>>>>Special Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        specialBanana=BitmapFactory.decodeResource(getResources(),R.drawable.specialpin);
        star=BitmapFactory.decodeResource(getResources(),R.drawable.star);
        SpecialBanana.setWholeFruit(specialBanana);
        SpecialBanana.setSlicedFruit(star);
        fruitsH.add(SpecialBanana);

        specialCherry=BitmapFactory.decodeResource(getResources(),R.drawable.carrotwhole);
        SpecialCarrot.setWholeFruit(specialCherry);
        SpecialCarrot.setSlicedFruit(star);
        SpecialCarrot2.setWholeFruit(specialCherry);
        SpecialCarrot2.setSlicedFruit(star);
        specialCarrot3.setWholeFruit(specialCherry);
        specialCarrot3.setSlicedFruit(star);
        specialCarrot4.setWholeFruit(specialCherry);
        specialCarrot4.setSlicedFruit(star);
        fruitsH.add(SpecialCarrot);
        fruitsH.add(SpecialCarrot2);
        fruitsH.add(specialCarrot3);
        fruitsH.add(specialCarrot4);



        SpecialBananav.setWholeFruit(specialBanana);
        SpecialBananav.setSlicedFruit(star);
        fruitsV.add(SpecialBananav);

        SpecialCarrotv.setWholeFruit(specialCherry);
        SpecialCarrotv.setSlicedFruit(star);
        SpecialCarrot2v.setWholeFruit(specialCherry);
        SpecialCarrot2v.setSlicedFruit(star);
        specialCarrot3v.setWholeFruit(specialCherry);
        specialCarrot3v.setSlicedFruit(star);
        specialCarrot4v.setWholeFruit(specialCherry);
        specialCarrot4v.setSlicedFruit(star);
        fruitsV.add(SpecialCarrotv);
        fruitsV.add(SpecialCarrot2v);
        fruitsV.add(specialCarrot3v);
        fruitsV.add(specialCarrot4v);






        factory=new BonusFactory(this);
        Collections.shuffle(fruitsH);
        initializeh();
        initializev();
        thread.setRunning(true);
        thread.start();
        level3=MediaPlayer.create(getContext(),R.raw.tequila);

        level3.setVolume(50,50);
        level3.setLooping(true);
        level3.start();
        bonus.setVolume(10,10);


    }



    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }

public void initializev(){
    v1 = fruitsV.get(0);
    v2 = fruitsV.get(1);
    v3 = fruitsV.get(2);
    v4=fruitsV.get(3);
    v5=fruitsV.get(4);

    v1.setFruitRight(true);
    v2.setFruitRight(true);
    v3.setFruitRight(true);
    v4.setFruitRight(true);
    v5.setFruitRight(true);
    v1b = true;
    v2b = true;
    v3b = true;
    v4b=true;
    v5b=true;
    v1.setSlicedFlag(0);
    v2.setSlicedFlag(0);
    v3.setSlicedFlag(0);
    v4.setSlicedFlag(0);
    v5.setSlicedFlag(0);

    v1.setDimY(820);
    v2.setDimY(820);
    v3.setDimY(820);
    v4.setDimY(820);
    v5.setDimY(820);

    v1.setDimX(100);
    v2.setDimX(250);
    v3.setDimX(450);
    v4.setDimX(650);
    v5.setDimX(850);



}
    public void initializeh() {
        f1 = fruitsH.get(0);
        f2 = fruitsH.get(1);
        f3 = fruitsH.get(2);
        f4=fruitsH.get(3);
        f5=fruitsH.get(4);

        f1.setFruitRight(true);
        f2.setFruitRight(true);
        f3.setFruitRight(true);
        f4.setFruitRight(true);
        f5.setFruitRight(true);
        f1b = true;
        f2b = true;
        f3b = true;
        f4b=true;
        f5b=true;
        f1.setSlicedFlag(0);
        f2.setSlicedFlag(0);
        f3.setSlicedFlag(0);
        f4.setSlicedFlag(0);
        f5.setSlicedFlag(0);
        f1.setDimX(-20);
        f2.setDimX(-20);
        f3.setDimX(-20);
        f4.setDimX(-20);
        f5.setDimX(-20);

        f1.setDimY(50);
        f2.setDimY(200);
        f3.setDimY(350);
        f4.setDimY(500);
        f5.setDimY(600);




    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Vvvvvvvvvvv<<<<<<<<<<<<<<<<<<<<<<<<<














    }




    public void sadNinja(Canvas canvas) {
        if (!sad) {
            x=timer.getSeconds();
            try {
                activity.save(Math.max(score,scoreX));
            } catch (IOException e) {
                e.printStackTrace();
            }
             //timer.change();
            sadTrumpet.start();
            sad = true;
        }
        if(timer.getSeconds()>=x+6)
            //activity.returnIntent();
        canvas.drawBitmap(sadBg, 0, 0, null);
        canvas.drawText("Score:", 5, 55, scorePaint);
        canvas.drawText(Integer.toString(Math.max(score,scoreX)), 165, 55, scorePaint);
        canvas.drawText("Bonus", canvas.getWidth() / 2, 55, levelPaint);
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
        Log.d("Width", String.valueOf(canvas.getHeight()));

        canvas.drawBitmap(bg,0,0,null);


          if(timer.getSeconds()>=40) {
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
            canvas.drawText("BONUS LEVEL", canvas.getWidth() / 2, 55, levelPaint);
            canvas.drawBitmap(sword, swordX, swordY, null);

            if(timer.getSeconds()>=2) {
                Move(canvas);



            }
        }


    }

    @Override
    public void update() {
        if(timer.getSeconds()>=2F) {
            factory.updateFirstFruit();
            factory.updateSecondFruit();
            factory.updateThirdFruit();
            factory.updateFourthFruit();
            factory.updateFifthFruit();
            factory.updateV1Fruit();
            factory.updateV2Fruit();
            factory.updateV3Fruit();
            factory.updateV4Fruit();
            factory.updateV5Fruit();

        }
    }





    //>>>>>>>>>>>>>>>Moving  Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    public void Move(Canvas canvas){

        if (outOf5 < 5 ) {
            firstFruit(canvas);
            secondFruit(canvas);
            thirdFruit(canvas);
            FourthFruit(canvas);
            FifthFruit(canvas);
            V1Fruit(canvas);
            V2Fruit(canvas);
            V3Fruit(canvas);
            V4Fruit(canvas);
            V5Fruit(canvas);
        } else {
            Log.d("Wsal=4", "Move: ");
            Collections.shuffle(fruitsH);
            initializeh();
            outOf5 = 0;
            degrees = 1;

        }


      if(outOf5v<5){
          V1Fruit(canvas);
          V2Fruit(canvas);
          V3Fruit(canvas);
          V4Fruit(canvas);
          V5Fruit(canvas);
      }else{
          Collections.shuffle(fruitsV);
          initializev();

          outOf5v=0;
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

                    if(f1.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                f1.setRotatedSlicedFruit(Bitmap.createBitmap(f1.getSlicedFruit(), 0, 0, f1.getSlicedFruit().getWidth(), f1.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f1.getRotatedSlicedFruit(), f1.getDimX(), f1.getDimY(), null);
            }
            if (f1.getSlicedFlag() == 0) {
                if (f1.getDimX() > canvas.getWidth() - f1.getWholeFruit().getWidth() - 35)
                    f1.setFruitRight(false);
            } else if(!(f1 instanceof Danger || f1 instanceof Fatal) && !f1.isBonus()){
                if (f1.getDimX() > canvas.getWidth() - (2 * f1.getSlicedFruit().getWidth()) - 35)
                    f1.setFruitRight(false);
            }else{
                if (f1.getDimX() > canvas.getWidth() - f1.getSlicedFruit().getWidth() - 35)
                    f1.setFruitRight(false);
            }



            if (f1.getDimX() < -30) {

                f1.setDimX(-15);
                f1.setFruitUp(true);
                f1.setFruitRight(true);
                f1.setDimY(f1.getR().nextInt(f1.getR().nextInt(300)));
                f1b = false;
                f1.setCalculated(false);
                outOf5++;
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

                    if(f2.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                f2.setRotatedSlicedFruit(Bitmap.createBitmap(f2.getSlicedFruit(), 0, 0, f2.getSlicedFruit().getWidth(), f2.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f2.getRotatedSlicedFruit(), f2.getDimX(), f2.getDimY(), null);
            }
            if (f2.getSlicedFlag() == 0) {
                if (f2.getDimX() > canvas.getWidth() - f2.getWholeFruit().getWidth() - 35)
                    f2.setFruitRight(false);
            } else if(!(f2 instanceof Danger || f2 instanceof Fatal) && !f2.isBonus()){
                if (f2.getDimX() > canvas.getWidth() - (2 * f2.getSlicedFruit().getWidth()) - 35)
                    f2.setFruitRight(false);
            }else{
                if (f2.getDimX() > canvas.getWidth() - f2.getSlicedFruit().getWidth() - 35)
                    f2.setFruitRight(false);
            }



            if (f2.getDimX() < -30) {

                f2.setDimX(-15);
                f2.setFruitUp(true);
                f2.setFruitRight(true);
                f2.setDimY(f2.getR().nextInt(f2.getR().nextInt(300))+100);
                f2b = false;
                f2.setCalculated(false);
                outOf5++;
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

                    if(f3.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                f3.setRotatedSlicedFruit(Bitmap.createBitmap(f3.getSlicedFruit(), 0, 0, f3.getSlicedFruit().getWidth(), f3.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f3.getRotatedSlicedFruit(), f3.getDimX(), f3.getDimY(), null);
            }
            if (f3.getSlicedFlag() == 0) {
                if (f3.getDimX() > canvas.getWidth() - f3.getWholeFruit().getWidth() - 35)
                    f3.setFruitRight(false);
            } else if(!(f3 instanceof Danger || f3 instanceof Fatal) && !f3.isBonus()){
                if (f3.getDimX() > canvas.getWidth() - (2 * f3.getSlicedFruit().getWidth()) - 35)
                    f3.setFruitRight(false);
            }else{
                if (f3.getDimX() > canvas.getWidth() - f3.getSlicedFruit().getWidth() - 35)
                    f3.setFruitRight(false);
            }



            if (f3.getDimX() < -30) {

                f3.setDimX(-15);
                f3.setFruitUp(true);
                f3.setFruitRight(true);
                f3.setDimY(f3.getR().nextInt(f3.getR().nextInt(300)));
                f3b = false;
                f3.setCalculated(false);
                outOf5++;
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

                    if(f4.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                f4.setRotatedSlicedFruit(Bitmap.createBitmap(f4.getSlicedFruit(), 0, 0, f4.getSlicedFruit().getWidth(), f4.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f4.getRotatedSlicedFruit(), f4.getDimX(), f4.getDimY(), null);
            }
            if (f4.getSlicedFlag() == 0) {
                if (f4.getDimX() > canvas.getWidth() - f4.getWholeFruit().getWidth() - 35)
                    f4.setFruitRight(false);
            } else if(!(f4 instanceof Danger || f4 instanceof Fatal) && !f4.isBonus()){
                if (f4.getDimX() > canvas.getWidth() - (2 * f4.getSlicedFruit().getWidth()) - 35)
                    f4.setFruitRight(false);
            }else{
                if (f4.getDimX() > canvas.getWidth() - f4.getSlicedFruit().getWidth() - 35)
                    f4.setFruitRight(false);
            }



            if (f4.getDimX() < -30) {

                f4.setDimX(-15);
                f4.setFruitUp(true);
                f4.setFruitRight(true);
                f4.setDimY(f4.getR().nextInt(f4.getR().nextInt(300)));
                f4b = false;
                f4.setCalculated(false);
                outOf5++;
            }
        }
    }



    public void FifthFruit(Canvas canvas) {
        if (f5b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, f5.getWholeFruit().getWidth() / 2, f5.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (f5.getSlicedFlag() == 0) {
                f5.setRotatedWholeFruit(Bitmap.createBitmap(f5.getWholeFruit(), 0, 0, f5.getWholeFruit().getWidth(), f5.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f5.getRotatedWholeFruit(), f5.getDimX(), f5.getDimY(), null);
            } else {
                if (!f5.isCalculated()) {
                    f5.setCalculated(true);

                    if(f5.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                f5.setRotatedSlicedFruit(Bitmap.createBitmap(f5.getSlicedFruit(), 0, 0, f5.getSlicedFruit().getWidth(), f5.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(f5.getRotatedSlicedFruit(), f5.getDimX(), f5.getDimY(), null);
            }
            if (f5.getSlicedFlag() == 0) {
                if (f5.getDimX() > canvas.getWidth() - f5.getWholeFruit().getWidth() - 35)
                    f5.setFruitRight(false);
            } else if(!(f5 instanceof Danger || f5 instanceof Fatal) && !f5.isBonus()){
                if (f5.getDimX() > canvas.getWidth() - (2 * f5.getSlicedFruit().getWidth()) - 35)
                    f5.setFruitRight(false);
            }else{
                if (f5.getDimX() > canvas.getWidth() - f5.getSlicedFruit().getWidth() - 35)
                    f5.setFruitRight(false);
            }



            if (f5.getDimX() < -30) {

                f5.setDimX(-7);
                f5.setFruitUp(true);
                f5.setFruitRight(true);
                f5.setDimY(f5.getR().nextInt(f5.getR().nextInt(300)));
                f5b = false;
                f5.setCalculated(false);
                outOf5++;
            }
        }
    }








    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>New Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<






    public void V1Fruit(Canvas canvas) {
        if (v1b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, v1.getWholeFruit().getWidth() / 2, v1.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (v1.getSlicedFlag() == 0) {
                v1.setRotatedWholeFruit(Bitmap.createBitmap(v1.getWholeFruit(), 0, 0, v1.getWholeFruit().getWidth(), v1.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v1.getRotatedWholeFruit(), v1.getDimX(), v1.getDimY(), null);
            } else {
                if (!v1.isCalculated()) {
                    v1.setCalculated(true);

                    if(v1.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                v1.setRotatedSlicedFruit(Bitmap.createBitmap(v1.getSlicedFruit(), 0, 0, v1.getSlicedFruit().getWidth(), v1.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v1.getRotatedSlicedFruit(), v1.getDimX(), v1.getDimY(), null);
            }


                if(v1.getDimY()<0)
                    v1.setFruitUp(false);
            if (v1.getDimY() > canvas.getHeight()+25) {

                v1.setDimX(100);
                v1.setFruitUp(true);
                v1.setFruitRight(true);
                v1.setDimY(820);
                v1b = false;
                v1.setCalculated(false);
                outOf5v++;
            }
        }
    }





    public void V2Fruit(Canvas canvas) {
        if (v2b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, v2.getWholeFruit().getWidth() / 2, v2.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (v2.getSlicedFlag() == 0) {
                v2.setRotatedWholeFruit(Bitmap.createBitmap(v2.getWholeFruit(), 0, 0, v2.getWholeFruit().getWidth(), v2.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v2.getRotatedWholeFruit(), v2.getDimX(), v2.getDimY(), null);
            } else {
                if (!v2.isCalculated()) {
                    v2.setCalculated(true);

                    if(v2.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                v2.setRotatedSlicedFruit(Bitmap.createBitmap(v2.getSlicedFruit(), 0, 0, v2.getSlicedFruit().getWidth(), v2.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v2.getRotatedSlicedFruit(), v2.getDimX(), v2.getDimY(), null);
            }


            if(v2.getDimY()<0)
                v2.setFruitUp(false);
            if (v2.getDimY() > canvas.getHeight()+25) {

                v2.setDimX(300);
                v2.setFruitUp(true);
                v2.setFruitRight(true);
                v2.setDimY(820);
                v2b = false;
                v2.setCalculated(false);
                outOf5v++;
            }
        }
    }






    public void V3Fruit(Canvas canvas) {
        if (v3b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, v3.getWholeFruit().getWidth() / 2, v3.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (v3.getSlicedFlag() == 0) {
                v3.setRotatedWholeFruit(Bitmap.createBitmap(v3.getWholeFruit(), 0, 0, v3.getWholeFruit().getWidth(), v3.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v3.getRotatedWholeFruit(), v3.getDimX(), v3.getDimY(), null);
            } else {
                if (!v3.isCalculated()) {
                    v3.setCalculated(true);

                    if(v3.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                v3.setRotatedSlicedFruit(Bitmap.createBitmap(v3.getSlicedFruit(), 0, 0, v3.getSlicedFruit().getWidth(), v3.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v3.getRotatedSlicedFruit(), v3.getDimX(), v3.getDimY(), null);
            }


            if(v3.getDimY()<0)
                v3.setFruitUp(false);
            if (v3.getDimY() > canvas.getHeight()+25) {

                v3.setDimX(450);
                v3.setFruitUp(true);
                v3.setFruitRight(true);
                v3.setDimY(820);
                v3b = false;
                v3.setCalculated(false);
                outOf5v++;
            }
        }
    }









    public void V4Fruit(Canvas canvas) {
        if (v4b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, v4.getWholeFruit().getWidth() / 2, v4.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (v4.getSlicedFlag() == 0) {
                v4.setRotatedWholeFruit(Bitmap.createBitmap(v4.getWholeFruit(), 0, 0, v4.getWholeFruit().getWidth(), v4.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v4.getRotatedWholeFruit(), v4.getDimX(), v4.getDimY(), null);
            } else {
                if (!v4.isCalculated()) {
                    v4.setCalculated(true);

                    if(v4.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                v4.setRotatedSlicedFruit(Bitmap.createBitmap(v4.getSlicedFruit(), 0, 0, v4.getSlicedFruit().getWidth(), v4.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v4.getRotatedSlicedFruit(), v4.getDimX(), v4.getDimY(), null);
            }


            if(v4.getDimY()<0)
                v4.setFruitUp(false);
            if (v4.getDimY() > canvas.getHeight()+25) {

                v4.setDimX(650);
                v4.setFruitUp(true);
                v4.setFruitRight(true);
                v4.setDimY(820);
                v4b = false;
                v4.setCalculated(false);
                outOf5v++;
            }
        }
    }




    public void V5Fruit(Canvas canvas) {
        if (v5b) {
            Matrix matrix = new Matrix();
            matrix.postRotate(degrees, v5.getWholeFruit().getWidth() / 2, v5.getWholeFruit().getHeight() / 2);
            Log.d("width", Float.toString(canvas.getWidth()));
            Log.d("height", Float.toString(canvas.getHeight()));
            if (v5.getSlicedFlag() == 0) {
                v5.setRotatedWholeFruit(Bitmap.createBitmap(v5.getWholeFruit(), 0, 0, v5.getWholeFruit().getWidth(), v5.getWholeFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v5.getRotatedWholeFruit(), v5.getDimX(), v5.getDimY(), null);
            } else {
                if (!v5.isCalculated()) {
                    v5.setCalculated(true);

                    if(v5.isBonus())
                        scoreX+=8;
                    else
                        scoreX += 4;


                }
                v5.setRotatedSlicedFruit(Bitmap.createBitmap(v5.getSlicedFruit(), 0, 0, v5.getSlicedFruit().getWidth(), v5.getSlicedFruit().getHeight(), matrix, true));
                canvas.drawBitmap(v5.getRotatedSlicedFruit(), v5.getDimX(), v5.getDimY(), null);
            }


            if(v5.getDimY()<0)
                v5.setFruitUp(false);
            if (v5.getDimY() > canvas.getHeight()+25) {

                v5.setDimX(850);
                v5.setFruitUp(true);
                v5.setFruitRight(true);
                v5.setDimY(820);
                v5b = false;
                v5.setCalculated(false);
                outOf5v++;
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

            //>>>>>>>>>>>>>>>>>Fifth fruit touch<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            if (x > f5.getDimX() && x < f5.getDimX() + f5.getWholeFruit().getWidth() + 4 &&
                    y > f5.getDimY() && y < f5.getDimY() + f5.getWholeFruit().getHeight() + 4) {
                f5.setSlicedFlag(1);
                if (f5 instanceof Danger)
                    boom.start();
                else if (f5.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }







            //>>>>>>>>>>>>>>>>>>>.New Fruits<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


            if (x > v1.getDimX() && x < v1.getDimX() + v1.getWholeFruit().getWidth() + 4 &&
                    y > v1.getDimY() && y < v1.getDimY() + v1.getWholeFruit().getHeight() + 4) {
                v1.setSlicedFlag(1);
                if (v1 instanceof Danger)
                    boom.start();
                else if (v1.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }




            if (x > v2.getDimX() && x < v2.getDimX() + v2.getWholeFruit().getWidth() + 4 &&
                    y > v2.getDimY() && y < v2.getDimY() + v2.getWholeFruit().getHeight() + 4) {
                v2.setSlicedFlag(1);
                if (v2 instanceof Danger)
                    boom.start();
                else if (v2.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }


            if (x > v3.getDimX() && x < v3.getDimX() + v3.getWholeFruit().getWidth() + 4 &&
                    y > v3.getDimY() && y < v3.getDimY() + v3.getWholeFruit().getHeight() + 4) {
                v3.setSlicedFlag(1);
                if (v3 instanceof Danger)
                    boom.start();
                else if (v3.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }



            if (x > v4.getDimX() && x < v4.getDimX() + v4.getWholeFruit().getWidth() + 4 &&
                    y > v4.getDimY() && y < v4.getDimY() + v4.getWholeFruit().getHeight() + 4) {
                v4.setSlicedFlag(1);
                if (v4 instanceof Danger)
                    boom.start();
                else if (v4.isBonus())
                    bonus.start();
                else
                    stumble.start();


            }



            if (x > v5.getDimX() && x < v5.getDimX() + v5.getWholeFruit().getWidth() + 4 &&
                    y > v5.getDimY() && y < v5.getDimY() + v5.getWholeFruit().getHeight() + 4) {
                v5.setSlicedFlag(1);
                if (v5 instanceof Danger)
                    boom.start();
                else if (v5.isBonus())
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
            // Intent intent=new Intent(getContext(), Main2Activity.class);
            //mainActivity.startIntent(intent);
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
