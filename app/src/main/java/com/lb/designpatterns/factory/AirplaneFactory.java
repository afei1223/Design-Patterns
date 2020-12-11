package com.lb.designpatterns.factory;

import android.view.LayoutInflater;

/**
 * 飞机创建工厂
 * */
public class AirplaneFactory implements FactoryMethod {

    @Override
    public Production MakePro() {
        return new Airplane();
    }
}
