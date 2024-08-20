package com.epicness.gamejoltapitest;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameJoltAPITest extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}