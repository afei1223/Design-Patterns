package com.lb.designpatterns.creational.builder;

/**
 * 主管类
 * 这里让主管去监督生成三种汽车。
 * 当然也可以创造其他的别的东西。
 * 主管只负责创建，不用去管其他东西
 * */
public class Director {
    public void CreateCar(Builder builder){
        builder.setCarType("小轿车");
        builder.setLength(5);
        builder.setSets(4);
    }

    public void CreateBus(Builder builder){
        builder.setCarType("公交");
        builder.setSets(50);
        builder.setLength(15);
    }

    public void CreateTruck(Builder builder){
        builder.setCarType("卡车");
        builder.setLength(15);
        builder.setSets(3);
    }
}
