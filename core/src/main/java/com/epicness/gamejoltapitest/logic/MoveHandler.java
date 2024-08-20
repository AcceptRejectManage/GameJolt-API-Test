package com.epicness.gamejoltapitest.logic;

import com.github.raeleus.gamejoltapi.GameJoltApi;

public class MoveHandler {

    private final GameJoltApi api;
    private boolean player1Turn;

    public MoveHandler(GameJoltApi api) {
        this.api = api;
    }

    public void attemptMove(float x, float y) {
        System.out.println("ASD");
    }


}