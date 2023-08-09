package com.Graduration.misikga.repo;

import androidx.annotation.NonNull;

import com.Graduration.misikga.Model.Restaurant;
import com.Graduration.misikga.Model.RestaurantChild;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseRepo {
    private DatabaseReference databaseReference;
    private OnRealtimeDbTaskComplete onRealtimeDbTaskComplete;

    public  FirebaseRepo(OnRealtimeDbTaskComplete onRealtimeDbTaskComplete){
        this.onRealtimeDbTaskComplete = onRealtimeDbTaskComplete;
        databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("restaurant");
    }

    public void getAllData(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Restaurant> restaurantList = new ArrayList<>();
                    for(DataSnapshot ds : snapshot.getChildren()){
                        Restaurant restaurant = new Restaurant();
                        restaurant.setRestaurantName(ds.child("name").getValue(String.class));
                        restaurant.setRestaurantName(ds.child("kind").getValue(String.class));
                        restaurant.setRestaurantName(ds.child("image").getValue(String.class));

                        GenericTypeIndicator<ArrayList<RestaurantChild>> genericTypeIndicator =
                                new GenericTypeIndicator<ArrayList<RestaurantChild>>() {};

                        restaurant.setRestaurantChildList(ds.child("menu").getValue(genericTypeIndicator));
                        restaurantList.add(restaurant);
                    }
                    onRealtimeDbTaskComplete.onSuccess(restaurantList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                onRealtimeDbTaskComplete.onFailure(error);
            }
        });
    }

    public interface OnRealtimeDbTaskComplete{
        void onSuccess(List<Restaurant> restaurantList);
        void onFailure(DatabaseError error);
    }
}
