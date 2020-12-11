package com.lb.designpatterns.factory;

/**
 * 汽车创建工厂
 * */
public class CarFactory  implements FactoryMethod {

    @Override
    public Production MakePro() {
        return new Car();
    }
}
