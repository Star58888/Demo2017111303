package com.star.demo2017111303.Data;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Star on 2017/12/4.
 */

public class StudentDAOCloudImpl implements StudentDAO {
    ArrayList<Student> data;
    Context context;

    FirebaseDatabase database;
    DatabaseReference myRef;
    final String TAG = "ClondImpl";
    public StudentDAOCloudImpl(Context context)
    {
        this.context = context;
        data = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("studentdata");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    public void add(Student s) {
    }

    @Override
    public Student[] getData() {
        return new Student[0];
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Student getOneStudent(int id) {
        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        return new Student[0];
    }
}
