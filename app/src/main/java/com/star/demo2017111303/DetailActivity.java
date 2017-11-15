package com.star.demo2017111303;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView  tv2 ,tv3 ,tv4 ,tv5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
        int id = getIntent().getIntExtra("id" , -1);
        Student stu = MainActivity.t.getOneStudent(id);
        tv2.setText(String.valueOf(stu.id));
        tv3.setText(stu.name);
        tv4.setText(stu.tel);
        tv5.setText(stu.addr);

    }
}
