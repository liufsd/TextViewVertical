package com.sk.view.demo;

import com.sk.view.TextViewVertical;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.HorizontalScrollView;

public class MainActivity extends Activity {
    private HorizontalScrollView sv;
    private TextViewVertical tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextViewVertical) findViewById(R.id.tv);
        sv = (HorizontalScrollView) findViewById(R.id.sv);

        //设置接口事件接收
        Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case TextViewVertical.LAYOUT_CHANGED:
                        sv.scrollBy(tv.getTextWidth(), 0);//滚动到最右边
                        break;
                }
            }
        };
        tv.setHandler(handler);//将Handler绑定到TextViewVertical

        //创建并设置字体（这里只是为了效果好看一些，但为了让网友们更容易下载，字体库并没有一同打包
        //如果需要体验下效果的朋友可以自行在网络上搜索stxingkai.ttf并放入assets/fonts/中）
        //Typeface face=Typeface.createFromAsset(getAssets(),"fonts/stxingkai.ttf");
        //tv.setTypeface(face);

        //设置文字内容
        tv.setText("测试\n这是一段测试文字，主要是为了测试竖直排版TextView的显示效果。" +
                "为了能更好的体验感受，我特意增加了比较接近书法的字体和颜色，如果有什么改进的建议请发邮件到我的邮箱吧。" +
                "\n竖直排版的TextView需要配合HorizontalScrollView使用才能有更佳的效果。当然，如果你有时间的话，也可以给这个类" +
                "加上滚动的功能。" + "\n " + "测试\n这是一段测试文字，主要是为了测试竖直排版TextView的显示效果。" +
                "为了能更好的体验感受，我特意增加了比较接近书法的字体和颜色，如果有什么改进的建议请发邮件到我的邮箱吧。" +
                "\n竖直排版的TextView需要配合HorizontalScrollView使用才能有更佳的效果。当然，如果你有时间的话，也可以给这个类" +
                "加上滚动的功能。");
    }
}
