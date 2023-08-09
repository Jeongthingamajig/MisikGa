package com.Graduration.misikga.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Graduration.misikga.R;
import com.Graduration.misikga.Model.Restaurant;
import com.Graduration.misikga.Model.RestaurantChild;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder> {

    private Activity activity;
    private List<Restaurant> restaurantList;
    private List<RestaurantChild> restaurantChildList;
    RecyclerView recyclerView;

    public RestaurantAdapter() {
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public RestaurantAdapter(Activity activity, ArrayList<Restaurant> restaurantList, ArrayList<RestaurantChild> restaurantChildList) {
        this.activity = activity;
        this.restaurantList = restaurantList;
        this.restaurantChildList = restaurantChildList;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int position) {

        Restaurant restaurant = restaurantList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(restaurant.getRestaurantImage())
                .into(holder.image);
        holder.name.setText(restaurant.getRestaurantName());
        holder.kind.setText(restaurant.getRestaurantKind());

        holder.childRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ChildRestaurantAdapter childRestaurantAdapter = new ChildRestaurantAdapter();
        holder.childRecyclerView.setAdapter(childRestaurantAdapter);
        childRestaurantAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if(restaurantList != null){
            return restaurantList.size();
        }else {
            return 0;
        }
    }

    public class RestaurantHolder extends RecyclerView.ViewHolder{

        TextView name, kind;
        ImageView image;
        RecyclerView childRecyclerView;

        public RestaurantHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.image_view);
            kind = itemView.findViewById(R.id.kind_view);
            image = itemView.findViewById(R.id.image_view);
            childRecyclerView = itemView.findViewById(R.id.expandable_recyclerview);
        }
    }
}
