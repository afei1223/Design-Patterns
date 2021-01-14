package com.lb.designpatterns.behavioral.observer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lb.designpatterns.R;
import com.lb.designpatterns.StaticFun;
import com.lb.designpatterns.behavioral.observer.jdkobserver.Joker;
import com.lb.designpatterns.behavioral.observer.jdkobserver.Person;

/**
 * ----观察者模式----
 *
 * 不知道该怎么总结观察者模式的优缺点，在我看来这就是一堆接口回调。
 * 所以感觉和接口回调的优缺点相同。
 *
 * 相比于接口回调是一对一的方式，但是观察者模式是保存了对应的接口，当发生某一特定事件时，通知所有订阅了这个事件的接口。
 *
 *
 * 下文的场景是，有三个人分别是firstMan，secondMan，thirdMan。
 * 他们分别都订阅了报纸
 *
 * firstMan订阅了sport板块，当板块更新时，他会收到更新了的消息。
 *
 * secondMan订阅了所有板块，但是他看了农业新闻这个板块，觉得很枯燥，就取消了订阅。
 *
 * thirdMan订阅了anothernews和international板块，但是报纸上没有anothernews板块，所以他收不到这个板块更新
 * 但是international板块更新他可以收到消息。
 *
 * 按下按钮，模拟报纸发布，可以在日志中观察这三个人收到的新闻更新消息。
 *
 *
 * 该场景是为了更好的理解观察者模式，如果没有观察者模式的话，这三个人要不断的去查询自己想看的板块是否更新，
 * 引入观察者模式后，他们可以去做他们自己的事，不必一直去查询。
 * */

/**
 * jdk实现了观察者模式的接口，具体使用可以看jdkobserver中的代码
 * ps（observer拼写的时候漏了个s，懒得改了，能看明白就好了）
 *
 * */
public class OberverActivity extends Activity implements View.OnClickListener {
    private Newspaper newspaper;
    private Subscriber subscriber;

    private Joker joker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        StaticFun.buttonRegister(R.id.demo_button,this,this);
        TextView textView = StaticFun.textviewRegister(R.id.demo_textview,this);
        textView.setText("点击按钮发布报纸");
        String [] events = {"sport","financial","international","agricultural"};
        newspaper = new Newspaper(events);

        firstMan();
        secondMan();
        thirdMan();

        Person xiaochou1 = new Person("first");
        Person xiaochou2 = new Person("second");
        Person xiaochou3 = new Person("third");
        joker = new Joker();
        joker.addObserver(xiaochou1);
        joker.addObserver(xiaochou2);
        joker.addObserver(xiaochou3);
    }

    private void thirdMan() {
        //一个从未订阅过的板块
        newspaper.subscribe("anothernews", new Subscriber() {
            @Override
            public void update(String event) {
                Log.i(StaticFun.TAG,"thirddMan has received the "+event+"update");
            }
        });
        newspaper.subscribe("international ", new Subscriber() {
            @Override
            public void update(String event) {
                Log.i(StaticFun.TAG,"thirddMan has received the "+event+"update");
            }
        });
    }

    private void secondMan() {
        subscriber = new Subscriber() {
            @Override
            public void update(String event) {
                Log.i(StaticFun.TAG,"secondMan has received the "+event+"update");
            }
        };
        newspaper.subscribe("international", subscriber);
        newspaper.subscribe("agricultural", subscriber);
        newspaper.subscribe("financial", subscriber);
        newspaper.subscribe("sports",subscriber);
    }

    private void firstMan() {
        //第一个订报纸的人
        newspaper.subscribe("sport", new Subscriber() {
            @Override
            public void update(String event) {
                Log.i(StaticFun.TAG,"firstMan has received the "+event+"update");
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.demo_button){
            newspaper.updateNewspaper();
            //secondMan看了农业新闻后感觉不感兴趣，于是马上取消了农业新闻的订阅
            newspaper.unSubscribe("agricultural",subscriber);

            joker.postNewVersion("小丑是谁");
            joker.postNewVersion("小丑竟是我自己");
        }
    }
}
