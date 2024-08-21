package com.epicness.gamejoltapitest.logic;

import static com.epicness.gamejoltapitest.SecretInfo.GAME_ID;
import static com.epicness.gamejoltapitest.SecretInfo.GRID_KEY;
import static com.epicness.gamejoltapitest.SecretInfo.PRIVATE_KEY;

import com.epicness.gamejoltapitest.DataListener;
import com.epicness.gamejoltapitest.Listener;
import com.github.raeleus.gamejoltapi.GameJoltApi;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreFetchListener;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreFetchRequest;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreFetchValue;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetListener;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetRequest;
import com.github.raeleus.gamejoltapi.GameJoltDataStore.DataStoreSetValue;

public class APIWrapper {

    private final GameJoltApi api;

    public APIWrapper(GameJoltApi api) {
        this.api = api;
    }

    public void fetchGrid(DataListener<String> listener) {
        DataStoreFetchRequest request = DataStoreFetchRequest.builder()
            .gameID(GAME_ID)
            .key(GRID_KEY)
            .build();

        api.sendRequest(request, PRIVATE_KEY, new DataStoreFetchListener() {
            @Override
            public void dataStoreFetch(DataStoreFetchValue value) {
                if (value.success) {
                    listener.onSuccess(value.data);
                } else {
                    listener.onFail();
                }
            }
        });
    }

    public void updateGrid(String gridData, Listener listener) {
        DataStoreSetRequest request = DataStoreSetRequest.builder()
            .gameID(GAME_ID)
            .key(GRID_KEY)
            .data(gridData)
            .build();

        api.sendRequest(request, PRIVATE_KEY, new DataStoreSetListener() {
            @Override
            public void dataStoreSet(DataStoreSetValue value) {
                if (value.success) {
                    listener.onSuccess();
                } else {
                    listener.onFail();
                }
            }
        });
    }
}