package com.lb.designpatterns.creational.factory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lb.designpatterns.R;
import com.lb.designpatterns.StaticFun;
/**
 * ----工厂模式----
 *
 * 普通工厂
 * 优点
 *  你可以避免创建者和具体产品之间的紧密耦合。
 *  单一职责原则。 你可以将产品创建代码放在程序的单一位置， 从而使得代码更容易维护。
 *  开闭原则。 无需更改现有客户端代码， 你就可以在程序中引入新的产品类型。
 * 缺点
 *  应用工厂方法模式需要引入许多新的子类， 代码可能会因此变得更复杂。 最好的情况是将该模式引入创建者类的现有层次结构中。
 *
 * 抽象工厂
 * 优点
 *  你可以确保同一工厂生成的产品相互匹配。
 *  你可以避免客户端和具体产品代码的耦合。
 *  单一职责原则。 你可以将产品生成代码抽取到同一位置， 使得代码易于维护。
 *  开闭原则。 向应用程序中引入新产品变体时， 你无需修改客户端代码。
 * 缺点
 *  由于采用该模式需要向应用中引入众多接口和类， 代码可能会比之前更加复杂。
 *
 * 以上均来自refactoringguru.cn
 *
 * 项目介绍
 *  这个项目里混用了三种工厂模式，car和airplane用的都是同一种production
 *  chair是为了验证抽象工厂，所以和car，airplane不同。
 *  普通工厂和工厂方法都只是生产产品，他们只能生成一种类型的产品，比如car和airplane，虽然内容不一样，但是都是继承于production
 *  如果想要创建别的产品，比如chair，就需要用到抽象工厂方法。详见抽象工厂方法的代码。
 *
 *  每按依次button都会从工厂产生一个对象，使用了三种方法来生产不同的产品
 *
 * 个人理解
 *  工厂模式和工厂方法模式两种类似，都是为了生成对象。一个是根据传入参数来生产，一个是创建对应工厂类生产。
 *  我觉得从代码的整洁来看，工厂方法更好一些，需要一些改动时去直接去对应工厂类中改代码即可。
 *  抽象工厂方法从代码上来看和工厂方法类似，但是他可以返回不同类型的对象。
 *  不过和直接创建对象来说，他创建了很多子类，结构上看更为复杂。
 * */
public class FactoryActivity extends Activity
        implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private int flag;

    private Production production;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        textView = StaticFun.textviewRegister(R.id.demo_textview,this);
        button = StaticFun.buttonRegister(R.id.demo_button, this, this);
        flag = 0;

        button.setText("工厂模式");
        textView.setText("多次点击按钮生成不同的产品");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.demo_button){
            switch (flag%3){
                case 0:
                    production = new Factory().MakePro("airplane");
                    break;
                case 1:
                    production = new CarFactory().MakePro();
                    break;
                case 2:
                    new MixAbstractFactory().CreateChair();
                    break;
                default:
                    Log.i(StaticFun.TAG,"button error");
                    break;
            }
        }
        flag++;
    }
}
