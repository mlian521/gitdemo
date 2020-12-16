package com.example.service.impl;

import com.example.common.Comm;
import com.example.common.Res;
import com.example.common.ResEnum;
import com.example.dao.entity.Dept;
import com.example.dao.factory.DaoFactory;
import com.example.dao.idao.IDeptDao;
import com.example.service.iservice.IDeptService;

import java.util.ArrayList;
import java.util.List;

public class DeptServiceImpl implements IDeptService {
    IDeptDao deptDao;
    public DeptServiceImpl(){
        deptDao= (IDeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts=new ArrayList<Dept>();


        try {
            depts=deptDao.findAll();
           // System.out.println(depts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (depts.size()>0){
           // System.out.println("RRRRR"+depts);

            //Res<List<Dept>> deptw=Res.success(ResEnum.SUCCESS,depts);
            //System.out.println("55555*****"+deptw.getData());
            return Res.success(ResEnum.SUCCESS,depts);
        }
        else {
            return Res.error();
        }

    }
}
