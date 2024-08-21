package com.epicness.gamejoltapitest;

import static com.epicness.gamejoltapitest.SecretInfo.GAME_ID;
import static com.epicness.gamejoltapitest.SecretInfo.GRID_KEY;
import static com.epicness.gamejoltapitest.SecretInfo.PRIVATE_KEY;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.epicness.gamejoltapitest.logic.Logic;
import com.epicness.gamejoltapitest.stuff.Stuff;
import com.github.raeleus.gamejoltapi.GameJoltApi;
import com.github.raeleus.gamejoltapi.GameJoltDataStore;

public class GameJoltAPITest extends Game {

    private Renderer renderer;
    private Logic logic;

    @Override
    public void create() {
        GameJoltApi api = new GameJoltApi();
        Stuff stuff = new Stuff();
        renderer = new Renderer(stuff);
        logic = new Logic(api, stuff);
        logic.init();
    }

    @Override
    public void render() {
        if (Gdx.graphics.getDeltaTime() < 0.1f) {
            logic.update(Gdx.graphics.getDeltaTime());
            renderer.render();
        }
    }

    private void initGrid(GameJoltApi api) {
        GameJoltDataStore.DataStoreSetRequest request = GameJoltDataStore.DataStoreSetRequest.builder()
            .gameID(GAME_ID)
            .key(GRID_KEY)
            .data("AAAAAAAAA")
            .build();
        api.sendRequest(request, PRIVATE_KEY, new GameJoltDataStore.DataStoreSetListener() {
            @Override
            public void dataStoreSet(GameJoltDataStore.DataStoreSetValue value) {
                System.out.println("Init grid: " + value.success);
            }
        });
    }
}