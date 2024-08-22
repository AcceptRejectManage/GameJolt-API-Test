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

        screenY = Gdx.graphics.getHeight() - screenY;
        logic.getMoveHandler().attemptMove(screenX, screenY);
        logic.getRestartHandler().touchDown(screenX, screenY);
        return false;
    }
}