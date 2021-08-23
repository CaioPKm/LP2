package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Texto {
    int x, y;
    String text;

    public Texto (int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(this.text,this.x,this.y);
    }
}
