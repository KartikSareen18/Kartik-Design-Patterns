package org.example.creational;

import java.util.HashMap;
import java.util.Map;

abstract class Color implements Cloneable{
    protected String color;
    abstract void addColor();
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

class blueColor extends Color{
    public blueColor(){
        this.color="blue";
    }
    @Override
    void addColor() {
        System.out.println("Blue color added....");
    }
}

class redColor extends Color{
    public redColor() {
        this.color="red";
    }
    @Override
    void addColor() {
        System.out.println("Red color added....");
    }
}

class ColorStore{
    private static Map<String,Color> colorMap = new HashMap<String, Color>();
    static {
        colorMap.put("red",new redColor());
        colorMap.put("blue",new blueColor());
    }
    public static Color getColor(String color){
        return (Color) colorMap.get(color).clone();
    }
}

public class Prototype {
    public static void main(String args[]){
        ColorStore.getColor("red").addColor();
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("red").addColor();
    }
}