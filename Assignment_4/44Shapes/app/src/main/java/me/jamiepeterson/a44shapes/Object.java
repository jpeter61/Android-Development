package me.jamiepeterson.a44shapes;

public class Object {
    private int x; // x y coordinates
    private int y;
    private int size; //radius or half of side length
    private int delta; //speed
    private char direction; //true == right false == down
    private String color;

    public Object (int x, int y, int size, int delta, char direction, String color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.delta = delta;
        this.direction = direction;
        this.color = color;
    }
    public void move(){
        switch (direction){
            case 'N':
                //move
                y -= delta;
                //check if off screen
                if(y < 0 - size*2)
                    y = 1000 + size*2;
                break;
            case 'S':
                //move
                y += delta;
                //check if off screen
                if(y > 1000 + size*2)
                    y = 0 - size*2;
                break;
            case 'E':
                //move
                x += delta;
                //check if off screen
                if(x > 1800 + size*2)
                    x = 0 - size*2;
                break;
            case 'W':
                //move
                x -= delta;
                //check if off screen
                if(x < 0 - size*2)
                    x = 1800 + size*2;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
