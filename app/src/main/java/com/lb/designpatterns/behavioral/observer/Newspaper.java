package com.lb.designpatterns.behavioral.observer;

import android.util.Log;

import com.lb.designpatterns.StaticFun;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报纸类，有三个功能
 *
 * 1。添加板块订阅
 *   订阅后，相应板块更新会收到消息。
 * 2。取消订阅
 *   订阅后，觉得该板块不感兴趣可以取消该板块的订阅
 * 3。报纸发布
 *   即板块更新，调用后所有板块更新，并通知订阅者更新了。
 * */
public class Newspaper {
    Map<String ,List<Subscriber>> eventsMap = new HashMap<>();
    String [] events;

    public void subscribe(String events, Subscriber subscriber){
        //添加订阅者
        if( eventsMap.containsKey(events) ){
            //如果存在这个板块
            List<Subscriber> subscribers = eventsMap.get(events);
            subscribers.add(subscriber);
            eventsMap.put(events,subscribers);
        }else{
            //如果没有这个板块，不做处理
                //以下是添加这个板块
//            List<Subscriber> subscribers = new ArrayList<>();
//            subscribers.add(subscriber);
//            eventsMap.put(events,subscribers);
        }
    }

    //取消订阅
    public void unSubscribe(String events, Subscriber subscriber){
        //如果存在这个板块
        if( eventsMap.containsKey(events) ){
            List<Subscriber> subscribers = eventsMap.get(events);
            subscribers.remove(subscriber);
            eventsMap.put(events,subscribers);
        }
        //如果没有这个板块不做处理
    }

    //构造器创建新闻板块
    public Newspaper(String... events) {
        this.events = events;
        for(String event : events){
            eventsMap.put(event,new ArrayList<Subscriber>());
        }
    }

    //发布新闻
    public void updateNewspaper(){
        for(String event : events){
            Log.i(StaticFun.TAG,event+" news has updated");
            List<Subscriber> subscribers = eventsMap.get(event);
            for(Subscriber subscriber : subscribers){
                subscriber.update(event);
            }
        }
    }
}
