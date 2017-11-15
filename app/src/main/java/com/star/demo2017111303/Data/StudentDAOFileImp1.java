package com.star.demo2017111303.Data;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Star on 2017/11/15.
 */

public class StudentDAOFileImp1 implements StudentDAO{
    ArrayList<Student> data = new ArrayList<>();
    Context context;   //getFilesDir() : StudentDAO自己建的類別沒,所以傳Context進來,才有
    String DATA_FILE;

    public StudentDAOFileImp1(Context context)
    {
        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
    }

    @Override
    public void add(Student s) {

    }

    @Override
    public Student[] getData() {
        return new Student[0];
    }

    @Override
    public void updata(Student s) {

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
