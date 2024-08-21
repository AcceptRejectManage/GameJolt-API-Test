package com.epicness.gamejoltapitest.logic;

import com.epicness.gamejoltapitest.DataListener;
import com.epicness.gamejoltapitest.Utils;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Text;

public class StateHandler {

    private final Logic logic;
    private final Grid grid;
    private final Text message;

    public StateHandler(Logic logic, Grid grid, Text message) {
        this.logic = logic;
        this.grid = grid;
        this.message = message;
    }

    public void loadGridState() {
        logic.getAPIWrapper().fetchGrid(new DataListener<>() {
            @Override
            public void onSuccess(String gridData) {
                Utils.loadGridData(grid, gridData);
                logic.getTurnHandler().updateTurn();
                logic.getInputHandler().enabled = true;
            }

            @Override
            public void onFail() {
                message.text = "Error loading grid state";
            }
        });
    }
}