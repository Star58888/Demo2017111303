package com.star.demo2017111303;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOFileImp1;
import com.star.demo2017111303.Data.StudentDAOMemoryImpl;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
//    public static StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
    public static StudentDAOFileImp1 t;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    GestureDetector mGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = new StudentDAOFileImp1(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        t.add(new Student("Bob", "123", "123"));
//        t.add(new Student("Mary", "123", "123"));
        mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        }
        );
        mRecyclerView.addOnItemTouchListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new MyAdapter(MainActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(MainActivity.this, AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());
        Log.d("Touch", "onInterceptTouchEvent");
        if (mGD.onTouchEvent(e))
        {
            Log.d("Touch", "Single Tap up");
            int position = rv.getChildLayoutPosition(v);
            // Toast.makeText(MainActivity.this, "posi:" + position, Toast.LENGTH_SHORT).show();
            if (position >= 0)
            {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id", t.getData()[position].id);
                startActivity(it);
            }
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}