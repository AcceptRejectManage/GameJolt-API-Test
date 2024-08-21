package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;
import static com.epicness.gamejoltapitest.Constants.WINDOW_WIDTH;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.epicness.gamejoltapitest.Utils;

public class Stuff {

    private final Text message;
    private final Grid grid;

    public Stuff() {
        message = new Text(new BitmapFont());
        message.text = "Loading game state";
        Vector2 size = Utils.getTextSize(message.font, message.text);
        message.x = WINDOW_WIDTH / 2f - size.x / 2f;
        message.y = 100f;

        grid = new Grid(GRID_COLS, GRID_ROWS);
    }

    public Text getMessage() {
        return message;
    }

    public Grid getGrid() {
        return grid;
    }
}