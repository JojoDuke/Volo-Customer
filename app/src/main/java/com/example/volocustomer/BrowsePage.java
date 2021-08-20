package com.example.volocustomer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.volocustomer.HelperClasses.BrowseAdapter;
import com.example.volocustomer.HelperClasses.BrowseHelperClass;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class BrowsePage extends AppCompatActivity {

    RecyclerView browseRecycler;
    RecyclerView.Adapter adapter;
    ImageView closeIcon;
    TextView okTxt, cancelTxt;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_page);

        // Update Frame View
        updateFrameView();

        //Hooks
        browseRecycler = findViewById(R.id.browse_recycler);
        
        //Recycler View Properties
        browseRecycler.setFocusable(false);
        browseRecycler.setNestedScrollingEnabled(false);
        
        //Call Methods
        browseRecycler();

    }

    private void updateFrameView() {
        Fragment fragment;
        fragment = new PartnersFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void browseRecycler() {

        browseRecycler.setHasFixedSize(true);
        browseRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<BrowseHelperClass> viewBrowse = new ArrayList<>();

        viewBrowse.add(new BrowseHelperClass(R.drawable.ic_sorry, "Restaurants"));
        viewBrowse.add(new BrowseHelperClass(R.drawable.ic_sorry, "Groceries"));
        viewBrowse.add(new BrowseHelperClass(R.drawable.ic_sorry, "Florists"));
        viewBrowse.add(new BrowseHelperClass(R.drawable.ic_sorry, "Pet Stores"));
        viewBrowse.add(new BrowseHelperClass(R.drawable.ic_sorry, "Other"));

        adapter = new BrowseAdapter(viewBrowse);
        browseRecycler.setAdapter(adapter);

    }

    public void callHomePage(View view) {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }

    public void filterBottomSheet(View view) {
        bottomSheetDialog = new BottomSheetDialog(BrowsePage.this, R.style.BottomSheetTheme);

        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.filter_bottom_sheet, findViewById(R.id.filter));

        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();

        //Hooks
        closeIcon = bottomSheetDialog.findViewById(R.id.close);
        assert closeIcon != null;
        closeIcon.setOnClickListener(v -> bottomSheetDialog.dismiss());

        //Click Listeners
    }

    public void alertDialog(View view) {

        Dialog dialog = new Dialog(BrowsePage.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.browse_alert_dialog, findViewById(R.id.alert_dialog));

        dialog.setContentView(dialogView);
        dialog.show();

        //Hooks
        okTxt = dialog.findViewById(R.id.okay);
        cancelTxt = dialog.findViewById(R.id.cancel);

        okTxt.setOnClickListener(v -> {
            Fragment fragment;
            fragment = new NoPartnersFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            dialog.dismiss();
        });
        cancelTxt.setOnClickListener(v -> dialog.dismiss());

    }
}