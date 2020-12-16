package com.example.dao.factory;

import com.example.common.Comm;
import com.example.dao.impl.DeptDaoImpl;
import com.example.dao.impl.EmpDaoImpl;
import com.example.dao.impl.ReportDeptEmpDaoImpl;
import com.example.dao.impl.UserDaoIml;

public class DaoFactory {
    public static Object getInstance(String daoName){
        switch (daoName){
            case Comm.USER:
                return new UserDaoIml();
            case Comm.EMP:
                return new EmpDaoImpl();
            case Comm.DEPT:
                return new DeptDaoImpl();
            case Comm.DEPT_EMP_REPORT:
                return new ReportDeptEmpDaoImpl();
            default:
                return null;
        }
    }
}
