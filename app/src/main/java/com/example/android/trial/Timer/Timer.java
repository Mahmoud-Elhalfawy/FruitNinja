package com.example.android.trial.Timer;

import android.os.CountDownTimer;

public class Timer {
    private TimerState timerState;

   private long timeLeftMilli=120000;   //2 minutes

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    private CountDownTimer timer;
    private boolean timerRunning;
    private int seconds=0;


    public Timer(){
        timerState=new StartState();
    }


    public void startTimer(){
        timer=new CountDownTimer(timeLeftMilli,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    timeLeftMilli=millisUntilFinished;
                    updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

public void updateTimer(){
        seconds=(int)(120000-timeLeftMilli)/1000;
}

public void setTimerState(TimerState timerState){
        this.timerState=timerState;

}


public void change(){
        timerState.change(this);
}

public void stop(){
        timer.cancel();
}
}
