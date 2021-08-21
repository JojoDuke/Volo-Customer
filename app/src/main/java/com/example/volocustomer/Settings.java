package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void callHomePage(View view) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }

    public void signUp(View view) {
        startActivity(new Intent(getApplicationContext(), SignUp.class));
    }

    public void signIn(View view) {
        startActivity(new Intent(getApplicationContext(), SignIn.class));
    }
}