package figures;

import java.awt.*;
import  java.awt.Polygon;

public class Triang extends Figure{
    private Polygon p;
    private int p1,p2;
    private int r2, g2, b2;
    public Triang(int x,int y, int w,int h, int r,int g,int b, int r2,int g2,int b2){
        super(x, y, r, g, b, w,h);
        this.w = x+30;
        this.h = y+30;
        this.p1 = this.x;
        this.p2 = this.h;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        p = new Polygon();
        p.xpoints = new int[]{this.x,this.w,this.p1};
        p.ypoints = new int[]{this.y,this.h,this.p2};
        p.npoints = 3;
    }
    public void paint (Graphics g, boolean focus){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillPolygon(p);
    
        if (focus) {
            g2d.setPaint(Color.red);
            g2d.drawPolygon(p);
        } 
        else{       
            g2d.setColor(new Color(this.r2,this.g2,this.b2));
            g2d.drawPolygon(p);
        }
    }

    public void drag (int dx, int dy) { 
        this.x += dx;
        this.y += dy;

        this.w += dx;
        this.h += dy;

        this.p1 += dx;
        this.p2 += dy;
        
        p.xpoints = new int[]{this.x,this.w,this.p1};
        p.ypoints = new int[]{this.y,this.h,this.p2}; 
    }
    
    
    public boolean clicked (int x, int y) {
        //return p.contains(x,y);
        return (this.x <= x && x<= this.w && this.y <= y && y <= this.h );
    }
    
    
}
