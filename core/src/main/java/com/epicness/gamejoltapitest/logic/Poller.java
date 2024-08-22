package com.epicness.gamejoltapitest.logic;

import static com.epicness.gamejoltapitest.Constants.POLL_INTERVAL;

import com.epicness.gamejoltapitest.DataListener;
import com.epicness.gamejoltapitest.Utils;
import com.epicness.gamejoltapitest.stuff.Grid;
import com.epicness.gamejoltapitest.stuff.Text;

public class Poller {

    private final Logic logic;
    private final Text timerText, message;
    private final Grid grid;
    private float timer;
    private boolean enabled;

    public Poller(Logic logic, Text timerText, Text message, Grid grid) {
        this.logic = logic;
        this.timerText = timerText;
        this.message = message;
        this.grid = grid;
    }

    public void begin() {
        timer = 0f;
        enabled = true;
        timerText.text = String.valueOf(Math.floor(timer));
    }

    public void update(float delta) {
        if (!enabled) return;

        timer += delta;
        timerText.text = String.valueOf(Math.floor(timer));
        if (timer >= POLL_INTERVAL) {
            poll();
            timer = Math.min(timer - POLL_INTERVAL, 0f);
        }
    }

    public void poll() {
        timerText.text = "Timer Stopped";
        message.text = "Loading game state";
        logic.getAPIWrapper().fetchGrid(new DataListener<>() {
            @Override
            public void onSuccess(String gridData) {
                Utils.loadGridData(grid, gridData);
                logic.getTurnHandler().updateTurn();
                logic.getEndChecker().check();
            }

            @Override
            public void onFail() {
                message.text = "Error polling grid state";
            }
        });
    }

    public void stop() {
        enabled = false;
        timerText.text = "Timer Stopped";
    }
}