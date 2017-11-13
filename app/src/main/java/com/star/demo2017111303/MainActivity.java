package com.star.demo2017111303;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOMemoryImpl;
import com.star.demo2017111303.Data.StudentDAOTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//        StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
//        t.add(new Student("Bob", "123", "aabb"));
//        t.add(new Student("Mary", "234", "ccdd"));
//
//        Student[] mylist = t.getData();
//        for (Student s: mylist)
//        {
//            Log.d("DATAS", s.toString());
//        }
//
//        Student editStudent = mylist[0];
//        editStudent.tel = "987";
//        t.updata(editStudent);
//
//        Student[] mylist1 = t.getData();
//        for (Student s: mylist1)
//        {
//            Log.d("DATAS", "update:" + s.toString());
//        }
    }
}
