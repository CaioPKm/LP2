import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures2.*;

class PackApp2 {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect2 r1;
    Ellipse2 e1;
    Texto2 t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect2(50,50, 100,30,0,255,0,155,0,0);
        this.e1 = new Ellipse2(50,100, 100,30,255,0,0,0,255,0);
        this.t1 = new Texto2(50,150,"Hello World!!!",0,0,255);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.t1.paint(g);
    }
}
