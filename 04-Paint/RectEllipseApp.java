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
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
        this.e2 = new Ellipse(100,150, 200,30);
        this.e3 = new Ellipse(5,200, 30,100);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g,0,255,0,0,0,0);
        this.e1.paint(g,255,0,0,0,0,0);
        this.e2.paint(g,1,150,47,0,0,0);
        this.e3.paint(g,0,0,255,0,0,0);
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

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g,int r1 , int g1, int b1, int r2 , int g2, int b2) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(r1,g1,b1));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(r2,g2,b2));
        g2d.drawOval(this.x, this.y, this.w, this.h);
    }
}
