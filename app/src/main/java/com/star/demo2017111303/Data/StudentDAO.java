package com.star.demo2017111303.Data;

/**
 * Created by Star on 2017/11/13.
 */

public interface StudentDAO {
    void add(Student s);
    Student[] getData();
    void update(Student s);
    void delete(Student s);
    void clear();
    Student getOneStudent(int id);
    Student[] searchByName(String name);
}
