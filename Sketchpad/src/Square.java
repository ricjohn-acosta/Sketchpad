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

public class Square extends Rectangle {

    public Square() {
    }

    public Square(Point startPoint) {
        super(startPoint);
    }

    @Override
    public void draw(Graphics g) {
        if (this.startPoint != null) {
            // if user chooses filled
            if (filled) {
                g.setColor(this.getColour());
                // a and b sides for a square
                // Direction of the expansion based on user's mouse movement
                int a = 0;
                int b = 0;
                int x = startPoint.x;
                int y = startPoint.y;

                int X = Math.abs(controlPoint.x-startPoint.x);
                int Y = Math.abs(controlPoint.y-startPoint.y);
                
                int min = Math.min(X, Y);
                if ((startPoint.y > controlPoint.y) && (controlPoint.x > startPoint.x)) {
                    a += min;
                    b += min;
                    y -= min;
                } else if ((startPoint.y > controlPoint.y) && (controlPoint.x < startPoint.x)) {
                    a += min;
                    b += min;
                    y -= min;
                    x -= min;
                } else if ((startPoint.y < controlPoint.y) && (controlPoint.x < startPoint.x)) {
                    a = min;
                    b = min;
                } else if (controlPoint.y > startPoint.y && controlPoint.x > startPoint.x){
                    a = min;
                    b = min;
                }
                g.fillRect(x,y,a,b);   
            // if user doesn't choose filled
            } else {
                g.setColor(this.getColour());
                // a and b sides for a square
                int a = 0;
                int b = 0;
                int x = startPoint.x;
                int y = startPoint.y; 
                
                int X = Math.abs(controlPoint.x-startPoint.x);
                int Y = Math.abs(controlPoint.y-startPoint.y);
                
                int min = Math.min(X, Y);
                if ((startPoint.y > controlPoint.y) && (controlPoint.x > startPoint.x)) {
                    a += min;
                    b += min;
                    y -= min;
                } else if ((startPoint.y > controlPoint.y) && (controlPoint.x < startPoint.x)) {
                    a += min;
                    b += min;
                    y -= min;
                    x -= min;
                } else if ((startPoint.y < controlPoint.y) && (controlPoint.x < startPoint.x)) {
                    a += min;
                    b += min;
                    x -= min;
                }else if (controlPoint.y > startPoint.y && controlPoint.x > startPoint.x){
                    a = min;
                    b = min;
                }
                g.drawRect(x,y,a,b);          
            }
        }
    }
}
