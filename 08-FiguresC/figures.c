#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure 
{
    int x, y;
    Color lns, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct 
{
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) 
{
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) 
{
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct 
{
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) 
{
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) 
{
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct
{
    Figure super;
    char text[4];
    int w, h; 
}Texto;

void Text_print(Texto* this)
{
    Figure* sup = (Figure*) this;
    printf("Texto de conteudo (%s) na posicao (%d,%d) de tamanho (%d,%d).\n",this->text, sup->x,sup->y, this->w, this->h);
}
Texto* text_new (int x, int y, int w, int h, char* text)
{
    Texto* this = malloc(sizeof(Texto));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Text_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->text = text[];

}

///////////////////////////////////////////////////////////////////////////////

typedef struct
{
    Figure super;
    int w, h; 
}Line;

void Line_print(Line* this)
{
    Figure* sup = (Figure*) this;
    printf("Linha na posicao (%d,%d) de tamanho (%d,%d).\n",this->w, this->h, sup->x, sup->y);
}

Line* line_new(int x, int y, int w, int h)
{
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) 
{
    Figure* figs[8] = 
    {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) line_new(50,30,110,255),
        (Figure*) text_new (75,57,30,30,"abcd"),
        (Figure*) line_new(50,30,110,400),
        (Figure*) text_new (55,77,30,50,"abcd"),
    };

    for (int i=0; i<8; i++) 
        figs[i]->print(figs[i]);

    for (int i=0; i<4; i++) 
        free(figs[i]);
    
}