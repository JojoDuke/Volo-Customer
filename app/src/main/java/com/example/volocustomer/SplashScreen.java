package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Runnable r = () -> startActivity(new Intent(getApplicationContext(), HomePage.class));

        Handler h = new Handler();
        h.postDelayed(r, 5000);
    }

}