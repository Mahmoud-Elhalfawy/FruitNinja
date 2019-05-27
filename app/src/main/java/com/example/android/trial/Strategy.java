package com.example.android.trial;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface Strategy {

    public void drawLevel(Canvas canvas);
    public void update();


}
