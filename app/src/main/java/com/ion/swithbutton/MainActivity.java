package com.ion.swithbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout container;
    private View background;
    private TextView tv1;
    private TextView tv2;

    private int background_w = 0;
    private int container_w = 0;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-09-19 16:56:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        container = (RelativeLayout) findViewById(R.id.container);
        background = (View) findViewById(R.id.background);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1.setClickable(false);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTextColor(getResources().getColor(R.color.white));
                tv2.setTextColor(getResources().getColor(R.color.grey));
                background_w = background.getWidth();
                container_w = container.getWidth();
                int x = container_w - background_w;
                Log.i("tag", "onClick: " + "backgroud =%d%n" + background_w);
                ObjectAnimator animator = new ObjectAnimator().ofFloat(background, "translationX", x, 0);
                tv1.setClickable(false);
                tv2.setClickable(true);
                animator.setDuration(200);
                animator.start();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setClickable(false);
                tv1.setClickable(true);
                tv2.setTextColor(getResources().getColor(R.color.white));
                tv1.setTextColor(getResources().getColor(R.color.grey));
                background_w = background.getWidth();
                container_w = container.getWidth();
                int x = container_w - background_w;
                Log.i("tag", "onClick: " + "backgroud =%d%n" + background_w);
                ObjectAnimator animator = new ObjectAnimator().ofFloat(background, "translationX", 0, x);
                animator.setDuration(200);
                animator.start();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
}
