package com.lb.designpatterns.creational.builder;

/**
 * car生成器
 * 同样的参数很少，假设这里很多参数。
 * */
public class CarBuilder implements Builder {

    private String type;
    private int sets;
    private int length;

    @Override
    public void setCarType(String t) {
        this.type = t;
    }

    @Override
    public void setSets(int s) {
        this.sets = s;
    }

    @Override
    public void setLength(int l) {
        this.length = l;
    }

    public Car getResult(){
        return new Car(type,sets,length);
    }
}
