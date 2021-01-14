package com.lb.designpatterns.creational.builder;

/**
 * 创建构造器，这里参数有点少，只是举做例子。
 * 假设这里有很多参数
 * */
public interface Builder {
    void setCarType(String type);
    void setSets(int sets);
    void setLength(int length);

}
