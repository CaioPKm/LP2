package figures;

import invisible.Invisible;

public abstract class Figure implements Invisible {
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

    public abstract boolean clicked (int x, int y);

}
