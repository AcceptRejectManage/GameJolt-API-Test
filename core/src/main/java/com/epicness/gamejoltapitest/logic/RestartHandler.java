package com.epicness.gamejoltapitest.logic;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;

import com.epicness.gamejoltapitest.Listener;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Rect;
import com.epicness.gamejoltapitest.stuff.Text;

public class RestartHandler {

    private final Logic logic;
    private final Grid grid;
    private final Rect frame;
    private final Text restartText, message;
    private boolean hidden;

    public RestartHandler(Logic logic, Grid grid, Rect frame, Text restartText, Text message) {
        this.logic = logic;
        this.grid = grid;
        this.frame = frame;
        this.restartText = restartText;
        this.message = message;
    }

    public void touchDown(float x, float y) {
        if (hidden) return;

        if (frame.contains(x, y)) {
            message.text = "Restarting...";
            logic.getAPIWrapper().resetGrid(new Listener() {
                @Override
                public void onSuccess() {
                    hideRestart();
                    logic.getTurnHandler().updateTurn();
                    grid.clear();
                }

                @Override
                public void onFail() {
                    message.text = "Failed to restart game";
                }
            });
        }
    }

    public void showRestart() {
        frame.color.set(BLACK);
        restartText.font.setColor(WHITE);
        hidden = false;
    }

    public void hideRestart() {
        frame.color.set(CLEAR);
        restartText.font.setColor(CLEAR);
        hidden = true;
    }
}