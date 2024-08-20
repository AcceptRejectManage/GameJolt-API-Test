package com.epicness.gamejoltapitest.stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Cell {

    private final float x, y, size;
    public Shape shape;

    public Cell(float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.rectangle(x, y, size, size);
        if (shape != null) shape.draw(shapeDrawer);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}