package com.epicness.gamejoltapitest.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {

    private final Logic logic;
    public boolean enabled;

    public InputHandler(Logic logic) {
        this.logic = logic;
        Gdx.input.setInputProcessor(this);
        enabled = false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!enabled) return false;

        logic.getMoveHandler().attemptMove(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }
}