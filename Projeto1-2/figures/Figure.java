package figures;

import java.awt.Graphics;
import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    public int x,y;
    public int w,h;
    public int r, g, b;
    
    public Figure(int x, int y, int r, int g, int b, int w, int h) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.w = w;
        this.h = h;
    }

    public void drag(int dx, int dy) { // função par arrastar as figuras
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y) { //função para dectar quando o mouse clicar na figura
        return (this.x <= x && x<= this.x + this.w && this.y <= y && y <= this.y + this.h);
    } 
    
    
}
