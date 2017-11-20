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
    public void TestMemoryDAO1()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);
    }
    @Test
    public void TestMemoryDAO2()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus[1].tel, "22");
    }
    @Test
    public void TestMemoryDAO3Update()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        Student s = stus[1];
        s.addr = "XYZ";
        dao.update(s);
        Student[] check = dao.getData();
        assertEquals(check[1].addr, "XYZ");
    }
    @Test
    public void TestMemoryDAO4Delete()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        Student s = stus[1];
        dao.delete(s);
        Student[] check = dao.getData();
        assertEquals(2, check.length);
    }
    @Test
    public void TestMemoryDAO5getOne()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student s = dao.getOneStudent(3);
        assertEquals(s.tel, "33");
    }
    @Test
    public void TestMemoryDAO6Search()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student s[] = dao.searchByName("BB");

        assertEquals(s[0].tel, "22");
    }
    @Test
    public void TestMemoryDAO7Search()
    {
        StudentDAOMemoryImpl dao = new StudentDAOMemoryImpl();
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        dao.add(new Student("CC", "44", "44bb"));
        Student s[] = dao.searchByName("CC");

        assertEquals(2, s.length);
    }
}

