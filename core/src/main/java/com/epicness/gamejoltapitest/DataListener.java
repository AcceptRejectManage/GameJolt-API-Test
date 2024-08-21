package com.epicness.gamejoltapitest;

public interface DataListener<T> {

    void onSuccess(T t);

    void onFail();
}