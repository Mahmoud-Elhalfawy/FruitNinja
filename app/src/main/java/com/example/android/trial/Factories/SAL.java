package com.example.android.trial.Factories;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SAL {
    InputStream inputStream;

    public void save(int score) throws IOException {
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream("score.txt"));
        writer.write(score);
        writer.close();
    }


    public void load() throws IOException {
        FileInputStream x=new FileInputStream("score.txt");
        inputStream= new InputStream() {
            @Override
            public int read() throws IOException {
                InputStreamReader reader=new InputStreamReader(new FileInputStream("score.txt"));
                BufferedReader buffer=new BufferedReader(reader);

                return 1;
            }
        };
        inputStream.read();
            }


}
