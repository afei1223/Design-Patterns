package com.lb.designpatterns.builder;

import android.util.Log;
import android.widget.ScrollView;

import com.lb.designpatterns.StaticFun;

/**
 * car的类
 * 加了一个print方法，用来打印他的参数
 * */
public class Car {
    private String type;
    private int sets;
    private int length;

    public Car(String type, int sets, int length) {
        this.type = type;
        this.sets = sets;
        this.length = length;
    }

    public void Print(){
        Log.i(StaticFun.TAG,"车子类型：" + type);
        Log.i(StaticFun.TAG,"车子座位数量" + sets);
        Log.i(StaticFun.TAG,"车子长度" + length);
    }
}
