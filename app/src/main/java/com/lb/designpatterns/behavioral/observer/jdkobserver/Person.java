package com.lb.designpatterns.behavioral.observer.jdkobserver;

import android.util.Log;

import com.lb.designpatterns.StaticFun;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {
    private String name;
    @Override
    public void update(Observable o, Object arg) {
        Log.i(StaticFun.TAG,name+":"+arg);
    }

    public Person(String n) {
        this.name = n;
    }

}
