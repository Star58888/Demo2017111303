package com.star.demo2017111303;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.star.demo2017111303.Data.Student;
import com.star.demo2017111303.Data.StudentDAOFileImp1;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Star on 2017/11/15.
 */
@RunWith(AndroidJUnit4.class)
    public class MyDAOFileTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImp1 dao = new StudentDAOFileImp1(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);

    }
}