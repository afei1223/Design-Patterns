package com.lb.designpatterns.factory;

/**
 * 特殊产品接口
 * 定义一个产品，这个产品拥有功能，名称，作者这三个参数
 * 多加一个spcial表示他和普通产品的不同，用于抽象工厂模式
 * */
public interface ChairProduction {
    void Function();
    void Name();
    void Auth();
    void Special();
}
