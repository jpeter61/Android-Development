package me.jamiepeterson.a14retirement;


public class Retirement {

    private int amount;

    //principle, addition, years, rate
    public Retirement(float p, float a, float n, float r){

        //Convert rate
        r =(float)(r/100.0);
        //Calculate
        amount = (int)(((p+(a/r))*((float)Math.pow((1.0+r),(double)n))-(a/r)));
    }

    public int getAmount() {
        return amount;
    }
}
