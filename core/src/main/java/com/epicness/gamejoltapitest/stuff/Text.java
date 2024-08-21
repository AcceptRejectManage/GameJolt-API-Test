package com.epicness.gamejoltapitest.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text {

    public final BitmapFont font;
    public String text;
    public float x, y;

    public Text(BitmapFont font) {
        this.font = font;
        text = "";
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