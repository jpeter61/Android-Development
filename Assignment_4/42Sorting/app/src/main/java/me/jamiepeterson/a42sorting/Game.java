package me.jamiepeterson.a42sorting;


import java.util.Arrays;
import java.util.Random;

public class Game {
    private int swaps;
    private int pointer;
    private int[] board;
    private int[] goal;

    public Game(){
        swaps = 45;
        pointer = 0;
        board = new int[10];
        goal = new int[board.length];
        Random random = new Random();
        for(int i = 0; i < board.length; i++)
            board[i] = random.nextInt(100)+1;
        goal = board.clone();
        Arrays.sort(goal);
    }

    public int getSwaps() {
        return swaps;
    }

    public int[] getBoard() {
        return board;
    }

    public int getPointer() {
        return pointer;
    }

    public int swap(){
        int temp = board[pointer];
        board[pointer] = board[pointer + 1];
        board[pointer + 1] = temp;
        swaps --;
        //Check if sorted
        if(check())
            return 1;
        //check if out of swaps
        else if (swaps <= 0)
            return -1;
        //return neutral if the game shall go on
        else
            return 0;
    }

    public void movePointer(){
        if(pointer >= board.length - 2)
            //wrap
            pointer = 0;
        else
            //iterate
            pointer ++;
    }

    private boolean check(){
        for(int i = 0; i < board.length; i++)
            if(board[i] != goal[i])
                return false;
        return true;
    }
}
