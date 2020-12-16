package com.lb.designpatterns;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class StaticFun {
    public static final String TAG = "design patterns";

    public static Button buttonRegister(int i, View.OnClickListener onClickListener, Activity activity){
        Button button = activity.findViewById(i);
        button.setOnClickListener(onClickListener);
        return button;
    }
    public static void buttonRegister(int i, View.OnClickListener onClickListener, Dialog dialog){
        Button button = dialog.findViewById(i);
        button.setOnClickListener(onClickListener);
    }
    public static TextView textviewRegister(int i, Activity activity){
        TextView textView = activity.findViewById(i);
        return textView;
    }

    public static void buttonRegister(List<Integer> buttons, View.OnClickListener onClickListener, Activity activity) {
        for(int i : buttons){
            Button button = activity.findViewById(i);
            button.setOnClickListener(onClickListener);
        }
    }
}