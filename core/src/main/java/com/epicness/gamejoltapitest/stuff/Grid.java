package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.CELL_SIZE;
import static com.epicness.gamejoltapitest.Constants.GRID_X;
import static com.epicness.gamejoltapitest.Constants.GRID_Y;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Grid {

    private final Cell[][] cells;

    public Grid(int cols, int rows) {
        cells = new Cell[cols][];
        float x, y;
        for (int col = 0; col < cells.length; col++) {
            cells[col] = new Cell[rows];
            for (int row = 0; row < cells[col].length; row++) {
                x = GRID_X + col * CELL_SIZE;
                y = GRID_Y + row * CELL_SIZE;
                cells[col][row] = new Cell(x, y, CELL_SIZE);
            }
        }
    }

    public void draw(ShapeDrawer shapeDrawer) {
        for (int col = 0; col < cells.length; col++) {
            for (int row = 0; row < cells[col].length; row++) {
                cells[col][row].draw(shapeDrawer);
            }
        }
    }
}