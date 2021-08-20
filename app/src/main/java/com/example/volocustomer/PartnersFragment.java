package com.example.volocustomer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.volocustomer.HelperClasses.PartnersAdapter;
import com.example.volocustomer.HelperClasses.PartnersHelperClass;

import java.util.ArrayList;

public class PartnersFragment extends Fragment {

    RecyclerView.Adapter adapter;
    RecyclerView partnerRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_partners, container, false);
    
        //Hooks
        partnerRecycler = root.findViewById(R.id.partners_recycler);
        
        //Recycler View Properties
        partnerRecycler.setFocusable(false);
        partnerRecycler.setNestedScrollingEnabled(false);
        
        //Call Methods
        partnerRecycler();
    
        return root;
    }

    private void partnerRecycler() {

        partnerRecycler.setHasFixedSize(true);
        partnerRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<PartnersHelperClass> viewPartners = new ArrayList<>();

        viewPartners.add(new PartnersHelperClass("VOLO", "Ice Cream", "Distance: 8.00 km | Min: BD 9,000", "Delivery: BD 1,300 | Duration: 52 mins"));
        viewPartners.add(new PartnersHelperClass("VOLO", "Frozen yoghurt, Lebanese, Persian", "Distance: 8.00 km | Min: BD 9,000", "Delivery: BD 1,300 | Duration: 52 mins"));
        viewPartners.add(new PartnersHelperClass("VOLO", "Dog Food", "Distance: 8.00 km | Min: BD 9,000", "Delivery: BD 1,300 | Duration: 52 mins"));
        viewPartners.add(new PartnersHelperClass("VOLO", "Cat Food", "Distance: 8.00 km | Min: BD 9,000", "Delivery: BD 1,300 | Duration: 52 mins"));
        viewPartners.add(new PartnersHelperClass("VOLO", "Facial Care", "Distance: 8.00 km | Min: BD 9,000", "Delivery: BD 1,300 | Duration: 52 mins"));

        adapter = new PartnersAdapter(viewPartners);
        partnerRecycler.setAdapter(adapter);


    }
}