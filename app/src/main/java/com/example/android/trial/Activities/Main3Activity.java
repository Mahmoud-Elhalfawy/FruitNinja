package com.example.android.trial.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.trial.Gui.Level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3Activity extends AppCompatActivity {
Level3 g3;
    Intent Rintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Rintent=new Intent(this,MainMenu.class);

        g3=new Level3(this);
        g3.setActivity(this);
        setContentView(g3);
    }


    public void startIntent(Intent intent){
        startActivity(intent);
        finish();

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
    public void returnIntent(){
        startActivity(Rintent);
        finish();
    }

}
