
import java.awt.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
public class Circle extends Oval implements EnclosesRegion{
    
    public Circle() {
    }
    
    public Circle(Point startPoint) {
        super(startPoint);
    }
    
    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
        if(this.startPoint != null) {
            g.setColor(this.getColour());
            // Direction of the expansion based on user's mouse movement
            if(filled) {
                // get new X and Y coords
                int X = (int)startPoint.getX() - (int)controlPoint.getX();
                int Y = (int)startPoint.getY() - (int)controlPoint.getY();
                
                // get radius
                int r = Math.max(X, Y);
                g.fillOval((int)startPoint.getX() - r, (int)startPoint.getY() - r, (2*r), (2*r));
            } else {
                // get new X and Y coords
                int X = (int)startPoint.getX() - (int)controlPoint.getX();
                int Y = (int)startPoint.getY() - (int)controlPoint.getY();
                
                //get radius
                int r = Math.max(X, Y);
                g.drawOval(startPoint.x - r,startPoint.y - r, (2*r), (2*r));
            }  
        }
    }
}
