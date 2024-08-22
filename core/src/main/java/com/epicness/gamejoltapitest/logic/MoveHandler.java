package com.epicness.gamejoltapitest.logic;

import static com.badlogic.gdx.Application.ApplicationType.Desktop;
import static com.epicness.gamejoltapitest.Constants.CIRCLE_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CIRCLE_RADIUS;
import static com.epicness.gamejoltapitest.Constants.CROSS_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CROSS_SIZE;
import static com.epicness.gamejoltapitest.Constants.GRID_ROWS;

import com.badlogic.gdx.Gdx;
import com.epicness.gamejoltapitest.Listener;
import com.epicness.gamejoltapitest.stuff.Cell;
import com.epicness.gamejoltapitest.stuff.Circle;
import com.epicness.gamejoltapitest.stuff.Cross;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Shape;
import com.epicness.gamejoltapitest.stuff.Text;

public class MoveHandler {

    private final Logic logic;
    private final Text message;
    private final Grid grid;

    public MoveHandler(Logic logic, Text message, Grid grid) {
        this.logic = logic;
        this.message = message;
        this.grid = grid;
    }

    public void attemptMove(float x, float y) {
        if (!logic.getTurnHandler().isOurTurn()) return;
        if (grid.isFull()) return;

        Cell cell = grid.getCellAtPosition(x, y);

        if (validateCell(cell)) {
            makeMove(cell);
        }
    }

    private boolean validateCell(Cell cell) {
        if (cell == null) return false;
        return cell.shape == null;
    }

    private void makeMove(Cell cell) {
        message.text = "Attempting to make move";
        logic.getAPIWrapper().updateGrid(makePotentialGrid(cell), new Listener() {
            @Override
            public void onSuccess() {
                cell.shape = makePlayerShape(cell);
                logic.getTurnHandler().updateTurn();
                logic.getEndChecker().check();
            }

            @Override
            public void onFail() {
                message.text = "Failed to make move";
            }
        });
    }

    private String makePotentialGrid(Cell cell) {
        int charIndex = cell.col * GRID_ROWS + cell.row;
        char playerChar = Gdx.app.getType() == Desktop ? 'O' : 'X';

        StringBuilder stringBuilder = new StringBuilder(grid.toData());
        stringBuilder.setCharAt(charIndex, playerChar);
        return stringBuilder.toString();
    }

    private Shape makePlayerShape(Cell cell) {
        Shape shape;
        float x = cell.x, y = cell.y;
        if (Gdx.app.getType() == Desktop) {
            shape = new Circle(x + CIRCLE_OFFSET, y + CIRCLE_OFFSET, CIRCLE_RADIUS);
        } else {
            shape = new Cross(x + CROSS_OFFSET, y + CROSS_OFFSET, CROSS_SIZE);
        }
        return shape;
    }
}