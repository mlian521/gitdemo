package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.DeptDao;
import com.abc.service.iservice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("deptService")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    DeptDao deptDao;

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
