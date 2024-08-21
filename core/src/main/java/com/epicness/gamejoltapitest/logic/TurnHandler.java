package com.epicness.gamejoltapitest.logic;

import static com.badlogic.gdx.Application.ApplicationType.Desktop;
import static com.badlogic.gdx.Application.ApplicationType.WebGL;
import static com.epicness.gamejoltapitest.Constants.GRID_COLS;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;

import com.badlogic.gdx.Gdx;
import com.epicness.gamejoltapitest.stuff.Cell;
import com.epicness.gamejoltapitest.stuff.Circle;
import com.epicness.gamejoltapitest.stuff.Cross;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Text;

public class TurnHandler {

    private final Grid grid;
    private final Text message;
    private boolean player1Turn;

    public TurnHandler(Grid grid, Text message) {
        this.grid = grid;
        this.message = message;
    }

    public void updateTurn() {
        int xCount = 0, oCount = 0;
        Cell cell;
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cell = grid.cells[col][row];
                if (cell.shape instanceof Cross) {
                    xCount++;
                }
                if (cell.shape instanceof Circle) {
                    oCount++;
                }
            }
        }
        player1Turn = xCount == oCount;
        message.text = player1Turn ? "Desktop Turn" : "Web Turn";
    }

    public boolean isOurTurn() {
        if (Gdx.app.getType() == Desktop && player1Turn) return true;
        return Gdx.app.getType() == WebGL && !player1Turn;
    }
}