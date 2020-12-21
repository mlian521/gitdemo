package com.abc.demo;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection con= DBUtil.getConnection();
        //CallableStatement cs=con.prepareCall("call proc_saveBatch()");
        String sql="call proc_transfer_money(?,?,?)";
        CallableStatement cs=con.prepareCall(sql);
        cs.setString(1,"zhao");
        cs.setString(2,"li");
        cs.setBigDecimal(3,new BigDecimal("101"));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);
    }
}
