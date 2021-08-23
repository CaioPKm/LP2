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
    Rect r1;
    Ellipse e1;
    Texto t1;

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
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
        this.t1 = new Texto(50,150,"Hello World!!!");
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g,0,255,0,0,0,0);
        this.e1.paint(g,255,0,0,0,0,0);
        this.t1.paint(g,0,0,255);
    }
}
