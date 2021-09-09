package com.example.tmdbapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tmdbapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask splash = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, PrincipalActivityView.class);
                startActivity(i);
                finish();
            }
        };
        Timer t = new Timer();
        t.schedule(splash, 5000);
    }
}