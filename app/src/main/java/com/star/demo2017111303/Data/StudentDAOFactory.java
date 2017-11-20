package com.star.demo2017111303.Data;

import android.content.Context;

/**
 * Created by Star on 2017/11/20.
 */

public class StudentDAOFactory {
    public static StudentDAO getStudentDAO(DAOType type , Context context)
    {
        switch (type)
        {
            case MEMORY:
                return new StudentDAOMemoryImpl();
            case FILE:
                return new StudentDAOFileImpl(context);
            case DB:
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
