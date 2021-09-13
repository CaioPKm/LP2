package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    int r2, g2, b2;
    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int r2, int g2, int b2) {
        super(x,y,w,h,r,g,b);
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.r2,this.g2,this.b2));
        g2d.drawOval(this.x, this.y, this.w, this.h);
    }
}