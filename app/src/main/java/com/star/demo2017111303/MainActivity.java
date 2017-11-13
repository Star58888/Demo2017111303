package com.star.demo2017111303;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOMemoryImpl;

public class MainActivity extends AppCompatActivity {
    public static StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
    RecyclerView  mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        t.add(new Student("Bob", "123", "123"));
        t.add(new Student("Mary", "123", "123"));




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

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mAdapter = new MyAdapter(MainActivity.this , t.getData());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this , AddActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
