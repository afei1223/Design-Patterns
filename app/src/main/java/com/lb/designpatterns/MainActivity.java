package com.lb.designpatterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lb.designpatterns.factory.FactoryActivity;

/**
 * 参照https://refactoringguru.cn/design-patterns
 * 学习理解设计模式
 * */
public class MainActivity extends AppCompatActivity 
        implements View.OnClickListener {
    private String TAG = "design";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaticFun.buttonRegister(R.id.factory,this, this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.factory:
                intent = new Intent(this, FactoryActivity.class);
                break;
            default:
                Log.i(TAG,"Mainativity button error");
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}