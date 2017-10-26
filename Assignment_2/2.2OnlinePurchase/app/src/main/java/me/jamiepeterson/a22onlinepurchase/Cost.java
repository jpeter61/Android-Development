package me.jamiepeterson.a22onlinepurchase;


import android.widget.Switch;

public class Cost {
    private int cost;
    public Cost(int price, boolean warranty, boolean insurance, String delivery){
        int warrantyPrice = 0;
        int insurancePrice = 0;
        int deliveryPrice = 0;

        if(warranty)
            warrantyPrice =(int)(price * 0.10);

        if(insurance)
            insurancePrice =(int)(price * 0.05);

        switch (delivery){
            case "Next Day":
                deliveryPrice = 20;
                break;
            case "Second Day":
                deliveryPrice = 10;
                break;
            case "Normal":
                deliveryPrice = 5;
                break;
        }

        cost = price + deliveryPrice + insurancePrice + warrantyPrice;
    }

    public int getCost() {
        return cost;
    }
}
