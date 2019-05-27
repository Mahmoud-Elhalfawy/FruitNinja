package com.example.android.trial.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.android.trial.Gui.Bonus;
import com.example.android.trial.R;
import com.example.android.trial.ThreadController;

public  class MainActivity extends AppCompatActivity {
    ThreadController thread;
Button start;
Intent intent;
Bonus bonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int score;
        super.onCreate(savedInstanceState);
        //bonus=new Bonus(this);
       // bonus.setActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
       // setContentView(bonus);

        start=(Button)findViewById(R.id.Start);
        intent=new Intent(this,MainMenu.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

    }

}
