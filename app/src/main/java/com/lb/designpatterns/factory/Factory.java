package com.lb.designpatterns.factory;

/**
 * 工厂，功能是创造
 * */
public class Factory {
//    public abstract Production createProduction();
//    public Production Function(){
//        Production p = createProduction();
//        p.Auth();
//        p.Function();
//        p.Name();
//        return p;
//    }
    public Production MakePro(String pro){
        switch (pro){
            case "car":
                return new Car();
            case "airplane":
                return new Airplane();
            default:
                return null;
        }
    }
}
