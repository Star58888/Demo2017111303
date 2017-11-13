package com.star.demo2017111303.Data;

/**
 * Created by Star on 2017/11/13.
 */

public interface StudentDAO {
    void add(Student s);
    String[] getData();
    void updata(Student s);
}
