package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Texto extends Figure{
    int x, y;
    String text;
    int r, g, b;
    public Texto (int x, int y, String text, int r, int g, int b ) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.drawString(this.text,this.x,this.y);
    }
}