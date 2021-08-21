package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SavedAddresses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_addresses);
    }

    public void callSettings(View view) {
        startActivity(new Intent(getApplicationContext(), Settings.class));
    }

    public void callAddAddress(View view) {
        startActivity(new Intent(getApplicationContext(), AddAddress.class));
    }
}