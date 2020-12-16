package com.example.service.factory;

import com.example.common.Comm;
import com.example.service.impl.DeptEmpServiceImpl;
import com.example.service.impl.DeptServiceImpl;
import com.example.service.impl.EmpServiceImpl;
import com.example.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static Object getInstance(String serviceName){
        switch (serviceName){
            case Comm.USER:
                return new UserServiceImpl();
            case Comm.EMP:
                return new EmpServiceImpl();
            case Comm.DEPT:
                return new DeptServiceImpl();
            case Comm.DEPT_EMP_REPORT:
                return new DeptEmpServiceImpl();
            default:
                return null;
        }

    }
}
