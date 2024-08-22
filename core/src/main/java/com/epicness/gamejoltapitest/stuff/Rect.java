package com.epicness.gamejoltapitest.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Rect extends Rectangle {

    public final Color color;

    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
        color = new Color(0f, 0f, 0f, 1f);
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.filledRectangle(this, color);
    }
}