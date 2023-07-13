package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView timerTv;
    Button buttonStart, buttonStop, buttonReset;

    int seconds = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTv = findViewById(R.id.timerText);
        buttonStart = findViewById(R.id.btnStart);
        buttonStop = findViewById(R.id.btnStop);
        buttonReset = findViewById(R.id.btnReset);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnStart:{
                startTimer();

            }
            case R.id.btnStop:{
                break;
            }
            case R.id.btnReset:{
                break;
            }

        }
    }

    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int s = seconds%60;
                int m = seconds/60;
                int h = m/60;

                seconds++;
                String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d", h, m, s);
                timerTv.setText(formatString);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
}