
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

public class Rectangle extends Shape implements EnclosesRegion {

    public Rectangle() {
    }

    public Rectangle(Point startPoint) {
        super(startPoint);
    }

    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
        if (this.startPoint != null) {
            // Direction of the expansion based on user's mouse movement
            if (filled) {
                g.setColor(this.getColour());
                // initial x and y coords
                int x = startPoint.x;
                int y = startPoint.y;
                
                // get new X and Y coords
                int X = Math.abs(controlPoint.x-startPoint.x);
                int Y = Math.abs(controlPoint.y-startPoint.y);
                
                // rubberbanding effect 
                if ((controlPoint.y <= startPoint.y) && (startPoint.x <= controlPoint.x)) {
                    y -= Y;
                } else if ((controlPoint.y < startPoint.y) && (startPoint.x > controlPoint.x)) {
                    y -= Y;
                    x -= X;
                } else if ((controlPoint.y >= startPoint.y) && (startPoint.x > controlPoint.x)) {
                    x -= X;
                }
                g.fillRect(x, y, X, Y);
            } else {
                g.setColor(this.getColour());
                // get initial x and y coords
                int x = startPoint.x;
                int y = startPoint.y;
                
                // get new X and Y coords
                int X = Math.abs(controlPoint.x-startPoint.x);
                int Y = Math.abs(controlPoint.y-startPoint.y);
                
                // rubberbanding effect
                if ((controlPoint.y <= startPoint.y) && (startPoint.x <= controlPoint.x)) {
                    y -= Y;
                } else if ((controlPoint.y < startPoint.y) && (startPoint.x > controlPoint.x)) {
                    y -= Y;
                    x -= X;
                } else if ((controlPoint.y >= startPoint.y) && (startPoint.x > controlPoint.x)) {
                    x -= X;
                }
                g.drawRect(x,y, X, Y);
            }        
        }
    }
}
