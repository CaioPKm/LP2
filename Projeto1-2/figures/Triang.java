package figures;

import java.awt.*;
import  java.awt.Polygon;

public class Triang extends Figure{
    Polygon p;
    int p1,p2;
    int r2, g2, b2;
    public Triang(int x,int y, int p1,int p2, int w,int h, int r,int g,int b, int r2,int g2,int b2){
        super(x, y, r, g, b, w,h);
        this.p1 = p1;
        this.p2 = p2;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        p = new Polygon();
        p.xpoints = new int[]{this.x,this.w,this.p1};
        p.ypoints = new int[]{this.y,this.h,this.p2};
        p.npoints = 3;
    }
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillPolygon(p);
        
        g2d.setColor(new Color(this.r2,this.g2,this.b2));
        g2d.drawPolygon(p);
    }
    
    public boolean clicked (int x, int y) {
        return p.contains(x,y);
        //return (this.x <= x && x<= this.x + this.w && this.y <= y && y <= this.y + this.h);
    }
    
    public void drag (int dx, int dy) { 
        p.xpoints[0] += dx ;
        p.ypoints[0] += dy ;
        
        p.xpoints[1] += dx ;
        p.ypoints[1] += dy ;

        p.xpoints[2] += dx ;
        p.ypoints[2] += dy ;
    
    }

    public void focusRef (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        g2d.drawRect(p.xpoints[0]-2, p.ypoints[0]-2, (this.w - this.x)+4,(this.h - this.y)+4);
    }
    
}