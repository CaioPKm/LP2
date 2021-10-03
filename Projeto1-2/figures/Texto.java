package figures;

import java.awt.*;
import java.awt.font.TextAttribute;

public class Texto extends Figure{
    String text;
    public Texto (int x, int y, String text, int r, int g, int b, int w, int h) {
        super(x, y, r, g, b, w,h);
        this.text = text;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setColor(new Color(this.r,this.g,this.b));
        //System.out.println(g2d.getFontMetrics());
        
        this.w = 50;
        this.h = 16;
        
        g2d.drawString(this.text,this.x,this.y);
    }

    public boolean clicked (int x, int y) {
        return (this.x <= x && x<= this.x + this.w && this.y <= y && y <= this.y + this.h);
    }
    
    public void focusRef (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.drawRect(this.x-2, this.y-2, this.w+2,this.h+2);
    }
}
