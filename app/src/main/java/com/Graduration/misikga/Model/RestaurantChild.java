package com.Graduration.misikga.Model;

import java.util.List;

public class RestaurantChild {
    private String itemName;
    private String itemImage;
    private int itemPrice;

    private List<RestaurantChild> restaurantChildList;

    public RestaurantChild(String itemName, String itemImage, int itemPrice, List<RestaurantChild> restaurantChildList) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.restaurantChildList = restaurantChildList;
    }

    public List<RestaurantChild> getRestaurantChildList() {
        return restaurantChildList;
    }

    public void setRestaurantChildList(List<RestaurantChild> restaurantChildList) {
        this.restaurantChildList = restaurantChildList;
    }

    public RestaurantChild(String itemName, String itemImage, int itemPrice) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
    }

    public RestaurantChild() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
