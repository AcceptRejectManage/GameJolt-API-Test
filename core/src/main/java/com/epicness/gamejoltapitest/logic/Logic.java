package com.epicness.gamejoltapitest.logic;

import com.epicness.gamejoltapitest.stuff.Stuff;
import com.github.raeleus.gamejoltapi.GameJoltApi;

public class Logic {

    private final EndChecker endChecker;
    private final InputHandler inputHandler;
    private final MoveHandler moveHandler;

    public Logic(GameJoltApi api, Stuff stuff) {
        endChecker = new EndChecker();
        inputHandler = new InputHandler(this);
        moveHandler = new MoveHandler(api, stuff.getText(), stuff.getGrid());
    }

    public void update(float delta) {

    }

    public MoveHandler getMoveHandler() {
        return moveHandler;
    }
}