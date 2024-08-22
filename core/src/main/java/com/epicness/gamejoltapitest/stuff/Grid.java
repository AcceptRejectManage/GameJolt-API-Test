package com.epicness.gamejoltapitest.stuff;

import static com.epicness.gamejoltapitest.Constants.CELL_SIZE;
import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;
import static com.epicness.gamejoltapitest.Constants.GRID_X;
import static com.epicness.gamejoltapitest.Constants.GRID_Y;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Grid {

    public final Cell[][] cells;

    public Grid(int cols, int rows) {
        cells = new Cell[cols][];
        float x, y;
        for (int col = 0; col < cells.length; col++) {
            cells[col] = new Cell[rows];
            for (int row = 0; row < cells[col].length; row++) {
                x = GRID_X + col * CELL_SIZE;
                y = GRID_Y + row * CELL_SIZE;
                cells[col][row] = new Cell(col, row, x, y, CELL_SIZE);
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

    public Cell getCellAtPosition(float x, float y) {
        int col = (int) ((x - GRID_X) / CELL_SIZE);
        int row = (int) ((y - GRID_Y) / CELL_SIZE);
        if (col < 0 || row < 0 || col >= cells.length || row >= cells[col].length) return null;
        return cells[col][row];
    }

    public String toData() {
        StringBuilder gridData = new StringBuilder();
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                gridData.append(cells[col][row].getShapeRepresentation());
            }
        }
        return gridData.toString();
    }

    public void clear() {
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[col][row].shape = null;
            }
        }
    }

    public boolean isEmpty() {
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                if (cells[col][row].shape != null) return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                if (cells[col][row].shape == null) return false;
            }
        }
        return true;
    }
}