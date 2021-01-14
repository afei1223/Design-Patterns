package com.lb.designpatterns.creational.factory;

import android.util.Log;

import com.lb.designpatterns.StaticFun;

/**
 * 具体产品 airplane
 * */
public class Airplane implements Production {
    private String TAG = StaticFun.TAG;

    public Airplane() {
        this.Function();
        this.Auth();
        this.Name();
    }

    @Override
    public void Function() {
        Log.i(TAG,"fly");
    }

    @Override
    public void Name() {
        Log.i(TAG,"airplane");
    }

    @Override
    public void Auth() {
        Log.i(TAG,"莱特兄弟");
    }
}
