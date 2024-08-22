package com.epicness.gamejoltapitest.logic;

import com.epicness.gamejoltapitest.stuff.Cell;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Text;

public class EndChecker {

    private final Logic logic;
    private final Grid grid;
    private final Text message;

    public EndChecker(Logic logic, Grid grid, Text message) {
        this.logic = logic;
        this.grid = grid;
        this.message = message;
    }

    public void check() {
        if (check('X')) {
            message.text = "Web player wins!";
        } else if (check('O')) {
            message.text = "Desktop player wins!";
        } else if (grid.isFull()) {
            message.text = "Tie!";
            logic.getPoller().stop();
            logic.getRestartHandler().showRestart();
            logic.getInputHandler().enabled = true;
        }
    }

    private boolean check(char player) {
        Cell[][] cells = grid.cells;
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (cells[col][0].getShapeRepresentation() == player &&
                cells[col][1].getShapeRepresentation() == player &&
                cells[col][2].getShapeRepresentation() == player) {
                return true;
            }
        }

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (cells[0][row].getShapeRepresentation() == player &&
                cells[1][row].getShapeRepresentation() == player &&
                cells[2][row].getShapeRepresentation() == player) {
                return true;
            }
        }

        // Check diagonals
        if (cells[0][0].getShapeRepresentation() == player &&
            cells[1][1].getShapeRepresentation() == player &&
            cells[2][2].getShapeRepresentation() == player) {
            return true;
        }

        return cells[0][2].getShapeRepresentation() == player &&
            cells[1][1].getShapeRepresentation() == player &&
            cells[2][0].getShapeRepresentation() == player;
    }
}