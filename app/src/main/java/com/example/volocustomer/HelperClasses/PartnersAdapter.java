package com.example.volocustomer.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.volocustomer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PartnersAdapter extends RecyclerView.Adapter<PartnersAdapter.PartnersViewHolder> {

    ArrayList<PartnersHelperClass> partners;

    public PartnersAdapter(ArrayList<PartnersHelperClass> partners) {
        this.partners = partners;
    }

    @NonNull
    @Override
    public PartnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.partners_recycler, parent, false);
        PartnersViewHolder partnersViewHolder = new PartnersViewHolder(view);
        return partnersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PartnersViewHolder holder, int position) {

        PartnersHelperClass partnersHelperClass = partners.get(position);

        holder.vendor.setText(partnersHelperClass.getVendor());
        holder.distance.setText(partnersHelperClass.getDistance());
        holder.duration.setText(partnersHelperClass.getDuration());
        holder.product.setText(partnersHelperClass.getProduct());

    }

    @Override
    public int getItemCount() {
        return partners.size();
    }


    public static class PartnersViewHolder extends RecyclerView.ViewHolder {

        TextView vendor, product, distance, duration;

        public PartnersViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            vendor = itemView.findViewById(R.id.vendor);
            product = itemView.findViewById(R.id.product);
            distance = itemView.findViewById(R.id.distance);
            duration = itemView.findViewById(R.id.delivery_time);

        }
    }

}
