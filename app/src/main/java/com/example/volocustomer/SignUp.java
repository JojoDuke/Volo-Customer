package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void callHomePage(View view) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }

    public void calLSettings(View view) {
        startActivity(new Intent(getApplicationContext(), Settings.class));
    }
}