package com.star.demo2017111303;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentDAOTest1 t = new StudentDAOTest1();
        t.add(new Student("Bob" , "123" , "aabb"));
        t.add(new Student("Mary", "234", "ccdd"));

        ArrayList<Student> mylist = t.getData();
        for (Student s: mylist)
        {
            Log.d("DATAS", s.toString());
        }

        Student editStudent =mylist.get(0);
        editStudent.tel = "987";

        ArrayList<Student> mylist1 = t.getData();
        for (Student s: mylist1)
        {
            Log.d("DATAS", "updata: " + s.toString());
        }
    }
}
