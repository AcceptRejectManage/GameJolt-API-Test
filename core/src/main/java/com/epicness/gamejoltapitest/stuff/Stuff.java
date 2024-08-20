package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;

public class Stuff {

    private final Grid grid;

    public Stuff() {
        grid = new Grid(GRID_COLS, GRID_ROWS);
    }

    public Grid getGrid() {
        return grid;
    }
}