package com.epicness.gamejoltapitest.stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Circle extends Shape {

    private final float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.circle(x, y, radius);
    }
}
