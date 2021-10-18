import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*;

class IfaceApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>(); // Lista heterogenea
    Random rand = new Random();
    Figure focused = null; //figura que vai ficar em foco
    Point mouse = null; //pontos (x,y) do mouse
    int disx,disy;
    boolean moviment = false;
    int index;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    mouse = evt.getPoint();
                    focused = null;
                    for (int i = 0; i < figs.size(); i++) {
                        if (figs.get(i).clicked(mouse.x,mouse.y)) {
                            focused = figs.get(i); // figura em foco
                        }
                    }
                    if (focused != null) { // maior ponto Z
                        figs.remove(focused);
                        figs.add(focused);
                    }
                    repaint();
                }
                
                 
            }
        
        );
        
        this.addMouseMotionListener( 
            new MouseAdapter() {
                public void mouseDragged (MouseEvent evt) { // adiconar movimento da figurar arrastando ela
                    if(focused != null){
                        int dx = evt.getX() - mouse.x;
                        int dy = evt.getY() - mouse.y;
                        focused.drag(dx, dy);
                        repaint();
                    }
                    mouse = evt.getPoint();
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) { // parametros para construção das figuras
                    int x;
                    int y;
                    if (mouse == null) {
                         x = rand.nextInt(550);
                         y = rand.nextInt(550);
                    }
                    else {
                         x = mouse.x;
                         y = mouse.y;
                    }
                    int w = 100;
                    int h = 100; 
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int r2 = rand.nextInt(255);
                    int g2 = rand.nextInt(255);
                    int b2 = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                       Figure fig = new Rect(x,y, w,h, r,g,b, r2,g2,b2); // nova figura criada retangulo
                        figs.add(fig); // nova figura para a  mesma lista 
                        focused = fig;
                    } else if (evt.getKeyChar() == 'e') {
                        Figure fig = new Ellipse(x,y, w,h, r,g,b, r2,g2,b2); // nova figura criada ellipse
                        figs.add(fig); // nova figura para a  mesma lista
                        focused = fig;
                    } else if(evt.getKeyChar() == 't') {
                        Figure fig = new Texto(x, y, "HELLO!!!", r, g, b, w,h); // nova figura criada texto 
                        figs.add(fig); // nova figura para a  mesma lista
                        focused = fig;
                    } else if(evt.getKeyChar() == 'y') {
                        w = x+100;
                        h = y+100;
                        int x2 =  x; 
                        int y2 = h;  
                        Figure fig = new Triang(x,y, x2,y2, w,h, r,g,b, r2,g2,b2); // nova figura criada triangulo
                        figs.add(fig); // nova figura para a  mesma lista
                        focused = fig;
                    }
                    if (focused != null){
                        if (evt.getKeyCode() == KeyEvent.VK_UP){ //movimentar para cima
                            focused.drag(0,-5);   
                        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN){ //movimentar para baixo
                            focused.drag(0,5);
                        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT){ //movimentar para esquerda
                            focused.drag(-5,0);
                        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT){ //movimentar para direita
                            focused.drag(5,0);
                        } else if (evt.getKeyCode() == KeyEvent.VK_DELETE){ //deletar
                            figs.remove(focused);
                        }
                    }
                    repaint();
                }
            }
        );
 
        this.setTitle("Pojeto1/2");
        this.setSize(600, 600);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (int i = 0; i < figs.size(); i++) {
            figs.get(i).paint(g);
            if (figs.get(i) ==  focused){
                figs.get(i).focusRef(g); //desenhar um retangulo vermelhor na figura em foco
             }
        }
    }
}

