package com.epicness.gamejoltapitest;

import static com.badlogic.gdx.graphics.Color.NAVY;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.gamejoltapitest.stuff.Stuff;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Renderer {

    private final ShapeDrawer shapeDrawer;
    private final Stuff stuff;

    public Renderer(Stuff stuff) {
        shapeDrawer = new ShapeDrawer(new SpriteBatch(), new TextureRegion(new Texture("pixel.png")));
        this.stuff = stuff;
    }

    public void render() {
        ScreenUtils.clear(NAVY);

        shapeDrawer.getBatch().begin();
        stuff.getGrid().draw(shapeDrawer);
        shapeDrawer.getBatch().end();
    }
}