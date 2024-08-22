package com.epicness.gamejoltapitest.logic;

import com.epicness.gamejoltapitest.stuff.Stuff;
import com.github.raeleus.gamejoltapi.GameJoltApi;

public class Logic {

    private final EndChecker endChecker;
    private final InputHandler inputHandler;
    private final MoveHandler moveHandler;
    private final APIWrapper APIWrapper;
    private final StateHandler stateHandler;
    private final TurnHandler turnHandler;
    private final Poller poller;

    public Logic(GameJoltApi api, Stuff stuff) {
        endChecker = new EndChecker();
        inputHandler = new InputHandler(this);
        moveHandler = new MoveHandler(this, stuff.getMessage(), stuff.getGrid());
        APIWrapper = new APIWrapper(api);
        stateHandler = new StateHandler(this, stuff.getGrid(), stuff.getMessage());
        turnHandler = new TurnHandler(this, stuff.getGrid(), stuff.getMessage());
        poller = new Poller(this, stuff.getTimerText(), stuff.getMessage(), stuff.getGrid());
    }

    public void init() {
        stateHandler.loadGridState();
    }

    public void update(float delta) {
        poller.update(delta);
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public com.epicness.gamejoltapitest.logic.APIWrapper getAPIWrapper() {
        return APIWrapper;
    }

    public MoveHandler getMoveHandler() {
        return moveHandler;
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }

    public Poller getPoller() {
        return poller;
    }
}