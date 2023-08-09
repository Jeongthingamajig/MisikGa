package com.Graduration.misikga.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.Graduration.misikga.Model.Restaurant;
import com.Graduration.misikga.repo.FirebaseRepo;
import com.google.firebase.database.DatabaseError;

import java.util.List;

public class FirebaseViewModel extends ViewModel implements FirebaseRepo.OnRealtimeDbTaskComplete {

    private MutableLiveData<List<Restaurant>> restaurantMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<DatabaseError> databaseErrorMutableLiveData = new MutableLiveData<>();
    private FirebaseRepo firebaseRepo;

    public MutableLiveData<List<Restaurant>> getRestaurantMutableLiveData() {
        return restaurantMutableLiveData;
    }

    public MutableLiveData<DatabaseError> getDatabaseErrorMutableLiveData() {
        return databaseErrorMutableLiveData;
    }

    public FirebaseViewModel(){
        firebaseRepo = new FirebaseRepo(this);
    }

    public void getAllData(){
        firebaseRepo.getAllData();
    }

    @Override
    public void onSuccess(List<Restaurant> restaurantList) {
        restaurantMutableLiveData.setValue(restaurantList);
    }

    @Override
    public void onFailure(DatabaseError error) {
        databaseErrorMutableLiveData.setValue(error);
    }
}
