package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Stuff {

    private final Text text;
    private final Grid grid;

    public Stuff() {
        text = new Text(new BitmapFont(), 200f, 100f);
        grid = new Grid(GRID_COLS, GRID_ROWS);
    }

    public Text getText() {
        return text;
    }

    public Grid getGrid() {
        return grid;
    }
}