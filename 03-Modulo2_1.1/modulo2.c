#include <stdio.h>

typedef struct retangulo
{
    int x, y;
    int w, h;
    float rot;
    int r, g, b;
}retangulo;

int print(retangulo* r1)
{
    printf(
        "Os dados do ratangulo são: Tamanho (%d %d)\n Posição (%d %d)\n Cor(%d %d %d)\n Giro(%.2f)\n",
        r1->w, r1->h, r1->x, r1->y, r1->r, r1->g, r1->b, r1->rot
    );
    return 0;
}

int main(void)
{
    retangulo r1;
    r1.x = 10; 
    r1.y = 10;
    r1.w = 30;
    r1.h = 50;
    r1.rot = 0.0;
    r1.r = r1.g = r1.b = 200;
    print(&r1);
    return 0;
}
