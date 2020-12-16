package com.example.dao.impl;

import com.example.controller.vo.DelVO;
import com.example.dao.entity.Emp;
import com.example.dao.entity.User;
import com.example.dao.idao.IEmpDao;
import com.example.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {

    @Override
    public List<Emp> findByPage(int start, int size) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp limit ?,?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,start);
        ps.setInt(2,size);
        ResultSet rs=ps.executeQuery();
        List<Emp> emps=new ArrayList<Emp>();
        while (rs.next()){
            Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp where ename like ?";
        //String sql="select empno,ename,hiredate,sal from emp where ename like concat('%',?,'%')";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,"%"+ename+"%");
        //ps.setString(1,ename);
        ResultSet rs=ps.executeQuery();
        List<Emp> emps=new ArrayList<Emp>();
        while (rs.next()){
            Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public Emp findById(Integer empno) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,empno);
        ResultSet rs=ps.executeQuery();
        Emp emp=null;
        while (rs.next()){
            emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
        }
        DBUtil.close(rs,ps,con);
        return emp;
    }

    @Override
    public void delete(Emp emp) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="delete from emp where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        ps.executeUpdate();
    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="insert into emp(ename,hiredate,sal) values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con= DBUtil.getConnection();
        String sql="update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public List<Emp> findByDept(int deptno) throws Exception{
        Connection con= DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp where deptno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,deptno);
        ResultSet rs=ps.executeQuery();
        List<Emp> emps=new ArrayList<Emp>();
        while (rs.next()){
            Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public void delBatch(List<DelVO> delVOList) throws Exception {
        Connection con=DBUtil.getConnection();
        StringBuilder builder=new StringBuilder("delete from emp where empno in (");
        for (int i=0;i<delVOList.size();i++){
            if (i==delVOList.size()-1){
                builder.append(delVOList.get(i).getEmpno()+")");
            }
            else {
                builder.append(delVOList.get(i).getEmpno()+",");
            }
        }
        String sql=builder.toString();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
//        Connection con= DBUtil.getConnection();
//        con.setAutoCommit(false);//1、关闭自动提交
//        Statement ps=con.createStatement();
//        try {
//            for(DelVO dv:delVOList){
//                String sql="delete from emp where empno=" +dv.getEmpno();
//                ps.addBatch(sql);
//            }
//            ps.executeBatch();
//            con.commit();//2、执行成功，手动提交
//        }catch (Exception e){
//            e.printStackTrace();
//            con.rollback();//3、出现异常，数据库回滚
//        }
//        DBUtil.close(null,ps,con);
    }
}
