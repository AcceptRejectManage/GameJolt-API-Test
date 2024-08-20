package com.epicness.gamejoltapitest.stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public abstract class Shape {

    protected final float x, y;

    public Shape(float x, float y) {
        this.x = x;
        this.y = y;
    }
    abstract void draw(ShapeDrawer shapeDrawer);
}