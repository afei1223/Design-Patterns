package com.lb.designpatterns.creational.factory;

/**
 * 通用产品接口
 * 定义一个产品，这个产品拥有功能，名称，作者这三个参数
 * */
public interface Production {
    void Function();
    void Name();
    void Auth();
}
