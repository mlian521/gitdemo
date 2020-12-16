package com.example.dao.impl;

import com.example.dao.entity.Dept;
import com.example.dao.entity.Emp;
import com.example.dao.idao.IDeptDao;
import com.example.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements IDeptDao {
    @Override
    public List<Dept> findAll() throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="select deptno,dname from dept";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Dept> depts=new ArrayList<Dept>();
        while (rs.next()){
            Dept dept=new Dept();
           // System.out.println("%%%%%%%%%%%%%%1");
            dept.setDeptno(rs.getInt(1));
            dept.setDname(rs.getString(2));
            depts.add(dept);
        }
       // System.out.println(depts);
        DBUtil.close(rs,ps,con);
        return depts;
    }
}
