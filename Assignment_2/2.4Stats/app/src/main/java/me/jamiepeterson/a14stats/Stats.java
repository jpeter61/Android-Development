package me.jamiepeterson.a14stats;


import java.util.Arrays;

public class Stats {
    private double solution;
    public Stats(int[] inputs, int operation){
        switch (operation){
            case 0:
                sum(inputs);
                break;
            case 1:
                average(inputs);
                break;
            case 2:
                median(inputs);
                break;
            case 3:
                stdev(inputs);
                break;
            case 4:
                min(inputs);
                break;
            case 5:
                max(inputs);
                break;
            default:
                solution = -1;
        }
    }

    private void sum(int[] inputs){
        int sum = 0;
        for(int i = 0; i < inputs.length; i++)
            sum += inputs[i];
        solution = sum;
    }
    private void average(int[] inputs){
        solution = mean(inputs);
    }
    private double mean(int[] inputs){
        double sum = 0;
        for(int i = 0; i < inputs.length; i++)
            sum += inputs[i];
        return sum/inputs.length;
    }
    private void median(int[] inputs){
        Arrays.sort(inputs);
        double median;
        if (inputs.length % 2 == 0)
            median = ((double)inputs[inputs.length/2] + (double)inputs[inputs.length/2 - 1])/2;
        else
            median = (double) inputs[inputs.length/2];
        solution = median;
    }
    private void stdev(int[] inputs){
        double mean = mean(inputs);
        double sd = 0;
        for (int i = 0; i < inputs.length; i++)
        {
            sd += Math.pow(inputs[i] - mean, 2) / inputs.length;
        }
        solution = Math.sqrt(sd);
    }
    private void min(int[] inputs){
        int min = inputs[0];
        for (int i = 0; i < inputs.length; i++)
            if(min > inputs[i])
                min = inputs[i];
        solution = min;
    }
    private void max(int[] inputs){
        int max = inputs[0];
        for (int i = 0; i < inputs.length; i++)
            if(max < inputs[i])
                max = inputs[i];
        solution = max;
    }

    public double getSolution() {
        return solution;
    }
}
