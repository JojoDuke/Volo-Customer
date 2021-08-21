package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AccountInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
    }

    public void callSettings(View view) {
        startActivity(new Intent(getApplicationContext(), Settings.class));
    }

    public void callPasswordPopup(View view) {
        Dialog dialog = new Dialog(AccountInfo.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.change_password_dialog, findViewById(R.id.change_password_dialog));
        View dialogView2 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.enter_recovery_code_dialog, findViewById(R.id.enter_code));

        dialog.setContentView(dialogView);
        dialog.show();

        //Hooks
        ImageView close = dialog.findViewById(R.id.close_dialog);
        Button okayButton = dialog.findViewById(R.id.okay);
        okayButton.setOnClickListener(v -> {
            dialog.setContentView(dialogView2);
        });
        close.setOnClickListener(v -> dialog.dismiss());

    }

    public void callChangeCode(View view) {
        Dialog dialog2 = new Dialog(AccountInfo.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.change_recovery_code_dialog, findViewById(R.id.change_recovery_code_dialog));

        dialog2.setContentView(dialogView);
        dialog2.show();

        //Hooks
        ImageView close = dialog2.findViewById(R.id.close_dialog);
        close.setOnClickListener(v -> dialog2.dismiss());
    }
}