import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

import java.util.ArrayList;
import java.util.Random;

import figures.*; 

class ProjetoApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>(); // Lista heterogenea de figuras
    ArrayList<Button> buts = new ArrayList<Button>();// Lista heterogenea de Botões  
    Random rand = new Random();
    Figure focused = null; //figura que vai ficar em foco
    Point mouse = null; //pontos (x,y) do mouse
    Button but_focus = null; // botão em foco
    boolean but_clicked = false; // MUITO IMPORTENTE, VAI FAZER EU CONSEGUIR DEIXAR O BOTÃO FUNCIONAL
    int disx,disy;
    boolean moviment = false;
    int index;

    ListFrame () {

        
        buts.add(new Button(0, new Triang(24,24, 0,0, 0,0,0, 0,0,0)));// botão para triangulo
        buts.add(new Button(1, new Ellipse(205,123, 0,0, 0,0,0, 0,0,0)));// botão pra ellipse
        buts.add(new Button(2, new Texto(28, 233, 0, 0, 0, 0,0))); // botão para texto 
        buts.add(new Button(3, new Rect(24,144, 0,0, 0,0,0, 0,0,0))); //botão para rectangulo
                                        
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
            System.out.println("ERRO!!! <Em abrir o arquivo>");
        }
        

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                        System.out.println("ERRO!!! <Em escrever o arquivo>");
                    }
                    System.exit(0);
                }
            }

        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    mouse = evt.getPoint();
                    focused = null;
                    but_focus = null;
                    but_clicked = false;
                    
                    for (int i = 0; i < figs.size(); i++) {
                        if (figs.get(i).clicked(mouse.x,mouse.y)) {
                            focused = figs.get(i); // figura em foco
                            but_focus = null;
                            but_clicked = false;
                        }
                    }
                  
                    if (focused != null) { // maior ponto Z
                        figs.remove(focused);
                        figs.add(focused);
                    }
                    
                    for (int i=0; i< buts.size(); i++) {
                        if(buts.get(i).clicked(mouse.x,mouse.y)){ // botão em foco
                            but_focus = buts.get(i);
                            focused = null;
                            but_clicked = true;
                        }
                        
                    }
                    repaint();
                    if (focused == null && but_focus != null){
                        if (but_focus == buts.get(1)) { // criação de figuras com o click do mouse e com o botão selecionado
                            Figure fig = new Ellipse(mouse.x,mouse.y, 50,50, rand.nextInt(255),rand.nextInt(255),rand.nextInt(255), 
                                                                            rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)); // nova figura criada ellipse                                                    
                            figs.add(fig); // nova figura para a  mesma lista
                            focused = fig;
                            but_focus = null;
                        }
                        else if (but_focus == buts.get(2)) {
                            Figure fig = new Texto(mouse.x,mouse.y, rand.nextInt(255),rand.nextInt(255),rand.nextInt(255), 50,50); // nova figura criada texto 
                            figs.add(fig); // nova figura para a  mesma lista
                            focused = fig;
                            but_focus = null;
                        }
                        else if (but_focus == buts.get(0)) {
                            Figure fig = new Triang(mouse.x,mouse.y, 50,50, rand.nextInt(255),rand.nextInt(255),rand.nextInt(255), 
                                                                        rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)); // nova figura criada triangulo
                                figs.add(fig); // nova figura para a  mesma lista
                                focused = fig;
                                but_focus = null;
                        }
                        else if (but_focus == buts.get(3)) {
                            Figure fig = new Rect(mouse.x,mouse.y, 50,50, rand.nextInt(255),rand.nextInt(255),rand.nextInt(255), 
                                                                        rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)); // nova figura criada retangulo
                            figs.add(fig); // nova figura para a  mesma lista 
                            focused = fig;
                            but_focus = null;
                        }
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
                         x = rand.nextInt(250);
                         y = rand.nextInt(250);
                    }
                    else {
                         x = mouse.x;
                         y = mouse.y;
                    }
                    int w = 50;
                    int h = 50; 
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
                        Figure fig = new Texto(x, y, r, g, b, w,h); // nova figura criada texto 
                        figs.add(fig); // nova figura para a  mesma lista
                        focused = fig;
                    } else if(evt.getKeyChar() == 'y') {
                        /*w = x+100;
                        h = y+100;*/
                        Figure fig = new Triang(x,y, w,h, r,g,b, r2,g2,b2); // nova figura criada triangulo
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
 
        this.setTitle("Pojeto2/2");
        this.setSize(300, 300);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Button but: this.buts)  { // paint dos botoes 
            but.paint(g,but == but_focus);
        }

        for(Figure fig : this.figs) { // paint das figuras
            fig.paint(g,fig == focused);
        }
    }
}

