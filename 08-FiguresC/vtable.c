#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef void (* Figure_Drag)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    void (* drag)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));

}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void rect_drag (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("\n\nO Retangulo foi movido para a posicao(%d,%d)\n\n",sup->x+15,sup->y+15);
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Drag)  rect_drag
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n", this->w, this->h, sup->x, sup->y,
     sup->vtable->area(sup));

}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

void ellipse_drag (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("\n\nA Ellipse foi movido para a posicao(%d,%d)\n\n",sup->x+15,sup->y+15);
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Drag)  ellipse_drag
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct
{
    Figure super;
    char* text;
    int w, h; 
}Texto;

void texto_print(Texto* this)
{
    Figure* sup = (Figure*) this;
    printf("Texto de conteudo (%s) na posicao (%d,%d) de tamanho (%d,%d) e area(%d).\n",this->text, sup->x,sup->y,
     this->w, this->h, sup->vtable->area(sup));

}

void texto_drag (Texto* this) {
    Figure* sup = (Figure*) this;
    printf("\nO Texto foi movido para a posicao(%d,%d)\n\n",sup->x+15,sup->y+15);
}

int texto_area (Texto* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable texto_vtable = {
    (Figure_Print) texto_print,
    (Figure_Area)  texto_area,
    (Figure_Drag)  texto_drag
};

Texto* texto_new (int x, int y, int w, int h, char* text)
{
    Texto* this = malloc(sizeof(Texto));
    Figure* sup = (Figure*) this;
    sup->vtable = &texto_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->text = text;

}

///////////////////////////////////////////////////////////////////////////////

typedef struct
{
    Figure super;
    int w, h; 
}Triag;

void triang_print(Triag* this)
{
    Figure* sup = (Figure*) this;
    printf("Triangulo na posicao (%d,%d) de tamanho (%d,%d) e area(%d).\n",this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));

}

int triang_area (Triag* this) {
    Figure* sup = (Figure*) this;
    return (this->w * this->h)/2;
}

void triang_drag (Triag* this) {
    Figure* sup = (Figure*) this;
    printf("\n\nO Texto foi movido para a posicao(%d,%d)\n\n",sup->x+15,sup->y+15);
}

Figure_vtable triang_vtable = {
    (Figure_Print) triang_print,
    (Figure_Area)  triang_area,
    (Figure_Drag)  triang_drag
};

Triag* triang_new(int x, int y, int w, int h)
{
    Triag* this = malloc(sizeof(Triag));
    Figure* sup = (Figure*) this;
    sup->vtable = &triang_vtable;
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
        (Figure*) triang_new(50,30,110,255),
        (Figure*) texto_new (75,57,30,30,"abcd"),
        (Figure*) triang_new(50,30,110,400),
        (Figure*) texto_new (55,77,30,50,"abcd"),
    };

    for (int i=0; i<8; i++) 
        figs[i]->vtable->print(figs[i]);
    
    for (int i=0; i<8; i++) 
        figs[i]->vtable->drag(figs[i]);

    for (int i=0; i<4; i++) 
        free(figs[i]);
    
}
