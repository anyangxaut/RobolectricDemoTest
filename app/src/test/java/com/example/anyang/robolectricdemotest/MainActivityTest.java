package com.example.anyang.robolectricdemotest;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by anyang on 2016/4/6.
 * 删除项目创建时系统自动生成的测试文件，选择要进行测试的文件进行新测试文件的创建（注意选择Junit4），例如：MainActivity
 * 打开Build Variants视图界面，将Test Artifact选择为Unit Tests
 * 打开gradle面板，执行app--tasks--verification--testDebugUnitTest，或者点击test文件右键运行测试，
 * 测试结果可在projectname\app\build\reports\tests\debug\index.html文件中通过网页查看
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    // 引用待测Activity
    private MainActivity mActivity;

    // 引用待测Activity中的TextView和Button
    private TextView textView;
    private Button button;

    @Before
    public void setUp() throws Exception {
        // 获取待测Activity
        mActivity = Robolectric.setupActivity(MainActivity.class);

        // 初始化textView和button
        textView = (TextView) mActivity.findViewById(R.id.textview);
        button = (Button) mActivity.findViewById(R.id.button);
    }

    // 测试界面初始化结果
    @Test
    public void testInit() throws Exception {
        assertNotNull(mActivity);
        assertNotNull(textView);
        assertNotNull(button);

        // 判断包名
        assertEquals("com.example.anyang.robolectricdemotest", mActivity.getPackageName());

        // 判断textView默认显示的内容
        assertEquals("Hello World!", textView.getText().toString());
    }

    // 测试点击button，textView显示的内容
    @Test
    public void testButton() throws Exception {
        // 点击button
        button.performClick();

        // 判断点击后textView的内容
        assertEquals("Hello, An Yang!", textView.getText().toString());
    }

    // 一个失败的用例
    @Test
    public void testFail() throws Exception {
        fail("This case failed!");
    }
}