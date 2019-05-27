package com.example.android.trial.Timer;

public class StopState implements TimerState {
    @Override
    public void change(Timer timer) {
        timer.stop();
    }
}
