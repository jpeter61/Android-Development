package me.jamiepeterson.a18mathquiz;

import java.util.Random;

public class Questions {
    private int left;
    private String operation;
    private int right;
    private int answer;
    private int questions;
    private int correct;
    private Random generator;

    public Questions(){
        left = 0;
        operation = "?";
        right = 0;
        answer =0;
        questions = 0;
        correct = 0;
        generator = new Random();
    }

    public void generate(){
        int nextOperation = generator.nextInt(4);
        switch (nextOperation){
            case 0:
                //Addition
                operation = "+";
                left = generator.nextInt(999)+1;
                right = generator.nextInt(999)+1;
                answer = left + right;
                break;
            case 1:
                //subtraction
                operation = "-";
                left = generator.nextInt(999)+1;
                right = generator.nextInt(999)+1;
                answer = left - right;
                break;
            case 2:
                //multiplication
                operation = "x";
                left = generator.nextInt(99)+1;
                right = generator.nextInt(99)+1;
                answer = left * right;
                break;
            case 3:
                //Division
                operation = "/";
                left = generator.nextInt(999)+1;
                right = generator.nextInt(99)+1;
                answer = left / right;
                break;
        }
    }

    public boolean checkAnswer(int user){
        questions ++; //Update Questions Answered
        if(user == answer) {
            correct ++;//Update correct
            return true;
        }
        return false; //else
    }

    public int getLeft() {
        return left;
    }

    public String getOperation() {
        return operation;
    }

    public int getRight() {
        return right;
    }

    public int getCorrect() {
        return correct;
    }

    public int getQuestions() {
        return questions;
    }
}
