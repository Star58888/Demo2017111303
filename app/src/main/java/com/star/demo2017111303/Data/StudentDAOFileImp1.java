package com.star.demo2017111303.Data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Star on 2017/11/15.
 */

public class StudentDAOFileImp1 implements StudentDAO{
    ArrayList<Student> data = new ArrayList<>();
    Context context;   //getFilesDir() : StudentDAO自己建的類別沒,所以傳Context進來,
    String DATA_FILE;
    int MaxID;
    public StudentDAOFileImp1(Context context)
    {
        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
        data = new ArrayList<>();
        loadData();
    }
    private void saveData()
    {
        try {
            FileWriter fw = new FileWriter(DATA_FILE);
            Gson gson = new Gson();
            String str =gson.toJson(data);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData()
    {
        try {
            FileReader fr = new FileReader(DATA_FILE);
            BufferedReader br = new BufferedReader(fr);
            String str =br.readLine();
            br.close();
            fr.close();
            System.out.println("string:" + str);
            if (str.trim().length() > 0)
            {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
                data = gson.fromJson(str, listType);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.size() > 0)
        {
            MaxID = data.get(0).id;
        }
        for (Student s : data)
        {
            if (MaxID < s.id)
            {
                MaxID = s.id;
            }
        }
        MaxID ++;
    }
    @Override
    public void add(Student s) {
        data.add(s);
        saveData();
    }

    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void update(Student s) {
        for (Student tmp : data)
        {
            if (tmp.id == s.id)
            {
                tmp.name = s.name;
                tmp.tel = s.tel;
                tmp.addr = s.addr;
            }
        }
        saveData();
    }

    @Override
    public void delete(Student s) {
        for (int i = data.size() -1; i >= 0 ; i--)
        {
            if (data.get(i).id == s.id )
            {
                data.remove(i);
                break;
            }
        }
        saveData();
    }

    @Override
    public void clear() {
        data.clear();
        saveData();
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
