package com.epicness.gamejoltapitest.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text {

    private final BitmapFont font;
    public String text;
    private final float x, y;

    public Text(BitmapFont font, float x, float y) {
        this.font = font;
        text = "Welcome";
        this.x = x;
        this.y = y;
    }

    public void draw(SpriteBatch spriteBatch) {
        font.draw(
            spriteBatch,
            text,
            x,
            y
        );
    }
}