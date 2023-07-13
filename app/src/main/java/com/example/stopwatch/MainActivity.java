package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    TextView timerTv;
    Button buttonStart, buttonStop, buttonReset;

    int seconds = 0;
    boolean isRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTv = findViewById(R.id.timerText);
        buttonStart = findViewById(R.id.btnStart);
        buttonStop = findViewById(R.id.btnStop);
        buttonReset = findViewById(R.id.btnReset);

        startTimer();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = true;
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = false;
                seconds = 0;
            }
        });


    }

//    @Override
//    public void onClick(View v) {
////        switch(v.getId()){
////            case R.id.btnStart:{
////                isRunning = true;
////                startTimer();
////
////            }
////            case R.id.btnStop:{
////                startTimer();
////                isRunning = false;
////            }
////            case R.id.btnReset:{
////                startTimer();
////                isRunning = false;
////                seconds = 0;
////            }
////
////        }
//    }

    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int s = seconds%60;
                int m = seconds/60;
                int h = m/60;

                if(isRunning)
                {
                    seconds++;
                }

                String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d", h, m, s);
                timerTv.setText(formatString);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
}