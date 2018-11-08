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

public class Line extends Shape{

    // Line will not be fillable 
    public Line() {
    }
    
    public Line(Point startPoint) {
        super(startPoint);
    }
    
    // Direction of the expansion based on user's mouse movement
    @Override
    public void draw(Graphics g) {
        if(this.startPoint != null) {
            g.setColor(this.getColour());
            g.drawLine(startPoint.x, startPoint.y, controlPoint.x, controlPoint.y);
        }
    }
}   