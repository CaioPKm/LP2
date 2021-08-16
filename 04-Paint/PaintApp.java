import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintApp {
    public static void main (String[] args) {
        Paint obj = new Paint();
        obj.setVisible(true);
     }
}
 
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
    System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
       this.w, this.h, this.x, this.y);
    }
     void paint (Graphics g,int r1 , int g1, int b1, int r2 , int g2, int b2) {
         Graphics2D g2d = (Graphics2D) g;
         g2d.setColor(new Color(r1,g1,b1));
         g2d.fillRect(this.x, this.y, this.w, this.h);
         g2d.setColor(new Color(r2,g2,b2));
         g2d.drawRect(this.x, this.y, this.w, this.h);
     }

}

class Paint extends JFrame {
    Rect r1, r2, r3;
    public Paint () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.setTitle("Java2D - Paint Frame");
        this.setSize(350, 350);
        this.setVisible(true);
        
        this.r1 = new Rect(1,1,20,60);
        this.r2 = new Rect(50,100,100,50);
        this.r3 = new Rect(100,40,60,75);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g,0,255,0,0,0,0);
        this.r2.paint(g,255,0,0,0,255,0);
        this.r3.paint(g,0,0,255,255,0,0);
    }
}
