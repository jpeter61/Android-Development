package me.jamiepeterson.a44shapes;

import java.util.Random;

public class Game {
    private Object[] circles;
    private Object[] squares;
    private Random random;
    
    public Game(){
        random = new Random();
        circles = new Object[10];
        squares = new Object[10];
        for (int i = 0; i < circles.length; i++){
            int size = random.nextInt(20) + 40;
            int x = random.nextInt(1800);
            int y = random.nextInt(1000);
            int delta = random.nextInt(20) + 1;
            char direction = decideDirection();
            String color = decideColor();
            circles[i] = new Object(x, y, size, delta, direction, color);
        }
        for (int i = 0; i < squares.length; i++){
            int size = random.nextInt(20) + 40;
            int x = random.nextInt(1800);
            int y = random.nextInt(1000);
            int delta = random.nextInt(20) + 1;
            char direction = decideDirection();
            String color = decideColor();
            squares[i] = new Object(x, y, size, delta, direction, color);
        }
    }

    private String decideColor(){
        int directionValue = random.nextInt(4);
        String color = "#000000";
        switch (directionValue){
            case 0:
                color = "#bfacaa";
                break;
            case 1:
                color = "#05204a";
                break;
            case 2:
                color = "#b497d6";
                break;
            case 3:
                color = "#e1e2ef";
                break;
        }
        return color;
    }

    private char decideDirection(){
        int directionValue = random.nextInt(4);
        char direction = 'N';
        switch (directionValue){
            case 0:
                direction = 'N';
                break;
            case 1:
                direction = 'S';
                break;
            case 2:
                direction = 'E';
                break;
            case 3:
                direction = 'W';
                break;
        }
        return direction;
    }
    public void move(){
        for (int i = 0; i < circles.length; i++)
            circles[i].move();
        for (int i = 0; i < squares.length; i++)
            squares[i].move();
    }

    public Object[] getCircles() {
        return circles;
    }

    public Object[] getSquares() {
        return squares;
    }
}
