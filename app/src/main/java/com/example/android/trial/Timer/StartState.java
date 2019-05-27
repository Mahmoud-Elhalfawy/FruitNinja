package com.example.android.trial.Timer;

public class StartState implements TimerState {
    @Override
    public void change(Timer timer) {
        timer.startTimer();
    }
}
