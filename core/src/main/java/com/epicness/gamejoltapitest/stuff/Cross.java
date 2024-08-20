package com.epicness.gamejoltapitest.stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Cross extends Shape {

    private final float size;

    public Cross(float x, float y, float size) {
        super(x, y);
        this.size = size;
    }

    @Override
    void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.line(x, y, x + size, y + size);
        shapeDrawer.line(x, y + size, x + size, y);
    }
}