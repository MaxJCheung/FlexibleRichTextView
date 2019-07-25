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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // train classifier on app start
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.

        List<Attachment> attachments = new ArrayList<>();
//        attachments.add(new ExampleAttachment("Android Image", "53ce1", true, "http://tse1.mm.bing.net/th?id=OIP.M24baa78c1fb80a71891ce775d11e038ao0&w=166&h=166&c=7&qlt=90&o=4&pid=1.7"));
//        attachments.add(new ExampleAttachment("Here is a link", "bc41a", false, "https://google.com"));

        FlexibleRichTextView flexibleRichTextView = (FlexibleRichTextView) findViewById(R.id.frtv);
        Tokenizer.setCenterStartLabels("<center>");
        Tokenizer.setCenterEndLabels("</center>");
        Tokenizer.setTitleStartLabels("<h>");
        Tokenizer.setTitleEndLabels("</h>");

        flexibleRichTextView.setText("如图所示长方形ABCD中的AB=10cm，BC=5cm，设AB和AD分别为半径作半圆，则图中阴影部分的面积为（  ）\\n ![猜猜猜](https://luoji.oss-cn-qingdao.aliyuncs.com/math%2F2008J-7.png)",
                attachments);
    }
}