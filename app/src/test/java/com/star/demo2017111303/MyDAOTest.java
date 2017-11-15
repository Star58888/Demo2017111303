package com.star.demo2017111303;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOMemoryImpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Star on 2017/11/15.
 */

public class MyDAOTest {
    @Test
    public void MyTest1() {
        assertEquals(3 + 3, 6);
    }

    @Test
    public void TestMemoryDAO1() {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 3);
    }
    @Test
    public void TestMemoryDAO2() {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus[2].name, "CC");
    }
}
