package com.javaweb.jdbc;

import java.sql.*;

public class DBUtil {
    private static Connection conn = null;
    public static Connection getConnection() {
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "6269131.x";
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(conn == null) {
            try {
                conn = DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("数据库连接失败！");
            }
        }
        return conn;
    }
}
