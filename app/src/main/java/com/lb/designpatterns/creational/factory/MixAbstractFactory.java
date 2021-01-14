package com.lb.designpatterns.creational.factory;

/**
 * 抽象工厂的实现，根据接口返回不一样的对象。
 * */
public class MixAbstractFactory implements AbstractFactory {
    @Override
    public Production CreatePro() {
        //也可以用这种方式
//        return new AirplaneFactory().MakePro();
        return new Airplane();
    }

    @Override
    public ChairProduction CreateChair() {
        return new Chair();
    }
}
