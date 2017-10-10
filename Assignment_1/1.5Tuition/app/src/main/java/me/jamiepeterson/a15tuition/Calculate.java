package me.jamiepeterson.a15tuition;

public class Calculate {
    private int value;

    public Calculate(int credits, double state, int grad, int otherVal){
        int creditsCost = (int)(grad * state);
        int tuition = credits * creditsCost;
        value = tuition+otherVal;
    }

    public int getValue() {
        return value;
    }
}
