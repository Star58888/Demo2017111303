package com.star.demo2017111303.Data;

import java.util.ArrayList;

/**
 * Created by Star on 2017/11/13.
 */

public class StudentDAOMemoryImpl implements StudentDAO {
    ArrayList<Student> data = new ArrayList();
    int MaxID = 1;
    @Override
    public void add(Student s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
    }

    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void updata(Student s) {
        for (Student tmp : data)
        {
            if (tmp.id == s.id)
            {
                tmp.name = s.name;
                tmp.tel = s.tel;
                tmp.addr = s.addr;
            }
        }
    }
}
