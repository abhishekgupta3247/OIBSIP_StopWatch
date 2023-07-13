package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView timerTv;
    Button buttonStart, buttonStop, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTv = findViewById(R.id.timerText);
        buttonStart = findViewById(R.id.btnStart);
        buttonStop = findViewById(R.id.btnStop);
        buttonReset = findViewById(R.id.btnReset);
    }

    @Override
    public void onClick(View v) {

    }
}