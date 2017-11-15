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

    @Override
    public void delete(Student s)  //delete forech不可對list長短做更動
    {
        for (int i = data.size() -1 ; i > 0; i--)
        {
            if(data.get(i).id == s.id)
            {
                data.remove(i);
                break;
            }
        }
    }
    @Override
    public  Student[] searchByName(String name) {
       ArrayList<Student> tmpLisit = new ArrayList<>();
        for (Student tmp : data)
        {
            if (tmp.name.equals(name))
            {
                tmpLisit.add(tmp);
            }
        }
        return tmpLisit.toArray(new Student[tmpLisit.size()]);
    }

    @Override
    public Student getOneStudent(int id) {
        for (Student tmp :data)
        {
            if (tmp.id == id)
            {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        data.clear();
    }
}
