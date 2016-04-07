package com.example.anyang.robolectricdemotest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 通过Robolectric+Junit实现Android单元测试
 * 案例：该项目界面显示了一个textview和一个button，点击button可以改变textview所显示的文字
 */
public class MainActivity extends Activity {


    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.textview);

    }

    public void btnChangeText(View view){ textview.setText("Hello, An Yang!"); }
}
