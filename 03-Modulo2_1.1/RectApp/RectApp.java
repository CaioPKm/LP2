public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10); 
        r1.print();
        r1.area();
        r1.drag(10,10);
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
    void area (){
        int area = this.w * this.h; 
        System.out.format("Retangulo de tamanho(%d %d) tem area igual (%d)\n",this.w, this.h, area);
    }
    void drag (int nx, int ny){
        int dx = this.x + nx; 
        int dy = this.y + ny;
        System.out.format("Retangulo de na posicao (%d,%d) foi movido para a posicao (%d %d)\n",this.w, this.h, dx, dy);
    }

}
