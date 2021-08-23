package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Texto2 {
    int x, y;
    String text;

    public Texto2 (int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public void paint (Graphics g,int r1, int g1, int b1) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(r1,g1,b1));
        g2d.drawString(this.text,this.x,this.y);
    }
}
