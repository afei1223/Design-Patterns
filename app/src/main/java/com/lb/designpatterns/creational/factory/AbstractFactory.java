package com.lb.designpatterns.creational.factory;

/**
 * 抽象工厂方法
 * 可以创造不同的产品
 * */
public interface AbstractFactory {
    Production CreatePro();
    ChairProduction CreateChair();
}
