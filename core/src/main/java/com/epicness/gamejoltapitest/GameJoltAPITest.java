package com.epicness.gamejoltapitest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.epicness.gamejoltapitest.logic.Logic;
import com.epicness.gamejoltapitest.stuff.Stuff;
import com.github.raeleus.gamejoltapi.GameJoltApi;

public class GameJoltAPITest extends Game {

    private Renderer renderer;
    private Logic logic;
    private boolean d,g;

    @Override
    public void create() {
        GameJoltApi api = new GameJoltApi();
        Stuff stuff = new Stuff();
        renderer = new Renderer(stuff);
        logic = new Logic(api);
    }

    @Override
    public void render() {
        if (Gdx.graphics.getDeltaTime() < 0.1f) {
            logic.update(Gdx.graphics.getDeltaTime());
            renderer.render();
        }
    }
}