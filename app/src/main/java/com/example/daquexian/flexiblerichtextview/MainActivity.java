package com.example.daquexian.flexiblerichtextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daquexian.flexiblerichtextview.FlexibleRichTextView;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String text = "![猜猜猜](https://luoji.oss-cn-qingdao.aliyuncs.com/math%2F2008J-7.png)则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为则图中阴影部分的面积为";
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AjLatexMath.init(this);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter();
        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
            }
        });
        rv.setAdapter(adapter);

        List<String> list = new ArrayList<>();
        list.add("要使$3x^{2} + (m - 5)x + m^{2} - m - 2 = 0$\n的两根分别满足：$0 < x_{1} < 1,1 < x_{2} < 2.$\n\n（1）$- 2 < m < 0$\n\n（2）$- 3 < m < - \\frac{3}{2}$ ." + text);
        list.add("方程$4{x^2} + (a - 2)x + a - 5 = 0$有两个不等的负实根。\n（1）$a < 6$\n（2）$a > 5$" + text);
        list.add("若函数$f\\left( x \\right) = x^{2} - mx + 1$的两个零点为$\\alpha，\\beta$且$0 < \\alpha < 1 < \\beta < 2$，则$m$的取值范围为（\n）" + text);
        list.add("高速公路假期免费政策带动了京郊旅游的增长。据悉,2014年春节7天假期,北京市乡村民俗旅游接待游客约697000人次,比去年同期增长14%,则去年大约接待游客人次为（  ）" + text);
        list.add("设a,b,c是小于12的三个不同的质数（素数）,且$|a - b| + |b - c| + |c - a| = 8$,则$a + b + c = $（  ）" + text);
        list.add("$\\frac{{(1 + 3)(1 + {3^2})(1 + {3^4})(1 + {3^8})...(1 + {3^{32}}) + \\frac{1}{2}}}{{3 \\times {3^2} \\times {3^3} \\times ... \\times {3^{10}}}} = $（  ）" + text);
        list.add("甲、乙、丙三个容器中装有盐水.现将甲容器中盐水的$\\frac{1}{3}$倒入乙容器,摇匀后将乙容器中盐水的$\\frac{1}{4}$倒入丙容器,摇匀后再将丙容器中盐水的$\\frac{1}{10}$倒回甲容器,此时甲、乙、丙三个容器中盐水的含盐量都是9千克.则甲容器中原来的盐水含盐量是（  ）千克." + text);
        list.add("有一个两位正整数，有6个正整数因数，其中最小的三个因数之和是10，求此两位数。" + text);
        list.add("设$m$，$n$都是自然数，则$m = 2$ （ ）\n\n（1）$n \\neq 2$，$m + n$都为奇数\n\n（2）$m$，$n$都是质数\n" + text);
        list.add("电影开演时观众中女士与男士人数之比为5：4，开演后无观众入场，放映一小时后，女士的20%，男士的15%离场，则此时在场的女士与男士人数之比为（  ）" + text);
        list.add("健身房中,某个周末下午3:00,参加健身的男士与女士人数之比为3:4,下午5:00,男士中有25%,女士中有50%离开了健身房,此时留在健身房内的男士与女士人数之比是（   ）" + text);
        adapter.setList(list);

        final FlexibleRichTextView tv = findViewById(R.id.frtv);
        tv.setText("要使$3x^{2} + (m - 5)x + m^{2} - m - 2 = 0$\n的两根分别满足：$0 < x_{1} < 1,1 < x_{2} < 2.$\n\n（1）$- 2 < m < 0$\n\n（2）$- 3 < m < - \\frac{3}{2}$ .");
        findViewById(R.id.tv_change_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.changeTextColor(Color.RED);
            }
        });
    }

    private static class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
        private List<String> list = null;

        private View.OnClickListener listener = null;

        void setListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        void setList(List<String> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.frtv.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            private final FlexibleRichTextView frtv;

            Holder(View itemView) {
                super(itemView);
                frtv = itemView.findViewById(R.id.frtv);
                itemView.setOnClickListener(listener);
            }
        }
    }
}