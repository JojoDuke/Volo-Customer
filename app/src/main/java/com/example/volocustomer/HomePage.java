package com.example.volocustomer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;

    BottomSheetDialog bottomSheetDialog;
    ImageView menuIcon, closeIcon;
    LinearLayout contentView, menuText;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        
        // Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content_view);
        menuText = findViewById(R.id.menu_text);
        
        navigationDrawer();

        menuText.setOnClickListener(v -> showBottomSheet());
        
    }

    private void showBottomSheet() {

        bottomSheetDialog = new BottomSheetDialog(HomePage.this, R.style.BottomSheetTheme);

        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.delivery_address_bottom_sheet, findViewById(R.id.delivery_address_sheet));

        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();

        //Hooks
        closeIcon = bottomSheetDialog.findViewById(R.id.close);
        assert closeIcon != null;
        closeIcon.setOnClickListener(v -> bottomSheetDialog.dismiss());
    }

    // Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent home = new Intent(getApplicationContext(), HomePage.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                break;
            case R.id.nav_orders:
                Intent orders = new Intent(getApplicationContext(), MyOrders.class);
                orders.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(orders);
                break;
        }
        return true;
    }

    public void callBrowsePage(View view) {
        startActivity(new Intent(getApplicationContext(), BrowsePage.class));
    }
}