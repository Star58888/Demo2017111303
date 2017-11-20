package com.star.demo2017111303.Data;

import android.content.Context;

/**
 * Created by Star on 2017/11/20.
 */

public class StudentDAOFactory {
    public static StudentDAO getStudentDAO(int type , Context context)
    {
        switch (type)
        {
            case 1:
                return new StudentDAOMemoryImpl();
            case 2:
                return new StudentDAOFileImpl(context);
        }
        return null;
    }
}
