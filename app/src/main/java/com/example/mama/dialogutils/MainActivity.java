package com.example.mama.dialogutils;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Button btn,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(btn,1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(btn2,2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(btn3,3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(btn4,4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(btn5,5);
            }
        });
    }


    private void showDialog(View viewss,int type) {

        View popupView = getLayoutInflater().inflate(R.layout.dialoglayout, null);
        // 创建PopupWindow对象，指定宽度和高度
        PopupWindow window = new PopupWindow(popupView, 600,600);
        // 设置动画
        if(type==1){
            window.setAnimationStyle(R.style.popup_window_anim_top);
        }else if(type==2){
            window.setAnimationStyle(R.style.popup_window_anim_right);
        }else if(type==3){
            window.setAnimationStyle(R.style.popup_window_anim_bottom);
        }else if(type==4){
            window.setAnimationStyle(R.style.popup_window_anim_left);
        }else if(type==5){
            window.setAnimationStyle(R.style.popup_window_anim_bottom_shad);
        }
        // 设置背景颜色
        //Color.parseColor("#F8F8F8")
        window.setBackgroundDrawable(new ColorDrawable());
        // 设置可以获取焦点
        window.setFocusable(true);
        // 设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // 更新popupwindow的状态
        window.update();

        // 以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(viewss, 0,0, Gravity.CENTER);

    }
}
