package com.Graduration.misikga.Model;

import java.util.List;

public class Restaurant {

    private String restaurantName;
    private String restaurantKind;
    private String restaurantAddress;
    private String restaurantImage;
    private List<RestaurantChild> restaurantChildList;

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantKind, String restaurantAddress, String restaurantImage) {
        this.restaurantName = restaurantName;
        this.restaurantKind = restaurantKind;
        this.restaurantAddress = restaurantAddress;
        this.restaurantImage = restaurantImage;
    }

    public List<RestaurantChild> getRestaurantChildList() {
        return restaurantChildList;
    }

    public void setRestaurantChildList(List<RestaurantChild> restaurantChildList) {
        this.restaurantChildList = restaurantChildList;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantKind() {
        return restaurantKind;
    }

    public void setRestaurantKind(String restaurantKind) {
        this.restaurantKind = restaurantKind;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
}
