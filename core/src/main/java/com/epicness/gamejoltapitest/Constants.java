package com.epicness.gamejoltapitest;

public class Constants {

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 700;

    public static final int GRID_COLS = 3;
    public static final int GRID_ROWS = 3;
    public static final float CELL_SIZE = 100f;
    public static final float GRID_WIDTH = GRID_COLS * CELL_SIZE;
    private static final float GRID_HEIGHT = GRID_ROWS * CELL_SIZE;
    public static final float GRID_X = WINDOW_WIDTH / 2f - GRID_WIDTH / 2f;
    public static final float GRID_Y = WINDOW_HEIGHT / 2f - GRID_HEIGHT / 2f;

    public static final float CIRCLE_RADIUS = CELL_SIZE * 0.4f;
    public static final float CIRCLE_OFFSET = CELL_SIZE / 2f;

    public static final float CROSS_SIZE = CELL_SIZE * 0.8f;
    public static final float CROSS_OFFSET = CELL_SIZE / 2f - CROSS_SIZE / 2f;

    public static final float POLL_INTERVAL = 5f;
}