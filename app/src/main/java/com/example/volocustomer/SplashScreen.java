package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    LottieAnimationView loadingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Hooks
        loadingAnimation = findViewById(R.id.loading_animation);

        Runnable r = () -> {
            Intent start = new Intent(getApplicationContext(), HomePage.class);

            //Remove Lottie from view before loading new page
            loadingAnimation.setVisibility(View.GONE);

            start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(start);
        };

        Handler h = new Handler();
        h.postDelayed(r, 5000);
    }

}