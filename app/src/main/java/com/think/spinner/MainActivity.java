package com.think.spinner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.demonstrate.DialogUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            dialog();
        }
    }

    private void dialog() {
        DialogUtil.showListDialog(this, "Spinner的使用", new String[]{
                "0布局属性获取数据集合",
                "1ArrayAdapter中获取数据集合",
                "2BaseAdapter中获取数据集合,下拉菜单展示",
                "3BaseAdapter中获取数据集合弹出框展示",

        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, SpinnerDemo1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, SpinnerDemo2Activity.class));
                        break;
                    case 2:
                        Intent intentDialog = new Intent(MainActivity.this, SpinnerDemo3Activity.class);
                        intentDialog.putExtra("mode", Spinner.MODE_DROPDOWN);
                        startActivity(intentDialog);
                        break;
                    case 3:
                        Intent intentDropdown = new Intent(MainActivity.this, SpinnerDemo3Activity.class);
                        intentDropdown.putExtra("mode", Spinner.MODE_DIALOG);
                        startActivity(intentDropdown);
                        break;
                }
            }
        });
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(MainActivity.this);
    }
}
