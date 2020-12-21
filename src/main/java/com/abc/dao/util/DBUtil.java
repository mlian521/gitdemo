package com.abc.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {

    private static DataSource ds=new ComboPooledDataSource("dao_c3p0");

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");//mysql公司开发的符合jdbc标准的驱动
        return ds.getConnection();
    }

    public static void close(ResultSet rs, Statement ps, Connection con) throws SQLException {
        if (rs!=null) rs.close();
        if (ps!=null) ps.close();
        if (con!=null) con.close();

    }
}
