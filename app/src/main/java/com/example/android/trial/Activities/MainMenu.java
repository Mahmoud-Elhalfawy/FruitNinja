package com.example.android.trial.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.trial.Gui.Game;
import com.example.android.trial.Gui.Level3;
import com.example.android.trial.Gui.level2;
import com.example.android.trial.R;
import com.example.android.trial.ThreadController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainMenu extends AppCompatActivity {
    ThreadController thread;
    Game g;
    level2 g2;
    Level3 g3;
    GestureDetectorCompat gd;
    Intent intent;
    Button easy;
    Button medium;
    Button hard;
    Button start;
    Intent intent1;
    Intent intent2;
    Intent intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        intent1=new Intent(this,L2Activity.class);
        intent2=new Intent(this,Main2Activity.class);
        intent3=new Intent(this,Main3Activity.class);

        g=new Game(this);
        g2=new level2(this);
        g3=new Level3(this);

        easy=(Button)findViewById(R.id.easy);
        medium=(Button)findViewById(R.id.medium);
        hard=(Button)findViewById(R.id.hard);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                // finish();
            }
        });


        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
                // finish();

            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent3);
                // finish();
            }
        });




    }


    public void save(int score) throws IOException {
        String scoreS=String.valueOf(score);
        OutputStreamWriter writer=new OutputStreamWriter(openFileOutput("score.txt", Context.MODE_PRIVATE));
        writer.write(scoreS);
        writer.close();
    }

    public int load() throws IOException {
        int score=0;
        String scoreS="";
        InputStream inputStream = openFileInput("score.txt");
        if(inputStream!=null){
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String temp="";
            StringBuilder stringBuilder=new StringBuilder();
            while((temp=bufferedReader.readLine())!=null){
                stringBuilder.append(temp);

            }
            inputStream.close();
            scoreS=stringBuilder.toString();
            score=Integer.parseInt(scoreS);
        }

        return score;
    }


    public void startIntent(Intent intent){
        startActivity(intent);
        finish();

    }
    }

