package com.example.daquexian.flexiblerichtextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daquexian.flexiblerichtextview.Attachment;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.daquexian.flexiblerichtextview.Tokenizer;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String text = "如图则图中阴影部分的面积为则图中阴影部分的面积为（）![猜猜猜](https://luoji.oss-cn-qingdao.aliyuncs.com/math%2F2008J-7.png)则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AjLatexMath.init(this);

        FlexibleRichTextView frtv3 = findViewById(R.id.frtv_3);
        frtv3.setText(text);

        FlexibleRichTextView frtv5 = findViewById(R.id.frtv_5);
        frtv5.setText(text);

        FlexibleRichTextView frtv = findViewById(R.id.frtv);
        frtv.setText(text);

        FlexibleRichTextView frtv_only_text = findViewById(R.id.frtv_only_text);
        frtv_only_text.setText(text);
    }
}