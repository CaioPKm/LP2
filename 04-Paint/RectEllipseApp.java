  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(1,1,20,60,255,0,0,0,0,0);
        this.e1 = new Ellipse(50,100, 100,30,1,150,47,0,0,0);
        this.e2 = new Ellipse(100,50,200,30,0,255,0,0,0,255);
        this.e3 = new Ellipse(5,200,30,100,0,0,255,255,0,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r, g, b;
    int r2, g2, b2;
    Rect (int x, int y, int w, int h, int r, int g, int b, int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
        }
         void paint (Graphics g) {
             Graphics2D g2d = (Graphics2D) g;
             g2d.setColor(new Color(this.r,this.g,this.b));
             g2d.fillRect(this.x, this.y, this.w, this.h);
             g2d.setColor(new Color(this.r2,this.g2,this.b2));
             g2d.drawRect(this.x, this.y, this.w, this.h);
         }
    
    }
class Ellipse {
    int x, y;
    int w, h;
    int r, g, b;
    int r2, g2, b2;
    Ellipse (int x, int y, int w, int h, int r, int g, int b, int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.r2,this.g2,this.b2));
        g2d.drawOval(this.x, this.y, this.w, this.h);
    }
}

