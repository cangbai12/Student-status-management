package com.example.he.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.he.studenmanagement.R;

/**
 * 管理员的管理界面

 */
public class admin_activity extends Activity {

    private Button select;//查询学生信息按钮
    private Button add;//添加学生信息按钮
    private Button order;//查看总成绩排名按钮
    private TextView forceOffline;//强制下线

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_layout);

        select = (Button) findViewById(R.id.admin_activity_select);
        add = (Button) findViewById(R.id.admin_activity_add);
        order = (Button) findViewById(R.id.admin_activity_order);
        forceOffline = (TextView) findViewById(R.id.admin_activity_forceOffline);
//点击跳转到查询学生界面
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_activity.this, studentInfo_activity.class);
                startActivity(intent);

            }
        });
//点击跳转到添加学生界面
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_activity.this, addStudent_info_activity.class);
                intent.putExtra("haveData","false");
                startActivity(intent);
            }
        });

//点击跳转到排序界面
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(admin_activity.this,student_total_score.class);
                startActivity(intent);
            }
        });


        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.he.example.OfflineBradcast");
                sendBroadcast(intent);
            }
        });


    }
}
