package me.jamiepeterson.a43drawing;

public class Point {
    private int x;
    private int y;
    private String color;

    public Point(int x, int y, String color){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
