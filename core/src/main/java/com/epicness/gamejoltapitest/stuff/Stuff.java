package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;
import static com.epicness.gamejoltapitest.Constants.GRID_WIDTH;
import static com.epicness.gamejoltapitest.Constants.GRID_X;
import static com.epicness.gamejoltapitest.Constants.GRID_Y;
import static com.epicness.gamejoltapitest.Constants.WINDOW_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.epicness.gamejoltapitest.Utils;

public class Stuff {

    private final Text timerText;
    private final Text message;
    private final Grid grid;
    private final Rect restartFrame;
    private final Text restartText;

    public Stuff() {
        timerText = new Text();
        timerText.x = WINDOW_WIDTH / 2f;
        timerText.y = 600f;
        timerText.text = "Timer Stopped";

        message = new Text();
        Vector2 size = Utils.getTextSize(message.font, message.text);
        message.x = WINDOW_WIDTH / 2f - size.x / 2f;
        message.y = 100f;

        grid = new Grid(GRID_COLS, GRID_ROWS);

        restartFrame = new Rect(GRID_X + GRID_WIDTH + 50f, GRID_Y, 150f, 40f);
        restartText = new Text();
        restartText.x = GRID_X + GRID_WIDTH + 50f + 55f;
        restartText.text = "Restart";
        restartText.y = Utils.getTextSize(restartText.font, restartText.text).y + GRID_Y + 15f;
    }

    public Text getTimerText() {
        return timerText;
    }

    public Text getMessage() {
        return message;
    }

    public Grid getGrid() {
        return grid;
    }

    public Rect getRestartFrame() {
        return restartFrame;
    }

    public Text getRestartText() {
        return restartText;
    }
}