package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Texto extends Figure{
    String text;
    public Texto (int x, int y, String text, int r, int g, int b ) {
        super(x,y, r,g,b);
        this.text = text;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.drawString(this.text,this.x,this.y);
    }
}