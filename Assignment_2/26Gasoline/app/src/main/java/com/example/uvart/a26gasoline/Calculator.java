package com.example.uvart.a26gasoline;

/**
 * Created by uvart on 10/26/17.
 */

public class Calculator {
    private float price;
    private int gallons;

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public float getCost(){
        return price * gallons;
    }
}
