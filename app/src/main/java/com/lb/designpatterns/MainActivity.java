package com.lb.designpatterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lb.designpatterns.builder.BuilderActivity;
import com.lb.designpatterns.factory.FactoryActivity;
import com.lb.designpatterns.singleton.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 参照https://refactoringguru.cn/design-patterns
 * 学习理解设计模式
 * */
public class MainActivity extends AppCompatActivity 
        implements View.OnClickListener {
    private String TAG = "design";

    List<Integer> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StaticFun.buttonRegister(R.id.factory,this, this);
//        StaticFun.buttonRegister(R.id.builder,this, this);
//        StaticFun.buttonRegister(R.id.singleton,this,this);
        buttons.add(R.id.factory);
        buttons.add(R.id.builder);
        buttons.add(R.id.singleton);
        StaticFun.buttonRegister(buttons, this, this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.factory:
                intent = new Intent(this, FactoryActivity.class);
                break;
            case R.id.builder:
                intent = new Intent(this, BuilderActivity.class);
                break;
            case R.id.singleton:
//                TestThreadSafeSingletonPlus();
                Singleton.getIntence().print();
                break;
            default:
                Log.i(TAG,"Mainativity button error");
        }
        if(intent != null){
            startActivity(intent);
        }
    }

//    /**
//     * 测试这种方式是否线程安全
//     * */
//    private void TestThreadSafeSingletonPlus() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                ThreadSafeSingletonPlus t = ThreadSafeSingletonPlus.getInstanceUsingDoubleLocking("first");
//                Log.i(StaticFun.TAG, t.value);
//            }
//        };
//        Thread thread = new Thread(runnable);
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                ThreadSafeSingletonPlus t = ThreadSafeSingletonPlus.getInstanceUsingDoubleLocking("second");
//                Log.i(StaticFun.TAG, t.value);
//            }
//        };
//        Thread thread1 = new Thread(runnable1);
//        thread.start();
//        thread1.start();
//    }
}