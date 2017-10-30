package me.jamiepeterson.a28sudoku;


public class Game {
    int[][] board;
    public Game (int[][] board){
        this.board = board;
    }

    public boolean place(int x, int y, int value){
        if(!checkValue(x, y, value))
            return false;
        //else
        board[x][y] = value;
        return true;
    }
    public void setZero(int x, int y){
        board[x][y] = 0;
    }

    public boolean checkValue(int x, int y,int value){
        int a, b, i, j;

        for (j = 0; j < 9; j++)
            if (j != y && board[x][j] == value)
                return false;

        for (i = 0; i < 9; i++)
            if (i != x && board[i][y] == value)
                return false;

        a = (x/3)*3; b = (y/3)*3;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                if ((a + i != x) && (b + j != y) && board[a+i][b+j] == value)
                    return false;

        return true;
    }

    public boolean checkComplete(){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j <board.length; j++)
                if(board[i][j] == 0)
                    return false;
        //else
        return true;
    }
}
