package com.think.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDemo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int mode = getIntent().getIntExtra("mode", Spinner.MODE_DROPDOWN);
        if (mode == Spinner.MODE_DROPDOWN) {
            setContentView(R.layout.activity_spinner_mode_dropdown);
        } else {
            setContentView(R.layout.activity_spinner_mode_dialog);
        }
        //使用自定义的BaseAdapter
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("张三", "上海 "));
        persons.add(new Person("李四", "上海 "));
        persons.add(new Person("王五", "北京"));
        persons.add(new Person("赵六", "广州 "));
        //  建立Adapter绑定数据源
        MyAdapter pAdapter = new MyAdapter(this, persons);
        spinner3.setAdapter(pAdapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerDemo3Activity.this, "--->" + persons.get(position).getName() + "--" + persons.get(position).getCity(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
