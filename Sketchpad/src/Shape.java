/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;

public abstract class Shape {

    protected Point startPoint;
    protected Point controlPoint;
    protected boolean filled = false;
    private Color colour;
    
    // abstract draw method that will be overriden by its subclasses
    public abstract void draw(Graphics g);
    
    public Shape() {    
    }

    // Each shape will have a start point where the user intitially clicks
    public Shape(Point startPoint) {
        this.startPoint = startPoint;
    }

    // User will be able to change colours inside shape
    public Color getColour() {
        return this.colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setControlPoint(Point controlPoint) {
        this.controlPoint = controlPoint;
    }


    @Override
    public String toString() {
        return "Colour: "+this.colour+"\nStart point: "+this.startPoint+
                "\nControl point: "+controlPoint;
    }

}