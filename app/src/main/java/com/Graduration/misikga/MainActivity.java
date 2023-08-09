package com.Graduration.misikga;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Graduration.misikga.Adapter.RestaurantAdapter;
import com.Graduration.misikga.Model.Restaurant;
import com.Graduration.misikga.viewModel.FirebaseViewModel;
import com.google.firebase.database.DatabaseError;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView parentrecyclerView;
    private FirebaseViewModel firebaseViewModel;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentrecyclerView = findViewById(R.id.recycler_view);

        parentrecyclerView.setHasFixedSize(true);
        parentrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        restaurantAdapter = new RestaurantAdapter();
        parentrecyclerView.setAdapter(restaurantAdapter);

        firebaseViewModel = new ViewModelProvider(this).get(FirebaseViewModel.class);

        firebaseViewModel.getAllData();;
        firebaseViewModel.getRestaurantMutableLiveData().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurantList) {
                restaurantAdapter.setRestaurantList(restaurantList);
                restaurantAdapter.notifyDataSetChanged();
            }
        });
        firebaseViewModel.getDatabaseErrorMutableLiveData().observe(this, new Observer<DatabaseError>() {
            @Override
            public void onChanged(DatabaseError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}