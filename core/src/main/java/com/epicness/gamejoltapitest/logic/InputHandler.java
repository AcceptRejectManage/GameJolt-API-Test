package com.epicness.gamejoltapitest.logic;

import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {

    private final Logic logic;

    public InputHandler(Logic logic) {
        this.logic = logic;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        logic.getMoveHandler().attemptMove(screenX, screenY);
        return false;
    }
}