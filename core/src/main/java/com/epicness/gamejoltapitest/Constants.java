package com.epicness.gamejoltapitest;

public class Constants {

    public static final int WINDOW_SIZE = 800;

    public static final int GRID_COLS = 3;
    public static final int GRID_ROWS = 3;
    public static final float CELL_SIZE = 100f;
    private static final float GRID_WIDTH = GRID_COLS * CELL_SIZE;
    private static final float GRID_HEIGHT = GRID_ROWS * CELL_SIZE;
    public static final float GRID_X = WINDOW_SIZE / 2f - GRID_WIDTH / 2f;
    public static final float GRID_Y = WINDOW_SIZE / 2f - GRID_HEIGHT / 2f;
}