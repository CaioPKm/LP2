package figures;

import java.awt.*;
import java.awt.font.TextAttribute;

public class Texto extends Figure{
    String text;
    public Texto (int x, int y, String text, int r, int g, int b, int w, int h) {
        super(x, y, r, g, b, w,h);
        this.text = text;
    }

    public void paint (Graphics g, boolean focus) {
        Graphics2D g2d = (Graphics2D) g;
        
        if (focus){
            //System.out.println(g2d.getFontMetrics());
            g2d.setColor(Color.red);
        }
        else {
            g2d.setColor(new Color(this.r,this.g,this.b));
        }
        
        this.w = 50;
        this.h = 16;
        
        g2d.drawString(this.text,this.x,this.y);
    }

    public boolean clicked (int ex, int ey) {
        //return (this.x <= x && x<= this.x + this.w && this.y <= y && y <= this.y + this.h);
        if (ex >= this.x && ex<=this.x + this.w && ey<=this.y && ey>=this.y-this.h){
            return true;
        }
        return false;
    }
    
}