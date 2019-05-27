package com.example.android.trial;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class ThreadController extends Thread {
    int flag=0;
    private int FPS = 30;
    private double avgFPS;
    private SurfaceHolder holder;
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private boolean running;


    public static Canvas canvas;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }



    public ThreadController(SurfaceHolder holder, Strategy strategy) {
        super();
        this.holder = holder;
        this.strategy = strategy;

    }




    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        long frameCount = 0;
        long targetTime = 1000 / FPS;
        while (running) {
            startTime = System.nanoTime();
            canvas = null;
            try {
                canvas = this.holder.lockCanvas();
                synchronized (holder) {
                    this.strategy.update();
                    this.strategy.drawLevel(canvas);
                }
            } catch (Exception e) {

            } finally {
                if (canvas != null) {
                    try {
                        holder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {

                    }
                }

            }

            timeMillis=(System.nanoTime()-startTime)/1000000;
            waitTime=targetTime-timeMillis;
            try {
               this.sleep(waitTime);
            }catch (Exception e){

            }
            totalTime+=System.nanoTime()-startTime;
            frameCount++;
            if (frameCount==FPS) {
                avgFPS = 100 / (totalTime / frameCount) / 1000000;
                totalTime = 0;
                frameCount = 0;
            }

        }

    }
}
