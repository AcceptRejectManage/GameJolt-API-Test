package com.epicness.gamejoltapitest.logic;

import static com.badlogic.gdx.Application.ApplicationType.Desktop;
import static com.badlogic.gdx.Application.ApplicationType.WebGL;
import static com.epicness.gamejoltapitest.Constants.CIRCLE_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CIRCLE_RADIUS;
import static com.epicness.gamejoltapitest.Constants.CROSS_OFFSET;
import static com.epicness.gamejoltapitest.Constants.CROSS_SIZE;
import static com.epicness.gamejoltapitest.SecretInfo.GAME_ID;
import static com.epicness.gamejoltapitest.SecretInfo.PRIVATE_KEY;

import com.badlogic.gdx.Gdx;
import com.epicness.gamejoltapitest.stuff.Cell;
import com.epicness.gamejoltapitest.stuff.Circle;
import com.epicness.gamejoltapitest.stuff.Cross;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Shape;
import com.epicness.gamejoltapitest.stuff.Text;
import com.github.raeleus.gamejoltapi.GameJoltApi;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetListener;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetRequest;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetValue;

public class MoveHandler {

    private final GameJoltApi api;
    private final Text text;
    private final Grid grid;
    private boolean player1Turn;

    public MoveHandler(GameJoltApi api, Text text, Grid grid) {
        this.api = api;
        this.text = text;
        this.grid = grid;
        player1Turn = true;
    }

    public void attemptMove(float x, float y) {
        if (Gdx.app.getType() == Desktop && !player1Turn) return;
        if (Gdx.app.getType() == WebGL && player1Turn) return;

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
        DataStoreSetRequest request = DataStoreSetRequest.builder()
            .gameID(GAME_ID)
            .key("Test Key")
            .data("Test Data")
            .build();

        api.sendRequest(request, PRIVATE_KEY, new DataStoreSetListener() {
            @Override
            public void dataStoreSet(DataStoreSetValue value) {
                if (value.success) {
                    cell.shape = makePlayerShape(cell);
                    player1Turn = !player1Turn;
                    text.text = "SUCCESS";
                } else {
                    System.out.println("FAIL");
                }
            }
        });
    }

    private Shape makePlayerShape(Cell cell) {
        Shape shape;
        float x = cell.x, y = cell.y;
        if (player1Turn) {
            shape = new Circle(x + CIRCLE_OFFSET, y + CIRCLE_OFFSET, CIRCLE_RADIUS);
        } else {
            shape = new Cross(x + CROSS_OFFSET, y + CROSS_OFFSET, CROSS_SIZE);
        }
        return shape;
    }
}