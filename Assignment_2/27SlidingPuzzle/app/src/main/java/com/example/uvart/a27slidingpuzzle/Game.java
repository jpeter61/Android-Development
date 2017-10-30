package com.example.uvart.a27slidingpuzzle;


import java.util.Random;

public class Game {
    private int size;
    private int[][] board;
    private int[][] goal;

    public Game(int size){
        this.size = size;

        board = createRandomBoard();
        goal = createRandomBoard();

    }

    private int[][] createRandomBoard(){
        int[][] temp = new int[size][size];
        int[] randomNumbers = createRandomNumbers();

        int pointer = 0;
        for(int i = 0; i<size; i++)
            for(int j = 0; j <size; j++){
                temp[i][j] = randomNumbers[pointer];
                pointer++;
            }
        return temp;
    }

    private int[] createRandomNumbers(){
        int[] numbers = new int[size*size];
        Random generator = new Random();
        //initialize array
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = i;
        //randomize
        for (int i = numbers.length-1; i >= 0; i--){
            int temp = numbers[i];
            int target = generator.nextInt(i+1);
            numbers[i] = numbers[target];
            numbers[target] = temp;
        }
        return numbers;
    }

    public boolean move(char direction){
        int[] location = findBlank();
        switch (direction){
            case 'N':
                if(location[1] > 0){
                    swap(location, location[0], location[1]-1);
                    return true;
                }
                return false;
            case 'E':
                if(location[0] < size-1){
                    swap(location, location[0]+1, location[1]);
                    return true;
                }
                return false;
            case 'S':
                if(location[1] < size-1){
                    swap(location, location[0], location[1]+1);
                    return true;
                }
                return false;
            case 'W':
                if(location[0] > 0){
                    swap(location, location[0]-1, location[1]);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void swap(int[] blank, int x, int y){
        board[blank[0]][blank[1]] = board[x][y];
        board[x][y] = 0;
    }

    private int[] findBlank(){
        //x location = 0 y location = 1
        int[] location = new int[2];
        boolean found = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                if (board[i][j] == 0) {
                    location[0] = i;
                    location[1] = j;
                    found = true;
                    break;
                }
            if(found)
                break;
        }
        return location;
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getGoal() {
        return goal;
    }
}
