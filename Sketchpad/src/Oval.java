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

public class Oval extends Shape implements EnclosesRegion {

    public Oval() {
    }

    public Oval(Point startPoint) {
        super(startPoint);
    }

    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
        if (this.startPoint != null) {
            g.setColor(this.getColour());
            // Direction of the expansion based on user's mouse movement
            if (filled) {
                int height = ((int) Math.abs(startPoint.y - controlPoint.y) * 2);
                int width = ((int) Math.abs(startPoint.x - controlPoint.x) * 2);
                // obtain new X and Y coords
                int X = Math.abs(controlPoint.x - startPoint.x);
                int Y = Math.abs(controlPoint.y - startPoint.y);
                // fill oval if filled is selected
                g.fillOval(startPoint.x - X, startPoint.y - Y, width, height);
            } else {
                int height = ((int) Math.abs(startPoint.y - controlPoint.y) * 2);
                int width = ((int) Math.abs(startPoint.x - controlPoint.x) * 2);    
                // obtain new X and Y coords
                int X = Math.abs(controlPoint.x - startPoint.x);
                int Y = Math.abs(controlPoint.y - startPoint.y);
                // leave oval hollow
                g.drawOval(startPoint.x - X, startPoint.y - Y, width, height);
            }
        }
    }
}
