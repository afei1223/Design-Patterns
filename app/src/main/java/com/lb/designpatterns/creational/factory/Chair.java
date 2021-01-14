package com.lb.designpatterns.creational.factory;

import android.util.Log;

import com.lb.designpatterns.StaticFun;


/**
 * 具体产品 chair
 * */
public class Chair implements ChairProduction {
    private String TAG = StaticFun.TAG;

    public Chair(){
        this.Function();
        this.Auth();
        this.Name();
        this.Special();
    }

    @Override
    public void Function() {
        Log.i(TAG,"sit");
    }

    @Override
    public void Name() {
        Log.i(TAG,"Chair");
    }

    @Override
    public void Auth() {
        Log.i(TAG,"鲁班");
    }

    @Override
    public void Special() {
        Log.i(TAG,"特殊产品");
    }
}
