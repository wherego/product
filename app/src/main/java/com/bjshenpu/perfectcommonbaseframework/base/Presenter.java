package com.bjshenpu.perfectcommonbaseframework.base;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
