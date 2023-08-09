package com.Graduration.misikga.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Graduration.misikga.R;
import com.Graduration.misikga.Model.RestaurantChild;
import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class ChildRestaurantAdapter extends RecyclerView.Adapter<ChildRestaurantAdapter.ChildRestaurantHolder> {

    List<RestaurantChild> restaurantChildList;

    public void setRestaurantChildList(List<RestaurantChild> restaurantChildList) {
        this.restaurantChildList = restaurantChildList;

        this.restaurantChildList.removeAll(Collections.singletonList(null));
    }

    public ChildRestaurantAdapter() {
        this.restaurantChildList = restaurantChildList;
    }

    @NonNull
    @Override
    public ChildRestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_cardview, parent, false);

        return new ChildRestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRestaurantHolder holder, int position) {

        RestaurantChild restaurantChild = restaurantChildList.get(position);

        Glide.with(holder.itemView)
                .load(restaurantChildList.get(position).getItemImage())
                .into(holder.image);

        holder.name.setText(restaurantChild.getItemName());
        holder.price.setText(restaurantChild.getItemPrice());

    }

    @Override
    public int getItemCount() {
        if (restaurantChildList != null){
            return restaurantChildList.size();
        }
        return 0;
    }

    public class ChildRestaurantHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name, price;

        public ChildRestaurantHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.child_name_view);
            price = itemView.findViewById(R.id.child_price_view);
            image = itemView.findViewById(R.id.child_image_view);
        }
    }
}
