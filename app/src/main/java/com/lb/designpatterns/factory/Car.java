package com.lb.designpatterns.factory;

import android.util.Log;

import com.lb.designpatterns.StaticFun;

/**
 * 具体产品 car
 * */
public class Car implements Production {
    private String TAG = StaticFun.TAG;

    public Car(){
        this.Function();
        this.Auth();
        this.Name();
    }

    @Override
    public void Function() {
        Log.i(TAG,"drive");
    }

    @Override
    public void Name() {
        Log.i(TAG,"Car");
    }

    @Override
    public void Auth() {
        Log.i(TAG,"福特");
    }
}
