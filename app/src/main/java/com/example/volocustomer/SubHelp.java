package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_help);
    }

    public void callHelp(View view) {
        startActivity(new Intent(getApplicationContext(), HelpPage.class));
    }

    public void callFinalHelp(View view) {
        startActivity(new Intent(getApplicationContext(), FinalHelp.class));
    }
}