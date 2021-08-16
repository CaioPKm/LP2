public class modulo2 {
    public static void main (String[] args){
        Texto p = new Texto(0,0,10,50,"Palavrinha");
        p.print();
    }
}

class Texto{
    int x, y;
    int w, h;
    String word;
    Texto(int x, int y, int w, int h, String word){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.word = word;
    }
    void print(){
        System.out.format("Os dados do ratangulo são: Tamanho (%d %d)\n Posição (%d %d)\n Escritura(%s)", this.w, this.h, this.x, this.y, this.word);
    }
}
