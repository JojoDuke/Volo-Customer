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

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder> {

    ArrayList<BrowseHelperClass> browse;

    public BrowseAdapter(ArrayList<BrowseHelperClass> browse) {
        this.browse = browse;
    }

    @NonNull
    @Override
    public BrowseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_recycler, parent, false);
        BrowseViewHolder browseViewHolder = new BrowseViewHolder(view);
        return browseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseViewHolder holder, int position) {

        BrowseHelperClass browseHelperClass = browse.get(position);

        holder.category_image.setImageResource(browseHelperClass.getImage());
        holder.category.setText(browseHelperClass.getCategory());

    }

    @Override
    public int getItemCount() {
        return browse.size();
    }


    public static class BrowseViewHolder extends RecyclerView.ViewHolder {

        CircleImageView category_image;
        TextView category;

        public BrowseViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
           category = itemView.findViewById(R.id.category_text);
           category_image = itemView.findViewById(R.id.category_image);

        }
    }

}
