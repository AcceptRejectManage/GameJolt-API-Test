package com.epicness.gamejoltapitest.stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Cell {

    public final int col, row;
    public final float x, y, size;
    public Shape shape;

    public Cell(int col, int row, float x, float y, float size) {
        this.col = col;
        this.row = row;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.rectangle(x, y, size, size);
        if (shape != null) shape.draw(shapeDrawer);
    }

    public char getShapeRepresentation() {
        if (shape == null) {
            return 'A';
        } else if (shape instanceof Cross) {
            return 'X';
        } else {
            return 'O';
        }
    }
}