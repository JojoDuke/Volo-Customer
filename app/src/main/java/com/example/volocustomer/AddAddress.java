package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class AddAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
    }

    public void callSavedAddresses(View view) {
        startActivity(new Intent(getApplicationContext(), SavedAddresses.class));
    }

    public void showAddressPopup(View view) {
        Dialog dialog = new Dialog(AddAddress.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_address_verification_popup, findViewById(R.id.verify_address));

        dialog.setContentView(dialogView);
        dialog.show();

    }
}