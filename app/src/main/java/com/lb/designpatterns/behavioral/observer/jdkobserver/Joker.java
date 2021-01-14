package com.lb.designpatterns.behavioral.observer.jdkobserver;

import java.util.Observable;

public class Joker extends Observable {
    public void postNewVersion(String version) {
        setChanged(); // 调用该方法会通知观察者更新
        notifyObservers(version);// 通知所有观察者
    }
}
