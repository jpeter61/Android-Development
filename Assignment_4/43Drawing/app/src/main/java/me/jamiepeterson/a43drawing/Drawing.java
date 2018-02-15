package me.jamiepeterson.a43drawing;

import java.util.ArrayList;

public class Drawing {
    private ArrayList<Point> listOfPoints;
    private String color;
    private int colorPointer;

    public Drawing(){
        listOfPoints = new ArrayList<>();
        color = "#000000";
        colorPointer = 0;
    }

    public void addPoint(int x, int y){
        listOfPoints.add(new Point(x, y, color));
    }

    public ArrayList<Point> getListOfPoints() {
        return listOfPoints;
    }

    public void cycleColor(){
        colorPointer = colorPointer + 1;
        switch (colorPointer){
            case 0: color = "#000000"; break;
            case 1: color = "#FFFFFF"; break;
            case 2: color = "#c5d1eb"; break;
            case 3: color = "#de1a1a"; break;
            case 4: color = "#5e8c61"; break;
            case 5: color = "#0075f2"; break;
            case 6: color = "#f9c80e"; break;
            case 7: color = "#7f675b"; break;
            default: color = "#000000"; colorPointer = 0; break;
        }
    }

    public String getColor() {
        return color;
    }
}
