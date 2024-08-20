package com.epicness.gamejoltapitest;

import static com.badlogic.gdx.graphics.Color.NAVY;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.gamejoltapitest.stuff.Stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Renderer {

    private final SpriteBatch spriteBatch;
    private final ShapeDrawer shapeDrawer;
    private final Stuff stuff;

    public Renderer(Stuff stuff) {
        spriteBatch = new SpriteBatch();
        shapeDrawer = new ShapeDrawer(spriteBatch, new TextureRegion(new Texture("pixel.png")));
        this.stuff = stuff;
    }

    public void render() {
        ScreenUtils.clear(NAVY);

        spriteBatch.begin();
        stuff.getText().draw(spriteBatch);
        stuff.getGrid().draw(shapeDrawer);
        spriteBatch.end();
    }
}