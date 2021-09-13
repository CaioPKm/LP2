package figures;

import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int w, h;
    public int r, g, b;
    public Figure (int x, int y, int w, int h, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public abstract void paint (Graphics g);
}