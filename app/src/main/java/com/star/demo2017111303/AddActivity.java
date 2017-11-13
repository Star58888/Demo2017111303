package com.star.demo2017111303;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.MainActivity;
import com.star.demo2017111303.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void clickAdd(View v)
    {
        EditText ed1 = (EditText) findViewById(R.id.editText);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        EditText ed3 = (EditText) findViewById(R.id.editText3);
        MainActivity.t.add(new Student(ed1.getText().toString() , ed2.getText().toString() , ed3.getText().toString() ));
        finish();
    }
}
