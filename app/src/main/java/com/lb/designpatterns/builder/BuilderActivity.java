package com.lb.designpatterns.builder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lb.designpatterns.R;
import com.lb.designpatterns.StaticFun;
import com.lb.designpatterns.factory.CarFactory;
import com.lb.designpatterns.factory.Factory;
import com.lb.designpatterns.factory.MixAbstractFactory;

/**
 * ----生成器模式----
 *
 * 优点
 *  你可以分步创建对象， 暂缓创建步骤或递归运行创建步骤。
 *  生成不同形式的产品时， 你可以复用相同的制造代码。
 *  单一职责原则。 你可以将复杂构造代码从产品的业务逻辑中分离出来。
 *
 * 缺点
 *  由于该模式需要新增多个类， 因此代码整体复杂程度会有所增加。
 *
 * 个人理解
 *  生成器模式是为了防止创建类的时候参数过多，而构造时有些参数又不必用到。导致代码看起来很复杂。
 *  不过java中有重载，私以为重载比这种方式好一些。不过在类的代码中看起来也很难麻烦。
 *  这里代码是为了熟悉生成器模式，所以看起来这个模式好像没有什么用。
 *  但如果car类中有很多很多参数的情况下，这种模式，可以使最后生成的时候看起来代码很少。
 *  而且主管可以也可以生成别的类，比如这里再创建一个飞机类，加一个airplaneBuilder。
 *  只要再主管类中加一个方法，设置传入的builder参数即可。
 * */
public class BuilderActivity extends Activity
        implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        textView = StaticFun.textviewRegister(R.id.demo_textview,this);
        button = StaticFun.buttonRegister(R.id.demo_button, this, this);
        flag = 0;

        button.setText("创造者模式");
        textView.setText("多次点击按钮生成不同的产品");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.demo_button){
            CarBuilder carBuilder = new CarBuilder();
            Director director = new Director();
            switch (flag%3){
                case 0:
                    director.CreateCar(carBuilder);
                    break;
                case 1:director.CreateBus(carBuilder);
                    break;
                case 2:
                    director.CreateTruck(carBuilder);
                    break;
                default:
                    Log.i(StaticFun.TAG,"button error");
                    break;
            }
            Car car = carBuilder.getResult();
            car.Print();
        }
        flag++;
    }
}
