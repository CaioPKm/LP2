public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(5,5, 10,10); 
        r1.print();
        printArea(r1,r1.area());
        r1.drag(10,10);
        print(r1);
     }
     static void printArea (Rect r, int a) {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d) tem area (%d).\n",
            r.w, r.h, r.x, r.y, a);
    }
    static void print (Rect r) {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            r.w, r.h, r.x, r.y);
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
    int area (){
        int area = this.w * this.h;
        return area;
    }
    void drag (int nx, int ny){
        this.x = this.x + nx; 
        this.y= this.y + ny;
    }

}
